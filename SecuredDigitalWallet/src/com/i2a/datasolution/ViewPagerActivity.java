package com.i2a.datasolution;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;

import com.example.secureddigitalwallet.R;
import com.i2a.adapter.SectionsPagerAdapter;
import com.i2a.utils.Constants;

public class ViewPagerActivity extends FragmentActivity {

    private String LOG_TAG = "ViewPagerActivity";
	
	
	/**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
     * will keep every loaded fragment in memory. If this becomes too memory
     * intensive, it may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;
    
    ArrayList<String> mSections = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the app.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        setSections();
        mSectionsPagerAdapter.setSections(mSections);

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

    }
    
    public SectionsPagerAdapter getSectionsPagerAdapter() {
    	return mSectionsPagerAdapter;
    }
    
    
    
    private void setSections() {
    	mSections.add(Constants.VISITING_CARD);
    	mSections.add(Constants.CREDIT_DEBIT_CARD);
    	mSections.add(Constants.PASSWORD_MANAGER);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.view_pager, menu);
        return true;
    }
}
