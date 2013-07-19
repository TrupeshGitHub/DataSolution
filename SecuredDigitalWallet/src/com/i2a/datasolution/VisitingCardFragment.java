package com.i2a.datasolution;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.secureddigitalwallet.R;
import com.i2a.adapter.SectionsPagerAdapter;
import com.i2a.adapter.VisitingCardListAdapter;

public class VisitingCardFragment extends Fragment{
	
	private String LOG_TAG = "VisitingCardFragment";
	
	private ArrayList<String> mOrgNames = new ArrayList<String>();
	private VisitingCardListAdapter mListAdapter = null;
	private SectionsPagerAdapter mSectionsAdapter = null; 
	
	public ArrayList<String> getOrgNames() {
		return mOrgNames;
	}

	public void setOrgNames(ArrayList<String> orgNames) {
		this.mOrgNames = orgNames;
	}

	public VisitingCardListAdapter getmListAdapter() {
		return mListAdapter;
	}

	public void setListAdapter(VisitingCardListAdapter listAdapter) {
		this.mListAdapter = listAdapter;
	}

	public SectionsPagerAdapter getSectionsAdapter() {
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
		mListAdapter = new VisitingCardListAdapter(getActivity().getApplicationContext());
		
		mOrgNames.add("AgreeYa Mobility");
		mOrgNames.add("Magic Softwares");
		mOrgNames.add("Samsung Telecommunications America");
		
		mListAdapter.setContent(mOrgNames);
		super.onCreate(savedInstanceState);
	}
	
}
