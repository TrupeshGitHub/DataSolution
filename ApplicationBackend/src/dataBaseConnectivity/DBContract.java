package dataBaseConnectivity;

import android.provider.BaseColumns;

/**
 * This class will be responsible for defining the DB schema of the database 
 * to store all the data of the contacts / visiting cards
 * @author harsh
 *
 */
public final class DBContract {
	public static String TAG= "DBContract";
	
	// To prevent someone from accidentally instantiating the contract class,
	public DBContract(){

	}
	/* Inner class that defines the table contents of contact table*/
	public static abstract class ContactTable implements BaseColumns {
		public static final String TABLE_NAME = "contact";
		public static final String COLUMN_NAME_CONTACT_ID = "cID";               //Primary Key
		public static final String COLUMN_NAME_FIRST_NAME = "streetLine1";
		public static final String COLUMN_NAME_MIDDLE_NAME = "streetLine2";
		public static final String COLUMN_NAME_LAST_NAME = "city";
		public static final String COLUMN_NAME_COMPANY = "state";
		public static final String COLUMN_NAME_WORK_EMAIL = "country";
		public static final String COLUMN_NAME_PERSONAL_EMAIL = "personal email";
		public static final String COLUMN_NAME_WEBSITE = "postalode";
	}
	/* Inner class that defines the table contents of Address table*/
	public static abstract class AddressTable implements BaseColumns {
		public static final String TABLE_NAME = "Address";
		public static final String COLUMN_NAME_CONTACT_ID = "cID";				//Primary Key
		public static final String COLUMN_NAME_STREET_LINE_1 = "streetLine1";
		public static final String COLUMN_NAME_STREET_LINE_2 = "streetLine2";
		public static final String COLUMN_NAME_CITY = "city";
		public static final String COLUMN_NAME_STATE = "state";
		public static final String COLUMN_NAME_COUNTRY = "country";
		public static final String COLUMN_NAME_POSTALCODE = "postalcode";
	}
	/* Inner class that defines the table contents of Address table*/
	public static abstract class ContactNumbersTable implements BaseColumns {
		public static final String TABLE_NAME = "ContactNumbers";
		public static final String COLUMN_NAME_CONTACT_ID = "cID";				//Primary Key
		public static final String COLUMN_NAME_OFFICE_NUMBER = "officeNumber";
		public static final String COLUMN_NAME_MOBILE_NUMBER = "mobileNumber";
		public static final String COLUMN_NAME_FAX_NUMBER = "faxNumber";
		public static final String COLUMN_NAME_PAGER_NUMBER = "pagerNumber";
		public static final String COLUMN_NAME_OTHER_NUMBER = "otherNumber";
	}

}

