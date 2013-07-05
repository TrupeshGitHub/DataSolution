package dataBaseConnectivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class InitiateDB extends SQLiteOpenHelper{
	public static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "cardStorage.db";
	public DBUtilities dbUtilities;
	public static String TAG= "InitiateDB";

	public InitiateDB(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		Log.d(TAG, "initiating constructor");
	}
	
	static
	{
		Log.d(TAG, "initiate the Database");
		
	}
	public void createDatabase(){

	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.d(TAG, "initiating oncreate");
		 db.execSQL(dbUtilities.createContactTable());
		 db.execSQL(dbUtilities.createAddressTable());
		 db.execSQL(dbUtilities.createContactNumbersTable());

	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		onCreate(db);
	}
	
}
