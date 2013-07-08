package dataBaseConnectivity;

import dataBaseConnectivity.DBContract.AddressTable;
import dataBaseConnectivity.DBContract.ContactNumbersTable;
import dataBaseConnectivity.DBContract.ContactTable;
/**
 * generic class to contain the  APIs for general operations on our DB 
 * @author harsh
 *
 */
public class DBUtilities {
	public static String TAG= "DBUtilities";
	private static  String SQL_CREATE_ENTRIES;
	private static final String TEXT_TYPE = " TEXT";
	private static final String COMMA_SEP = ",";

//	public SQLiteDatabase getDBInstance(InitiateDB mDbHelper){
//		SQLiteDatabase db = mDbHelper.getWritableDatabase();
//		return db;
//	}
	public String createContactTable(){
		SQL_CREATE_ENTRIES="CREATE TABLE " + ContactTable.TABLE_NAME + " (" +
				ContactTable.COLUMN_NAME_CONTACT_ID + " INTEGER PRIMARY KEY," +
				ContactTable.COLUMN_NAME_FIRST_NAME + TEXT_TYPE + COMMA_SEP +
				ContactTable.COLUMN_NAME_MIDDLE_NAME + TEXT_TYPE + COMMA_SEP +
				ContactTable.COLUMN_NAME_LAST_NAME + TEXT_TYPE + COMMA_SEP +
				ContactTable.COLUMN_NAME_COMPANY + TEXT_TYPE + COMMA_SEP +
				ContactTable.COLUMN_NAME_WORK_EMAIL + TEXT_TYPE + COMMA_SEP +
				ContactTable.COLUMN_NAME_PERSONAL_EMAIL + TEXT_TYPE + COMMA_SEP +
				ContactTable.COLUMN_NAME_WEBSITE + TEXT_TYPE +
				" )";
		return SQL_CREATE_ENTRIES;

	}
	public String createAddressTable(){
		SQL_CREATE_ENTRIES="CREATE TABLE " + AddressTable.TABLE_NAME + " (" +
				AddressTable.COLUMN_NAME_CONTACT_ID + " INTEGER PRIMARY KEY," +
				AddressTable.COLUMN_NAME_STREET_LINE_1 + TEXT_TYPE + COMMA_SEP +
				AddressTable.COLUMN_NAME_STREET_LINE_2 + TEXT_TYPE + COMMA_SEP +
				AddressTable.COLUMN_NAME_CITY + TEXT_TYPE + COMMA_SEP +
				AddressTable.COLUMN_NAME_STATE + TEXT_TYPE + COMMA_SEP +
				AddressTable.COLUMN_NAME_COUNTRY + TEXT_TYPE + COMMA_SEP +
				AddressTable.COLUMN_NAME_POSTALCODE + TEXT_TYPE + 
				" )";
		return SQL_CREATE_ENTRIES;
	}
	public String createContactNumbersTable(){
		SQL_CREATE_ENTRIES="CREATE TABLE " + ContactNumbersTable.TABLE_NAME + " (" +
				ContactNumbersTable.COLUMN_NAME_CONTACT_ID + " INTEGER PRIMARY KEY," +
				ContactNumbersTable.COLUMN_NAME_OFFICE_NUMBER + TEXT_TYPE + COMMA_SEP +
				ContactNumbersTable.COLUMN_NAME_MOBILE_NUMBER + TEXT_TYPE + COMMA_SEP +
				ContactNumbersTable.COLUMN_NAME_FAX_NUMBER + TEXT_TYPE + COMMA_SEP +
				ContactNumbersTable.COLUMN_NAME_PAGER_NUMBER + TEXT_TYPE + COMMA_SEP +
				ContactNumbersTable.COLUMN_NAME_OTHER_NUMBER + TEXT_TYPE + 
				" )";
		return SQL_CREATE_ENTRIES;
	}
}
