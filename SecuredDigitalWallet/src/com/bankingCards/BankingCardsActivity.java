package com.bankingCards;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.secureddigitalwallet.LockFragment;
import com.example.secureddigitalwallet.R;

public class BankingCardsActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.business_card_layout);

		final ListView listview = (ListView) findViewById(R.id.listview);
		final String[] values = new String[] { "Axis Bank", "SBI Bank", "HDFC Bank",
				"HSBC Bank", "IDBI Bank", "ICICI Bank"};

		final ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < values.length; ++i) {
			list.add(values[i]);
		}
		final BankingCardsAdapter adapter = new BankingCardsAdapter(this,
				android.R.layout.simple_list_item_1, list);
		listview.setAdapter(adapter);

		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, final View view,
					int position, long id) {
				Intent viewBankingcard = new Intent();
				viewBankingcard.setClass(BankingCardsActivity.this, ViewBankingcard.class);
//				startActivity(viewBankingcard);
				Toast.makeText(BankingCardsActivity.this,values[position]+" card selected",Toast.LENGTH_LONG).show();
				
//				final String item = (String) parent.getItemAtPosition(position);
//				view.animate().setDuration(2000).alpha(0)
//				.withEndAction(new Runnable() {
//					@Override
//					public void run() {
//						list.remove(item);
//						adapter.notifyDataSetChanged();
//						view.setAlpha(1);
//						
//					}
//				});
			}

		});
	}

	@Override
	protected void onResume() {

		LockFragment lock = new LockFragment();
		lock.show(getFragmentManager(), "HARSH");

		super.onResume();
	}
}
