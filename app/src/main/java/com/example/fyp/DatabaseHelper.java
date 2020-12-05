package com.example.fyp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.SimpleCursorAdapter;

import androidx.annotation.Nullable;
/*
Watched a YouTube video on how to create an SQLite Database - https://youtu.be/cp2rL3sAFmI
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "student.db";
    public static final String TABLE_NAME = "student_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "SURNAME";
    public static final String COL_4 = "EMAIL";
    public static final String COL_5 = "PASSWORD";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    //creates a table whenever onCreate is called
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,SURNAME TEXT, EMAIL TEXT, PASSWORD TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);

    }



    // New method for inserting data https://www.youtube.com/watch?v=T0ClYrJukPA

    public boolean InsertUser(String name, String surname, String email, String password) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,surname);
        contentValues.put(COL_4,email);
        contentValues.put(COL_5,password);
        long result = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        // an error returns -1
        if (result == -1)
            return false;
        else
            return true;
    }

    // Function to update user - https://www.youtube.com/watch?v=PA4A9IesyCg
//    public boolean updateUser(String id, String name, String surname, String email, String password) {
//        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(COL_1,id);
//        contentValues.put(COL_2,name);
//        contentValues.put(COL_3,surname);
//        contentValues.put(COL_4,email);
//        contentValues.put(COL_5,password);
//        //Updates the arguments passed
//        sqLiteDatabase.update(TABLE_NAME, contentValues, "ID == ?", new String[] {id});
//        return true;
//
//    }
//
//    //Function to delete user - https://www.youtube.com/watch?v=neaCUaHa2Ek
    public Integer deleteUser(String id) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.delete(TABLE_NAME, "ID = ?", new String[] {id});
    }
//
//    //Function to view all users
//    public Cursor getAllData() {
//        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
//        Cursor res = sqLiteDatabase.rawQuery("select * from " + TABLE_NAME, null);
//        return res;
//
//    }

}
