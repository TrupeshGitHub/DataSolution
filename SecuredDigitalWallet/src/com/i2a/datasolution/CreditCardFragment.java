package com.i2a.datasolution;

import java.util.ArrayList;

import net.pocketmagic.android.carousel.CaraouselActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.secureddigitalwallet.R;
import com.i2a.adapter.CreditCardListAdapter;
import com.i2a.adapter.SectionsPagerAdapter;

public class CreditCardFragment extends Fragment{

	private ArrayList<String> mCardNames = new ArrayList<String>();
	private String LOG_TAG = "CreditCardFragment";
	private CreditCardListAdapter mListAdapter = null;
	private SectionsPagerAdapter mSectionsAdapter = null;
	
	public ArrayList<String> getCardNames() {
		return mCardNames;
	}

	public void setCardNames(ArrayList<String> cardNames) {
		this.mCardNames = cardNames;
	}

	public CreditCardListAdapter getListAdapter() {
		return mListAdapter;
	}

	public void setListAdapter(CreditCardListAdapter listAdapter) {
		this.mListAdapter = listAdapter;
	}

	public SectionsPagerAdapter getmSectionsAdapter() {
		return mSectionsAdapter;
	}

	public void setSectionsAdapter(SectionsPagerAdapter sectionsAdapter) {
		this.mSectionsAdapter = sectionsAdapter;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		Log.d(LOG_TAG, "---onCreateView---");
		
		View rootView = inflater.inflate(R.layout.fragment_list_view, container, false);
		ListView listView = (ListView) rootView.findViewById(R.id.fragment_list);
		listView.setAdapter(mListAdapter);
		
		return rootView;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.d(LOG_TAG, "---onCreate---");
//		mListAdapter = new CreditCardListAdapter(getActivity().getApplicationContext());
//		
//		mCardNames.add("HDFC Credit Card");
//		mCardNames.add("AXIS BANK Debit Card");
//		mCardNames.add("AXIS BANK Credit Card");
//		mCardNames.add("ICICI Debit Card");
//		
//		mListAdapter.setContent(mCardNames);
		Intent caraouselIntent = new Intent(this.getActivity().getApplicationContext(), CaraouselActivity.class);
		startActivity(caraouselIntent);
		super.onCreate(savedInstanceState);
		
	}
}
