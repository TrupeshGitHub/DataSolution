package com.i2a.datasolution;

import java.util.ArrayList;

import com.i2a.adapter.VisitingCardListAdapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class VisitingCardFragment extends Fragment{
	
	private ArrayList<String> mOrgNames = new ArrayList<String>();
	private String LOG_TAG = "VisitingCardFragment";
	private VisitingCardListAdapter mListAdapter = null;
	
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
