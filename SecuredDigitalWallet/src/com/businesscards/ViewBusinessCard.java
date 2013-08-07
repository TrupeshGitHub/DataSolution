package com.businesscards;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

import com.example.secureddigitalwallet.NavigateContact;
import com.example.secureddigitalwallet.Navigation;
import com.example.secureddigitalwallet.R;

public class ViewBusinessCard extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.view_card);
		ImageButton navigation = (ImageButton) findViewById(R.id.navigateToContact);
		navigation.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			Intent mapActivity = new Intent();
			mapActivity.setClass(ViewBusinessCard.this, NavigateContact.class);
			startActivity(mapActivity);
			}
		});
		}
}

