/**
 * 
 */
package dataBaseConnectivity;

import android.provider.BaseColumns;

/**
 * @author Anshu
 *
 */
public class DBMetadata {
	
	public static final class ContactsColumns implements BaseColumns {
		public static final String TABLE_NAME = "Contact";
		public static final String CONTACT_ID = "cID";               //Primary Key
		public static final String FIRST_NAME = "firstName"; // NOT NULL CONSTRAINT
		public static final String LAST_NAME = "lastName"; //OPTIONAL
		
		public static final String FIRM_NAME = "firmName"; //OPTIONAL
		public static final String CORPORATE_EMAIL = "corporateEmailID"; //UNIQUE CONSTRAINT 
		public static final String SECONDARY_EMAIL = "secondaryEmailID"; //OPTIONAL FIELD
		
		public static final String COMPANY_NAME = "companyName"; 
		public static final String WEBSITE_URL = "websiteURL"; 
		

	}
	
	public static final class AddressColumns implements BaseColumns { 
		//Preferably, at least One Address should be present per Contact.  
		public static final String TABLE_NAME = "Address";
		public static final String ADDRESS_ID = "aID";				//Primary Key
		public static final String STREET_LINE_1 = "streetLine1";
		public static final String STREET_LINE_2 = "streetLine2";
		public static final String CITY = "city";
		public static final String STATE = "state";
		public static final String COUNTRY = "country";
		public static final String POSTALCODE = "postalCode"; //INTEGER FIELD. Numbers only Validations
		public static final String CONTACT_ID = "cID"; 	// Foreign Key Constraint
	}
	
	public static final class PhoneColumns implements BaseColumns {
		//Preferably, at least One Phone No should be present per Contact.
		public static final String TABLE_NAME = "PhoneNumbers";
		public static final String PHONE_NO_ID = "pID";				//Primary Key
		public static final String PHONE_TYPE = "pType"; //ENUM to indicate values like Mobile/Office/FAX
		public static final String PHONE_NO = "phoneNo"; 
		
		public static final String CONTACT_ID = "cID"; 	// Foreign Key Constraint
	}

	public static final class AccountColumns implements BaseColumns {
		
		public static final String TABLE_NAME = "Accounts";
		public static final String ACCT_ID = "acctID";				//Primary Key
		public static final String ACCT_TYPE = "acctType"; // ENUM. Can be DEBIT/CREDIT
		public static final String ACCT_ALIAS_NAME = "acctAliasName"; // UNIQUE
		public static final String CARD_TYPE = "cardType"; // ENUM. MasterCard/VISA/Maestro
		public static final String BANK_NAME = "bankName";
		
		//The following columns should be encrypted with AES 256 BIT & proper validations.
		//NOTE- Even if the user is rooted, he should not be allowed to access the DB through SQLLite on ADB Shell
		public static final String CARD_NO = "cardNo"; // Credit Card / DEBIT Card no.
		public static final String ACCT_NO = "acctNo"; // Account No if present.
		public static final String EXPIRY_DATE = "expiryDate"; //UNIQUE
		public static final String CVV_NO = "cvvNo"; //Should be encrypted with AES 256 BIT
		public static final String PIN_NO = "pinNo"; 
			
		public static final String CONTACT_ID = "cID"; 	// Foreign Key Constraint
	}
	
	// NEED To Identify how to Notify the Payment reminder. Possible Solutions - NotificationBar, SMS, Android, Calendar EVENT. 
	public static final class PaymentReminderAccountColumns implements BaseColumns {
		public static final String TABLE_NAME = "PaymentReminderAccount";
		public static final String ID = "ID";	//Primary Key
		public static final String BILLING_CYCLE = "billingCycle"; // Date of every month e.g Every 5th of Month new bill gets generated
		public static final String PAYMENT_CYCLE = "paymentCycle" ; // Date of every month which is usually payment date of bill.
		public static final String REMINDER_SCHEDULE = "reminderSchedule" ;// How often the reminder should be sent. Could be kept as no of days before payment cycle.
		
		public static final String ACCT_ID = "acctID";				
		public static final String CONTACT_ID = "cID"; 	// Foreign Key Constraint 
	}
}

