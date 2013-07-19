package dataBaseConnectivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class InitiateDB extends SQLiteOpenHelper{
	public static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "cardStorage.db";
	public static String TAG= "InitiateDB";

	public InitiateDB(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		Log.d(TAG, "initiating constructor");
	}

	static
	{
		Log.d(TAG, "initiate the Database");

	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.d(TAG, "oncreate database : "+db);
		Log.d(TAG, "printing db query for Contact Table : "+DBUtilities.contactTableSQL);
		Log.d(TAG, "printing db query for Address Table : "+DBUtilities.addressTableSQL);
		Log.d(TAG, "printing db query for Phone Table : "+DBUtilities.phoneTableSQL);
		Log.d(TAG, "printing db query for Account Table : "+DBUtilities.accountTableSQL);
		Log.d(TAG, "printing db query for payment reminder Table : "+DBUtilities.paymentReminderTableSQL);
		db.execSQL(DBUtilities.contactTableSQL);
		db.execSQL(DBUtilities.addressTableSQL);
		db.execSQL(DBUtilities.phoneTableSQL);
		db.execSQL(DBUtilities.accountTableSQL);
		db.execSQL(DBUtilities.paymentReminderTableSQL);
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		onCreate(db);
	}

}
