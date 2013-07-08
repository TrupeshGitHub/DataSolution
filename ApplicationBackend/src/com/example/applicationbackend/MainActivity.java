package com.example.applicationbackend;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import dataBaseConnectivity.InitiateDB;

public class MainActivity extends Activity {
	private String TAG = "MainActivity";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.d(TAG, "in onCreate ");
		//time to form the make the db and initiate the tables
		//initiate the DB request 
		InitiateDB mDbHelper = new InitiateDB(getApplicationContext());
		SQLiteDatabase writableDatabase = mDbHelper.getWritableDatabase();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
