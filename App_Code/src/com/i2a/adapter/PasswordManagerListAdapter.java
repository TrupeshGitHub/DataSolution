package com.i2a.adapter;

import java.util.ArrayList;

import com.i2a.datasolution.R;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class PasswordManagerListAdapter extends BaseAdapter {

	private ArrayList<String> mAccNames = new ArrayList<String>();
	private String LOG_TAG = "PasswordManagerListAdapter";
	private Context mContext = null;
	private SectionsPagerAdapter mSectionsAdapter = null;
	
	public ArrayList<String> getAccNames() {
		return mAccNames;
	}

	public void setAccNames(ArrayList<String> accNames) {
		this.mAccNames = accNames;
	}

	public Context getContext() {
		return mContext;
	}

	public void setContext(Context context) {
		this.mContext = context;
	}

	public SectionsPagerAdapter getSectionsAdapter() {
		return mSectionsAdapter;
	}

	public void setSectionsAdapter(SectionsPagerAdapter sectionsAdapter) {
		this.mSectionsAdapter = sectionsAdapter;
	}

	public PasswordManagerListAdapter(Context context) {
		mContext = context;
	}
	
	public void setContent(ArrayList<String> cardNames) {
		mAccNames.clear();
		mAccNames.addAll(cardNames);	
	}
	
	@Override
	public int getCount() {
		return mAccNames.size();
	}

	@Override
	public Object getItem(int position) {
		return mAccNames.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		Log.d(LOG_TAG, "getView() :: Position = " + position);
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) mContext
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = (View) inflater.inflate(R.layout.list_item_view,
					parent, false);
		}
		
		TextView tv = (TextView) convertView.findViewById(R.id.list_item_text);
		tv.setText(mAccNames.get(position));
		
		return convertView;
	}

}
