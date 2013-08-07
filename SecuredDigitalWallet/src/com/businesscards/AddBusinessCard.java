package com.businesscards;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.secureddigitalwallet.R;
import com.example.secureddigitalwallet.TabHostActivity;

import contactInformation.Address;
import contactInformation.CardHolder;
import contactInformation.PhoneNumber;

public class AddBusinessCard extends Activity{
	private static String TAG = "AddBusinessCard";
	private static int numberCount=1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.card_details);
		Log.d(TAG, " onCreate");
		final EditText firstName = (EditText) findViewById(R.id.firstName);
		final EditText middleName = (EditText) findViewById(R.id.middleName);
		final EditText lastName = (EditText) findViewById(R.id.lastName);
		final EditText companyName = (EditText) findViewById(R.id.companyName);

		LinearLayout phoneNumberLayout = (LinearLayout) findViewById(R.id.phoneNumberLayout);

		final EditText streetLine1 = (EditText) findViewById(R.id.streetLine1);
		final EditText streetLine2 = (EditText) findViewById(R.id.streetLine2);
		final EditText city = (EditText) findViewById(R.id.city);
		final EditText state = (EditText) findViewById(R.id.state);
		final EditText postalCode = (EditText) findViewById(R.id.postalCode);
		final EditText country = (EditText) findViewById(R.id.country);

		final EditText phoneNumber = (EditText) findViewById(R.id.phoneNumber);
		Spinner numberType = (Spinner) findViewById(R.id.chooseNumberType);

		Button addCard = (Button) findViewById(R.id.Done); 
		Button cancel = (Button) findViewById(R.id.Cancel);
		addCard.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				CardHolder contact = new CardHolder();
				contact.setFirstName((String) firstName.getText().toString());
				contact.setMiddleName((String) middleName.getText().toString());
				contact.setLastName((String) lastName.getText().toString());
				contact.setCompanyName((String) companyName.getText().toString());

				Address contactAddress = new Address();
				contactAddress.setStreetLine1( streetLine1.getText().toString());
				contactAddress.setStreetLine2((String) streetLine2.getText().toString());
				contactAddress.setCity((String) city.getText().toString());
				contactAddress.setState((String) state.getText().toString());
				contactAddress.setCountry((String) country.getText().toString());
				contactAddress.setPostalCode(Integer.parseInt(postalCode.getText().toString()));

				contact.setCompanyAddress(contactAddress);

				//logic to add all the numbers entered by the user
				for(int i=0;i<numberCount;i++){
					PhoneNumber number = new PhoneNumber();
					number.setContactNumber(Integer.parseInt(phoneNumber.getText().toString()));
					contact.setContactNumber(number);
				}
			}
		});
		cancel.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				AlertDialog.Builder cancelDialog = new AlertDialog.Builder(AddBusinessCard.this);
				cancelDialog.setMessage("Are you sure you want to cancel ? ").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						Intent startBusinessCardActivity = new Intent();
						startBusinessCardActivity.setClass(AddBusinessCard.this, TabHostActivity.class);
						startActivity(startBusinessCardActivity);
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
	}
}
