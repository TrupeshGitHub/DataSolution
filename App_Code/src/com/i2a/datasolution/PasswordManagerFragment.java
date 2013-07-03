package com.i2a.datasolution;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.i2a.adapter.PasswordManagerListAdapter;
import com.i2a.adapter.SectionsPagerAdapter;

public class PasswordManagerFragment extends Fragment {

	private ArrayList<String> mAccNames = new ArrayList<String>();
	private String LOG_TAG = "PasswordManagerFragment";
	private PasswordManagerListAdapter mListAdapter = null;
	private SectionsPagerAdapter mSectionsAdapter = null;
	
	public ArrayList<String> getAccNames() {
		return mAccNames;
	}

	public void setAccNames(ArrayList<String> accNames) {
		this.mAccNames = accNames;
	}

	public PasswordManagerListAdapter getListAdapter() {
		return mListAdapter;
	}

	public void setListAdapter(PasswordManagerListAdapter listAdapter) {
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
		mListAdapter = new PasswordManagerListAdapter(getActivity().getApplicationContext());
		
		mAccNames.add("trupesh44@yahoo.co.in");
		mAccNames.add("trupesh44@gmail.com");
		mAccNames.add("AXIS BANK Account");
		
		mListAdapter.setContent(mAccNames);
		super.onCreate(savedInstanceState);
	}
}
