package dataBaseConnectivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;
import dataBaseConnectivity.DBContract.AddressTable;
import dataBaseConnectivity.DBContract.ContactNumbersTable;
import dataBaseConnectivity.DBContract.ContactTable;
/**
 * generic class to contain the  APIs for general operations on our DB 
 * @author harsh
 *TODO change the create table to create table if not exist
 */
public class DBUtilities {
	public static String TAG= "DBUtilities";
	private static  String SQL_CREATE_ENTRIES;
	private static final String TEXT_TYPE = " TEXT";
	private static final String COMMA_SEP = ",";

	/**
	 * 
	 * @return query to create the table for storing the contacts
	 */
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
	/**
	 * 
	 * @return : query to create the table for storing the addresses of the contact
	 */
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
	/**
	 * 
	 * @return : query to create the table for storing the contact numbers of the contact 
	 */
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
	/**
	 * 
	 * @param tableName   : Table name in which the row should be inserted
	 * @param nullableColumn : name of a column in which the framework can insert NULL in the event that the ContentValues is empty
	 * if nullableColumn is instead set to "null", then the framework will not insert a row when there are no values 
	 * @param insertContentValues  : Values of the columns for that row
	 */
	public void insertRowInDB(SQLiteDatabase database, String tableName,String nullableColumn,ContentValues insertContentValues){
		long newRowId = 0;
		try {
			newRowId = database.insert(
					tableName,
					nullableColumn,
					insertContentValues);
		}catch (SQLiteConstraintException e) {
			//record with this primary key already exists so this will throw an exception
			Log.d(TAG," record with this primary key already exists id : "+newRowId);			
		}
	}
	/**
	 * delete a record in a table of a database based on the primary key
	 * @param database       : name of the database where the record is to be deleted
	 * @param tableName      : name of the table where the record is to be deleted
	 * @param selection      : 'where' part of query
	 * @param selectionArgs  : Specify arguments in placeholder order.
	 */
	public void deleteRowInDB(SQLiteDatabase database, String tableName,String selection, String[] selectionArgs ){
		selection = selection+ " LIKE ?";
		database.delete(tableName, selection, selectionArgs);
	}
}
