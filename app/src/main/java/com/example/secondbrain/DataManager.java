package com.example.secondbrain;

import android.app.Person;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DataManager {

    private Context context;
    private MyDBHelper myDBHelper;
    private SQLiteDatabase db;
    ArrayList<LocationItem> LocationItems;
    ArrayList<DBItem> ImportantItems;
    ArrayList<DBItem> PersonalItems;

    //Constructors
    public DataManager(Context context){
        this.context = context;
        myDBHelper = new MyDBHelper(this.context);
    }

    //insert item
    public void insertLocation(LocationItem item){
        SQLiteDatabase db = myDBHelper.getWritableDatabase();
        String sql = "insert into " + myDBHelper.LOCATION_TABLE + " values (null, '" + item.getTitle() + "', '" + item.getContent() + "', '" + item.getEtc() + "', '" + item.getFirst() + "', '" + item.getLocation() + "');";
        db.execSQL(sql);
        db.close();
    }
    public void insertImportant(DBItem item){
        SQLiteDatabase db = myDBHelper.getWritableDatabase();
        String sql = "insert into " + myDBHelper.IMPORTANT_TABLE + " values (null, '" + item.getTitle() + "', '" + item.getContent() + "', '" + item.getEtc() + "', '" + item.getFirst() + "');";
        db.execSQL(sql);
        db.close();
    }
    public void insertPersonal(DBItem item){
        SQLiteDatabase db = myDBHelper.getWritableDatabase();
        String sql = "insert into " + myDBHelper.PERSONAL_TABLE + " values (null, '" + item.getTitle() + "', '" + item.getContent() + "', '" + item.getEtc() + "', '" + item.getFirst() + "');";
        db.execSQL(sql);
        db.close();
    }

    //select item
    public ArrayList<LocationItem> selectLocationList(){
        SQLiteDatabase db = myDBHelper.getWritableDatabase();
        LocationItems = new ArrayList<>();

        String sql = "select * from " + myDBHelper.LOCATION_TABLE;

        Cursor cursor = db.rawQuery(sql, null);
        while(cursor.moveToNext()){
            int id = cursor.getInt(0);
            String title = cursor.getString(1);
            String content = cursor.getString(2);
            String etc = cursor.getString(3);
            String first = cursor.getString(4);
            String location = cursor.getString(5);

            LocationItem item = new LocationItem(id, title, content, etc, first, location);
            LocationItems.add(item);
        }

        cursor.close();
        db.close();

        return LocationItems;
    }
    public ArrayList<DBItem> selectImportantList(){
        SQLiteDatabase db = myDBHelper.getWritableDatabase();
        ImportantItems = new ArrayList<>();

        String sql = "select * from " + myDBHelper.IMPORTANT_TABLE;

        Cursor cursor = db.rawQuery(sql, null);
        while(cursor.moveToNext()){
            int id = cursor.getInt(0);
            String title = cursor.getString(1);
            String content = cursor.getString(2);
            String etc = cursor.getString(3);
            String first = cursor.getString(4);

            DBItem item = new DBItem(id, title, content, etc, first);
            ImportantItems.add(item);
        }

        cursor.close();
        db.close();

        return ImportantItems;
    }
    public ArrayList<DBItem> selectPersonalList(){
        SQLiteDatabase db = myDBHelper.getWritableDatabase();
        PersonalItems = new ArrayList<>();

        String sql = "select * from " + myDBHelper.PERSONAL_TABLE;

        Cursor cursor = db.rawQuery(sql, null);
        while(cursor.moveToNext()){
            int id = cursor.getInt(0);
            String title = cursor.getString(1);
            String content = cursor.getString(2);
            String etc = cursor.getString(3);
            String first = cursor.getString(4);

            DBItem item = new DBItem(id, title, content, etc, first);
            PersonalItems.add(item);
        }

        cursor.close();
        db.close();

        return PersonalItems;
    }

    //delete item
    public void deleteLocation(int id){
        SQLiteDatabase db = myDBHelper.getWritableDatabase();
        db.execSQL("delete from " + myDBHelper.LOCATION_TABLE + " where _id = " + id);
        db.close();
    }
    public void deleteImportant(int id){
        SQLiteDatabase db = myDBHelper.getWritableDatabase();
        db.execSQL("delete from " + myDBHelper.IMPORTANT_TABLE + " where _id = " + id);
        db.close();
    }
    public void deletePersonal(int id){
        SQLiteDatabase db = myDBHelper.getWritableDatabase();
        db.execSQL("delete from " + myDBHelper.PERSONAL_TABLE + " where _id = " + id);
        db.close();
    }

    //update item
    public void updateLocation(int id, String title, String content, String etc, String first, String location){
        SQLiteDatabase db = myDBHelper.getWritableDatabase();
        db.execSQL("update " + myDBHelper.LOCATION_TABLE +
                " set title = '" + title +
                "', content = '" + content +
                "', etc = '" + etc +
                "', first = '" + first +
                "', location = '" + location +
                "' where _id = " + id);
        db.close();
    }
    public void updateImportant(int id, String title, String content, String etc, String first){
        SQLiteDatabase db = myDBHelper.getWritableDatabase();
        db.execSQL("update " + myDBHelper.IMPORTANT_TABLE +
                " set title = '" + title +
                "', content = '" + content +
                "', etc = '" + etc +
                "', first = '" + first +
                "' where _id = " + id);
        db.close();
    }
    public void updatePersonal(int id, String title, String content, String etc, String first){
        SQLiteDatabase db = myDBHelper.getWritableDatabase();
        db.execSQL("update " + myDBHelper.PERSONAL_TABLE +
                " set title = '" + title +
                "', content = '" + content +
                "', etc = '" + etc +
                "', first = '" + first +
                "' where _id = " + id);
        db.close();
    }
}
