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

public class VisitingCardListAdapter extends BaseAdapter{

	private ArrayList<String> mOrgNames = new ArrayList<String>();
	private String LOG_TAG = "VisitingCardListAdapter";
	private Context mContext = null;
	
	public VisitingCardListAdapter(Context context) {
		mContext = context;
	}
	
	public void setContent(ArrayList<String> orgNames) {
		mOrgNames.clear();
		mOrgNames.addAll(orgNames);	
	}
	
	@Override
	public int getCount() {
		return mOrgNames.size();
	}

	@Override
	public Object getItem(int position) {
		Log.d(LOG_TAG, "getItem() :: position = " + position);
		return mOrgNames.get(position);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {

		Log.d(LOG_TAG, "getView() :: Position = " + position);
		
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) mContext
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = (View) inflater.inflate(R.layout.list_item_view,
					arg2, false);
		}
		
		TextView tv = (TextView) convertView.findViewById(R.id.list_item_text);
		tv.setText(mOrgNames.get(position));
		
		return convertView;
	}

}
