package com.example.secondbrain;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper extends SQLiteOpenHelper {

    //DB version
    final static int DB_VERSION = 1;

    //DB names
    final static String DB_NAME = "brain";

    //table names
    final static String LOCATION_TABLE = "location";
    final static  String IMPORTANT_TABLE = "important";
    final static String PERSONAL_TABLE = "personal";

    //table create Strings
    private final static String CREATE_TABLE_LOCATION = "CREATE TABLE " + LOCATION_TABLE +
            " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "title TEXT, " +
            "content TEXT, " +
            "etc TEXT, " +
            "first TEXT, " +
            "location TEXT)";
    private final static String CREATE_TABLE_IMPORTANT = "CREATE TABLE " + IMPORTANT_TABLE +
            " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "title TEXT, " +
            "content TEXT, " +
            "etc TEXT, " +
            "first TEXT)";
    private final static String CREATE_TABLE_PERSONAL = "CREATE TABLE " + PERSONAL_TABLE +
            " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "title TEXT, " +
            "content TEXT, " +
            "etc TEXT, " +
            "first TEXT)";

    //constructors
    public MyDBHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //creating tables
        db.execSQL(CREATE_TABLE_LOCATION);
        db.execSQL(CREATE_TABLE_IMPORTANT);
        db.execSQL(CREATE_TABLE_PERSONAL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

}
