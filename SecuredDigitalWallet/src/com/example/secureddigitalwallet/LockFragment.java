package com.example.secureddigitalwallet;

import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class LockFragment extends DialogFragment{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.lock_layout, container, true);
		
//		final TextView password = (TextView)v.findViewById(R.id.password);
//
////		 Watch for button clicks.
//		Button button = (Button)v.findViewById(R.id.Confirm);
//		button.setOnClickListener(new View.OnClickListener() {
//			public void onClick(View v) {
////				if(password.getText().toString().equals("pass"))
////					Toast.makeText(getActivity(), "PASSWORD ACCEPTED", Toast.LENGTH_LONG).show();
////				else
////				Toast.makeText(getActivity(), "WRONG PASSWORD", Toast.LENGTH_LONG).show();
//			}
//		});
//		Button cancelPassword = (Button)v.findViewById(R.id.CancelPassword);
//		cancelPassword.setOnClickListener(new View.OnClickListener() {
//			public void onClick(View v) {
//			}
//		});


		return v;
	}

//	void showDialog() {
//
//		// DialogFragment.show() will take care of adding the fragment
//		// in a transaction.  We also want to remove any currently showing
//		// dialog, so make our own transaction and take care of that here.
//		FragmentTransaction ft = getFragmentManager().beginTransaction();
//		Fragment prev = getFragmentManager().findFragmentByTag("dialog");
//		if (prev != null) {
//			ft.remove(prev);
//		}
//		ft.addToBackStack(null);
//
//		// Create and show the dialog.
//		DialogFragment newFragment = LockFragment.newInstance(mStackLevel);
//		newFragment.show(ft, "dialog");
//	}

}