package com.example.fyp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.fyp.Model.Tutor;

import java.util.ArrayList;

public class DatabaseHelperTutor extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "tutor.db";
    public static final String TABLE_NAME = "tutor_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "PREFIX";
    public static final String COL_3 = "NAME";
    public static final String COL_4 = "SURNAME";
    public static final String COL_5 = "EMAIL";
    public static final String COL_6 = "PASSWORD";
    public static final String COL_7 = "SUBJECT";

    public DatabaseHelperTutor(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,PREFIX TEXT, NAME TEXT,SURNAME TEXT, EMAIL TEXT, PASSWORD TEXT, SUBJECT TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean InsertTutor(String prefix, String name, String surname, String email, String password, String subject) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, prefix);
        contentValues.put(COL_3, name);
        contentValues.put(COL_4, surname);
        contentValues.put(COL_5, email);
        contentValues.put(COL_6, password);
        contentValues.put(COL_7, subject);
        long result = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        // an error returns -1
        if (result == -1)
            return false;
        else
            return true;
    }
    //Function to delete tutor - https://www.youtube.com/watch?v=neaCUaHa2Ek
//    public Integer deleteTutor(String id) {
//        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
//        return sqLiteDatabase.delete(TABLE_NAME, "ID = ?", new String[] {id});
//    }

    public ArrayList<Tutor> getAllData() {


        ArrayList<Tutor> arrayList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT prefix, name, surname FROM tutor_table", null);

        while (cursor.moveToNext()) {
            String prefix = cursor.getString(0);
            String name = cursor.getString(1);
            String surname = cursor.getString(2);
            Tutor tutor = new Tutor(prefix, name, surname);

            arrayList.add(tutor);

        }
        return arrayList;

    }
}