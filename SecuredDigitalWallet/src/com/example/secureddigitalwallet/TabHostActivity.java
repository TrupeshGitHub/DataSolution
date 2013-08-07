package com.example.secureddigitalwallet;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Window;
import android.widget.TabHost;

import com.bankingCards.BankingCardsActivity;
import com.businesscards.BusinessCardsMain;
import com.passwordManager.PasswordManagerActivity;
import com.utils.Constants;

import dataBaseConnectivity.InitiateDB;

public class TabHostActivity extends TabActivity {
	public static SQLiteDatabase writableDatabase ;
	private static String TAG = "TabHostActivity";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_tab_host);
		
		//To be done in the launcher activity of the application
		InitiateDB mDbHelper = new InitiateDB(getApplicationContext());
		writableDatabase = mDbHelper.getWritableDatabase();
	
		Resources res = getResources(); // Resource object to get Drawables
		TabHost tabHost = getTabHost(); // The activity TabHost
		TabHost.TabSpec spec; // Reusable TabSpec for each tab
		Intent intent; // Reusable Intent for each tab

		intent = new Intent().setClass(this, BankingCardsActivity.class);
		spec = tabHost.newTabSpec("creditDebitCards")
				.setIndicator(Constants.CREDIT_DEBIT_CARD, res.getDrawable(R.drawable.ic_tab_about))
				.setContent(intent);
		tabHost.addTab(spec);
		intent = new Intent().setClass(this, BusinessCardsMain.class);
		spec = tabHost
				.newTabSpec("businessCards")
				.setIndicator(Constants.BUSINESS_CARD,
						res.getDrawable(R.drawable.ic_tab_contact))
				.setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, PasswordManagerActivity.class);
		spec = tabHost.newTabSpec("passwordManager")
				.setIndicator(Constants.PASSWORD_MANAGER, res.getDrawable(R.drawable.ic_tab_home))
				.setContent(intent);
		tabHost.addTab(spec);

		//set tab which one you want open first time 0 or 1 or 2
		tabHost.setCurrentTab(1);
		
		
	}
	
}