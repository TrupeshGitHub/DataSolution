package dataBaseConnectivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import dataBaseConnectivity.DBMetadata.AccountColumns;
import dataBaseConnectivity.DBMetadata.AddressColumns;
import dataBaseConnectivity.DBMetadata.ContactsColumns;
import dataBaseConnectivity.DBMetadata.PaymentReminderAccountColumns;
import dataBaseConnectivity.DBMetadata.PhoneColumns;
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
	
	//SQL Lite Data-Type Definitions
	public static final String TEXT = " TEXT ";
	public static final String INTEGER = " INTEGER ";
	public static final String BOOLEAN = " TEXT ";
	
	//Constraints Declarations
	public static final String UNIQUE_CONSTRAINT = " UNIQUE ";
	public static final String PRIMARY_KEY_CONSTRAINT = " PRIMARY KEY ";
	public static final String NOTNULL_CONSTRAINT = " NOT NULL ";
	public static final String FOREIGN_KEY_CONSTRAINT = " FOREIGN KEY ";
	
	// SQL Queries Definitions
	public static final String contactTableSQL = "CREATE TABLE "
			+ ContactsColumns.TABLE_NAME + " ( " + ContactsColumns.CONTACT_ID
			+ INTEGER + PRIMARY_KEY_CONSTRAINT + COMMA_SEP
			+ ContactsColumns.FIRST_NAME + TEXT + NOTNULL_CONSTRAINT + COMMA_SEP 
			+ ContactsColumns.LAST_NAME + TEXT + COMMA_SEP
			+ ContactsColumns.FIRM_NAME + TEXT + COMMA_SEP
			+ ContactsColumns.CORPORATE_EMAIL + TEXT + UNIQUE_CONSTRAINT + COMMA_SEP 
			+ ContactsColumns.SECONDARY_EMAIL + TEXT + COMMA_SEP
			+ ContactsColumns.COMPANY_NAME + TEXT + COMMA_SEP
			+ ContactsColumns.WEBSITE_URL + TEXT + " )";

	public static final String addressTableSQL = "CREATE TABLE "
			+ AddressColumns.TABLE_NAME + " ( " + AddressColumns.ADDRESS_ID
			+ INTEGER + PRIMARY_KEY_CONSTRAINT + COMMA_SEP
			+ AddressColumns.STREET_LINE_1 + TEXT + NOTNULL_CONSTRAINT + COMMA_SEP
			+ AddressColumns.STREET_LINE_2 + TEXT + COMMA_SEP
			+ AddressColumns.CITY + TEXT + UNIQUE_CONSTRAINT + COMMA_SEP
			+ AddressColumns.STATE + TEXT + COMMA_SEP  
			+ AddressColumns.COUNTRY+ TEXT + COMMA_SEP 
			+ AddressColumns.POSTALCODE + TEXT + COMMA_SEP 
			+ AddressColumns.CONTACT_ID + TEXT + COMMA_SEP 
			+ FOREIGN_KEY_CONSTRAINT + "(" + AddressColumns.CONTACT_ID + ")" + " REFERENCES " + ContactsColumns.TABLE_NAME + "(" + ContactsColumns.CONTACT_ID + ")" + " )";
	
	public static final String phoneTableSQL = "CREATE TABLE "
			+ PhoneColumns.TABLE_NAME + " ( " + PhoneColumns.PHONE_NO_ID
			+ INTEGER + PRIMARY_KEY_CONSTRAINT + COMMA_SEP
			+ PhoneColumns.PHONE_TYPE + TEXT + NOTNULL_CONSTRAINT + COMMA_SEP 
			+ PhoneColumns.PHONE_NO + TEXT + COMMA_SEP  
			+ PhoneColumns.CONTACT_ID + TEXT + COMMA_SEP 
			+ FOREIGN_KEY_CONSTRAINT + "(" + PhoneColumns.CONTACT_ID + ")" + " REFERENCES " + ContactsColumns.TABLE_NAME + "(" + ContactsColumns.CONTACT_ID + ")" + " )";

	
	public static final String accountTableSQL = "CREATE TABLE "
			+ AccountColumns.TABLE_NAME + " ( "
			+ AccountColumns.ACCT_ID + INTEGER + PRIMARY_KEY_CONSTRAINT + COMMA_SEP
			+ AccountColumns.ACCT_TYPE + TEXT + NOTNULL_CONSTRAINT+ COMMA_SEP 
			+ AccountColumns.ACCT_ALIAS_NAME + TEXT + COMMA_SEP
			+ AccountColumns.CARD_TYPE + TEXT + UNIQUE_CONSTRAINT + COMMA_SEP
			+ AccountColumns.BANK_NAME + TEXT + COMMA_SEP
			+ AccountColumns.CARD_NO + TEXT + COMMA_SEP
			+ AccountColumns.ACCT_NO + TEXT + COMMA_SEP
			+ AccountColumns.EXPIRY_DATE + TEXT + COMMA_SEP
			+ AccountColumns.CVV_NO + INTEGER + COMMA_SEP
			+ AccountColumns.PIN_NO + INTEGER 
			+ " )";

	public static final String paymentReminderTableSQL = "CREATE TABLE "
			+ PaymentReminderAccountColumns.TABLE_NAME + " ( "
			+ PaymentReminderAccountColumns.ID + INTEGER + PRIMARY_KEY_CONSTRAINT + COMMA_SEP
			+ PaymentReminderAccountColumns.BILLING_CYCLE + TEXT + COMMA_SEP 
			+ PaymentReminderAccountColumns.PAYMENT_CYCLE + TEXT + COMMA_SEP
			+ PaymentReminderAccountColumns.REMINDER_SCHEDULE + TEXT  + COMMA_SEP
			+ PaymentReminderAccountColumns.ACCT_ID + TEXT + COMMA_SEP
			+ FOREIGN_KEY_CONSTRAINT + "(" + PaymentReminderAccountColumns.ACCT_ID + ")" + " REFERENCES " + AccountColumns.TABLE_NAME + "(" + AccountColumns.ACCT_ID + ")" + " )" ;
}
