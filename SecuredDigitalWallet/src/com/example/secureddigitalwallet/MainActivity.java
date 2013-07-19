package com.example.secureddigitalwallet;

import net.pocketmagic.android.carousel.CaraouselActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.example.testcoverflow.CoverFlowExample;
import com.i2a.datasolution.ViewPagerActivity;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button startingScreen = (Button) findViewById(R.id.startingScreen);
		Button createDatabases = (Button) findViewById(R.id.createDatabases);
		Button testCoverflow= (Button) findViewById(R.id.testCoverflow);
		Button navigation= (Button) findViewById(R.id.navigation);
		Button caraouselFlow= (Button) findViewById(R.id.caraouselFlow);
		startingScreen.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent startScreen = new Intent(getApplicationContext(), ViewPagerActivity.class);
				startActivity(startScreen);
			}
		});
		createDatabases.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent dbIntent = new Intent(getApplicationContext(), DatabaseActivity.class);
				startActivity(dbIntent);

			}
		});
		testCoverflow.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent coverFlowIntent = new Intent(getApplicationContext(), CoverFlowExample.class);
				startActivity(coverFlowIntent);
			}
		});
		navigation.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent navigationIntent = new Intent(getApplicationContext(), Navigation.class);
				startActivity(navigationIntent);
			}
		});
		caraouselFlow.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent caraouselIntent = new Intent(getApplicationContext(), CaraouselActivity.class);
				startActivity(caraouselIntent);
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
