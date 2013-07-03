package com.i2a.adapter;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.i2a.datasolution.CreditCardFragment;
import com.i2a.datasolution.PasswordManagerFragment;
import com.i2a.datasolution.VisitingCardFragment;
import com.i2a.utils.Constants;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<String> mSections = new ArrayList<String>();
    private String LOG_TAG = "SectionsPagerAdapter";
	
	public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }
	
	public void setSections(ArrayList<String> sections) {
		mSections.clear();
		mSections.addAll(sections);
	}

    @Override
    public Fragment getItem(int position) {
    	
        // getItem is called to instantiate the fragment for the given page.
    	Fragment fragment = null;
    	if(mSections.get(position).equalsIgnoreCase(Constants.VISITING_CARD)) {
    		
    		VisitingCardFragment vcf = new VisitingCardFragment();
    		vcf.setSectionsAdapter(this);
    		fragment = vcf;
    	} else if(mSections.get(position).equalsIgnoreCase(Constants.PASSWORD_MANAGER)) {
    		
    		PasswordManagerFragment pmf = new PasswordManagerFragment();
    		pmf.setSectionsAdapter(this);
    		fragment = pmf;
    	} else if(mSections.get(position).equalsIgnoreCase(Constants.CREDIT_DEBIT_CARD)) {
    		
    		CreditCardFragment ccf = new CreditCardFragment();
    		ccf.setSectionsAdapter(this);
    		fragment = ccf;
    	}
        return fragment;
    }

    @Override
    public int getCount() {
        return mSections.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
    	return mSections.get(position);
    }
}
