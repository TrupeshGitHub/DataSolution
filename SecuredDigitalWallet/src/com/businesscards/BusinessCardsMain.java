package com.businesscards;
/*
 * 3D carousel View
 * http://www.pocketmagic.net 
 *
 * Copyright (c) 2013 by Radu Motisan , radu.motisan@gmail.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 *
 * For more information on the GPL, please go to:
 * http://www.gnu.org/copyleft/gpl.html
 *
 */ 
import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.secureddigitalwallet.R;
import com.example.secureddigitalwallet.TabHostActivity;

public class BusinessCardsMain extends Activity implements OnItemSelectedListener {

	Singleton 				m_Inst 					= Singleton.getInstance();
	CarouselViewAdapter 	m_carouselAdapter		= null;	 
	private final int		m_nFirstItem			= 1000;
	ImageButton addCard;
	ImageButton deleteCard;
	ImageButton viewCard;
	ImageButton search;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//no keyboard unless requested by user
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		// compute screen size and scaling
		Singleton.getInstance().InitGUIFrame(this);

		int padding = m_Inst.Scale(10);
		// create the interface : full screen container
		RelativeLayout panel  = new RelativeLayout(this);
		panel.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
		panel.setPadding(padding, padding, padding, padding);
		panel.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, 
				new int[]{Color.WHITE, Color.GRAY}));
		setContentView(panel); 

		// copy images from assets to sdcard
		AppUtils.AssetFileCopy(this, "/mnt/sdcard/image01.png", "image01.png", false);
		AppUtils.AssetFileCopy(this, "/mnt/sdcard/image02.png", "image02.png", false);
		AppUtils.AssetFileCopy(this, "/mnt/sdcard/image03.png", "image03.png", false);

		//Create carousel view documents
		ArrayList<CarouselDataItem> Docus = new ArrayList<CarouselDataItem>();
		for (int i=0;i<1000;i++) {
			CarouselDataItem docu;
			//TODO make path using getExternalStorageDirectory
			if (i%4==0) docu = new CarouselDataItem("/mnt/sdcard/image01.png", 0, "First Image "+i);
			else if (i%4==1) docu = new CarouselDataItem("/mnt/sdcard/image02.png", 0, "Second Image "+i);
			else docu = new CarouselDataItem("/mnt/sdcard/image03.png", 0, "Third Image "+i);
			Docus.add(docu);
		} 

		// create the carousel
		CarouselView coverFlow = new CarouselView(this);

		// create adapter and specify device independent items size (scaling)
		// for more details see: http://www.pocketmagic.net/2013/04/how-to-scale-an-android-ui-on-multiple-screens/
		m_carouselAdapter =  new CarouselViewAdapter(this,Docus, m_Inst.Scale(400),m_Inst.Scale(300));
		coverFlow.setAdapter(m_carouselAdapter);
		coverFlow.setSpacing(-1*m_Inst.Scale(150));
		coverFlow.setSelection(Integer.MAX_VALUE / 2, true);
		coverFlow.setAnimationDuration(1000);
		coverFlow.setOnItemSelectedListener((OnItemSelectedListener) this);

		AppUtils.AddView(panel, coverFlow, LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT, 
				new int[][]{new int[]{RelativeLayout.CENTER_IN_PARENT}},
				-1, -1);

		addCard = new ImageButton(this);
		addCard.setBackgroundResource(R.drawable.add);
		//TODO hard coded value : make it generic
		AppUtils.AddView(panel, addCard, 100, 100, 
				new int[][]{new int[]{RelativeLayout.ALIGN_PARENT_LEFT}, new int[]{RelativeLayout.ALIGN_PARENT_TOP}}, -1,-1);

		deleteCard = new ImageButton(this);
		deleteCard.setBackgroundResource(R.drawable.delete);
		//TODO hard coded value : make it generic
		AppUtils.AddView(panel, deleteCard, 100, 100, 
				new int[][]{new int[]{RelativeLayout.ALIGN_PARENT_RIGHT}, new int[]{RelativeLayout.ALIGN_PARENT_TOP}}, -1,-1);

		viewCard = new ImageButton(this);
		viewCard.setBackgroundResource(R.drawable.view);
		//TODO hard coded value : make it generic
		AppUtils.AddView(panel, viewCard , 100, 100, 
				new int[][]{new int[]{RelativeLayout.ALIGN_PARENT_LEFT}, new int[]{RelativeLayout.ALIGN_PARENT_BOTTOM}}, -1,-1);

		search = new ImageButton(this);
		search.setBackgroundResource(R.drawable.ic_menu_search);
		//TODO hard coded value : make it generic
		AppUtils.AddView(panel, search, 100, 100, 
				new int[][]{new int[]{RelativeLayout.ALIGN_PARENT_RIGHT}, new int[]{RelativeLayout.ALIGN_PARENT_BOTTOM}}, -1,-1);
		addCard.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent startScreen = new Intent(getApplicationContext(), AddBusinessCard.class);
				startActivity(startScreen);
			}
		});
		
		deleteCard.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				AlertDialog.Builder cancelDialog = new AlertDialog.Builder(BusinessCardsMain.this);
				cancelDialog.setMessage("Are you sure you want to cancel ? ").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
//TODO logic to delete the selected card
						Toast.makeText(BusinessCardsMain.this, "Contact has been deleted", Toast.LENGTH_LONG).show();
					}
				}).setNegativeButton("No", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
					}
				});
				AlertDialog alert = cancelDialog.create();
				alert.show();
			}
		});
		
		viewCard.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent viewScreen = new Intent(getApplicationContext(), ViewBusinessCard.class);
				startActivity(viewScreen);
			}
		});
		
		search.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
			}
		});
	}

	public void afterTextChanged(Editable arg0) {}

	public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

	public void onTextChanged(CharSequence s, int start, int before, int count) {
		m_carouselAdapter.getFilter().filter(s.toString()); 
	}

	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		CarouselDataItem docu =  (CarouselDataItem) m_carouselAdapter.getItem((int) arg3);
	}

	public void onNothingSelected(AdapterView<?> arg0) {}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
MenuInflater optionsMenu = getMenuInflater();
optionsMenu.inflate(R.menu.business_card_main_options, menu);
		return super.onCreateOptionsMenu(menu);
	}


}
