package com.example.applicationbackend;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import dataBaseConnectivity.DBContract.AddressTable;
import dataBaseConnectivity.DBContract.ContactNumbersTable;
import dataBaseConnectivity.DBContract.ContactTable;
import dataBaseConnectivity.DBUtilities;
import dataBaseConnectivity.InitiateDB;

public class MainActivity extends Activity {
	private String TAG = "MainActivity";
	public static SQLiteDatabase writableDatabase ;
	public DBUtilities utilities = new DBUtilities();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Log.d(TAG, "in onCreate ");
		//time to make the db and initiate the tables
		//initiate the DB request 
		InitiateDB mDbHelper = new InitiateDB(getApplicationContext());
		writableDatabase = mDbHelper.getWritableDatabase();
		
		Button addContact = (Button) findViewById(R.id.addContactButton);
		Button addNumbers = (Button) findViewById(R.id.addNumbers);
		Button addAddress = (Button) findViewById(R.id.addAddress);

		addContact.setOnClickListener(new View.OnClickListener() {
			//TODO inserting hard coded values for now. when integrated with UI part, the actual values should be checked and then populated in the DB
			public void onClick(View v) {
				Log.d(TAG,"in on click inserting values ");
				ContentValues insertValues = new ContentValues();
				insertValues.put(ContactTable.COLUMN_NAME_CONTACT_ID ,"12323");
				insertValues.put(ContactTable.COLUMN_NAME_FIRST_NAME ,"fn");
				insertValues.put(ContactTable.COLUMN_NAME_MIDDLE_NAME ,"mn");
				insertValues.put(ContactTable.COLUMN_NAME_LAST_NAME ,"ln");
				insertValues.put(ContactTable.COLUMN_NAME_COMPANY ,"company");
				insertValues.put(ContactTable.COLUMN_NAME_WORK_EMAIL ,"asdaw");
				insertValues.put(ContactTable.COLUMN_NAME_PERSONAL_EMAIL ,"asdw");
				insertValues.put(ContactTable.COLUMN_NAME_WEBSITE ,"asd");
				Log.d(TAG,"inserting values in contacts table "+insertValues.size()); 
				utilities.insertRowInDB(writableDatabase,ContactTable.TABLE_NAME , null, insertValues);
			}
		});

		addNumbers.setOnClickListener(new View.OnClickListener() {
			//TODO inserting hard coded values for now. when integrated with UI part, the actual values should be checked and then populated in the DB
			public void onClick(View v) {
				Log.d(TAG,"in on click inserting values ");
				ContentValues insertValues = new ContentValues();
				insertValues.put(ContactNumbersTable.COLUMN_NAME_CONTACT_ID ,"12323");
				insertValues.put(ContactNumbersTable.COLUMN_NAME_OFFICE_NUMBER ,"12323");
				insertValues.put(ContactNumbersTable.COLUMN_NAME_MOBILE_NUMBER ,"12323");
				insertValues.put(ContactNumbersTable.COLUMN_NAME_FAX_NUMBER ,"12323");
				insertValues.put(ContactNumbersTable.COLUMN_NAME_PAGER_NUMBER ,"12323");
				insertValues.put(ContactNumbersTable.COLUMN_NAME_OTHER_NUMBER,"12323"); 
				Log.d(TAG,"inserting values in numbers table "+insertValues.size()); 
				utilities.insertRowInDB(writableDatabase,ContactNumbersTable.TABLE_NAME , null, insertValues);
			}
		});

		addAddress.setOnClickListener(new View.OnClickListener() {
			//TODO inserting hard coded values for now. when integrated with UI part, the actual values should be checked and then populated in the DB
			public void onClick(View v) {
				Log.d(TAG,"in on click inserting values ");
				ContentValues insertValues = new ContentValues();
				insertValues.put(AddressTable.COLUMN_NAME_CONTACT_ID ,"12323");
				insertValues.put(AddressTable.COLUMN_NAME_STREET_LINE_1 ,"mn");
				insertValues.put(AddressTable.COLUMN_NAME_STREET_LINE_2 ,"mn");
				insertValues.put(AddressTable.COLUMN_NAME_CITY ,"mn");
				insertValues.put(AddressTable.COLUMN_NAME_STATE ,"mn");
				insertValues.put(AddressTable.COLUMN_NAME_COUNTRY,"mn");
				insertValues.put(AddressTable.COLUMN_NAME_POSTALCODE ,"mn");
				Log.d(TAG,"inserting values in address table "+insertValues.size());
				utilities.insertRowInDB(writableDatabase,AddressTable.TABLE_NAME , null, insertValues);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
