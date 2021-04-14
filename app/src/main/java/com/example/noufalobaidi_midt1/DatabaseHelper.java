package com.example.noufalobaidi_midt1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "User.db";
    public static final String TABLE_NAME = "Users";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_EMAIL = "Email";


    public DatabaseHelper(@Nullable Context context) {


        super(context, DATABASE_NAME, null, 1
        ); }


    @Override
    public void onCreate(SQLiteDatabase datab) {
        datab.execSQL(

                "CREATE TABLE " +TABLE_NAME +"(" +
                        COLUMN_ID + " INTEGER PRIMARY KEY," +
                        COLUMN_NAME + " TEXT PRIMARY KEY," +
                        COLUMN_EMAIL + " INTEGER NOT NULL)"
        );
    }


    //button method 1 (add)
    public void AddUsers(String id, String name, int salary) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues val = new ContentValues();
        val.put(COLUMN_ID, id);
        val.put(COLUMN_NAME, name);
        val.put(COLUMN_EMAIL, salary);
        db.insert(TABLE_NAME, null, val);
    }


    //button method 2 (view)
    public Cursor ViewUsers() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor dax = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return dax;

    }


    //button method 3 (delete)
    public void DeleteUsers(String id) {
        String[] args = {id};
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_ID + "= ?", args);
    }

    @Override
    /* Every time the dB is updated (or upgraded) */

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}


