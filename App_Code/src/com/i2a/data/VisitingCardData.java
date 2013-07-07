package com.i2a.data;

import java.util.ArrayList;
import java.util.HashMap;

import com.i2a.utils.Constants;
import com.i2a.utils.Constants.CONTACT_TYPE;

public class VisitingCardData {
	
	private long mId = -1;
	private String mOrgName = null;
	private ArrayList<String> mEmailAddr = null;
	private HashMap<String, Constants.CONTACT_TYPE> mContactNo = null;
	private String mAddr = null;
	private String mConPersName = null;
	private String mWebsite = null;
	
	public VisitingCardData(long id, String orgName, ArrayList<String> emailAddr,
			HashMap<String, Constants.CONTACT_TYPE> contactNo, String addr, 
			String conPersName, String website) {
		
		this.mId = id;
		this.mOrgName = orgName;
		this.mEmailAddr = emailAddr;
		this.mContactNo = contactNo;
		this.mAddr = addr;
		this.mConPersName = conPersName;
		this.mWebsite = website;
	}
	
	
	public long getId() {
		return mId;
	}
	
	public void setId(long id) {
		this.mId = id;
	}
	
	public String getOrgName() {
		return mOrgName;
	}
	
	public void setOrgName(String orgName) {
		this.mOrgName = orgName;
	}
	
	public ArrayList<String> getEmailAddr() {
		return mEmailAddr;
	}
	
	public void setEmailAddr(ArrayList<String> emailAddr) {
		this.mEmailAddr = emailAddr;
	}
	
	public HashMap<String, CONTACT_TYPE> getContactNo() {
		return mContactNo;
	}
	
	public void setContactNo(HashMap<String, CONTACT_TYPE> contactNo) {
		this.mContactNo = contactNo;
	}
	
	public String getAddr() {
		return mAddr;
	}
	
	public void setAddr(String addr) {
		this.mAddr = addr;
	}
	
	public String getConPersName() {
		return mConPersName;
	}
	
	public void setConPersName(String conPersName) {
		this.mConPersName = conPersName;
	}
	
	public String getWebsite() {
		return mWebsite;
	}
	
	public void setWebsite(String website) {
		this.mWebsite = website;
	}
}
