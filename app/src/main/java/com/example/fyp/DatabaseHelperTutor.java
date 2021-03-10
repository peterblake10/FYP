package com.example.fyp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.annotation.Nullable;

import com.example.fyp.Model.Tutor;

import java.io.ByteArrayOutputStream;
import java.sql.Blob;
import java.util.ArrayList;
//Watched a YouTube video on how to create an SQLite Database - https://youtu.be/cp2rL3sAFmI

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
    public static final String COL_8 = "BIO";

    private ByteArrayOutputStream objectByteArrayOutputStream;
    private byte[] imageInBytes;

    public DatabaseHelperTutor(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 2);

    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,PREFIX TEXT, NAME TEXT,SURNAME TEXT, EMAIL TEXT, PASSWORD TEXT, SUBJECT TEXT, BIO TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean InsertTutor(String prefix, String name, String surname, String email, String password, String subject, String bio) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();


        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, prefix);
        contentValues.put(COL_3, name);
        contentValues.put(COL_4, surname);
        contentValues.put(COL_5, email);
        contentValues.put(COL_6, password);
        contentValues.put(COL_7, subject);
        contentValues.put(COL_8, bio);

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


//Array to select the prefix, name, and subject to display in listview - https://youtu.be/6q4-Ge0UMKY





    public ArrayList<Tutor> getAllData() {


        ArrayList<Tutor> arrayList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT prefix, name, surname, subject FROM " + TABLE_NAME, null);

        while (cursor.moveToNext()) {
            String prefix = cursor.getString(0);
            String name = cursor.getString(1);
            String surname = cursor.getString(2);
            String subject = cursor.getString(3);


            Tutor tutor = new Tutor(prefix, name, surname, subject);

            arrayList.add(tutor);

        }
        return arrayList;

    }

    public ArrayList<Tutor> getMyTutors() {


        ArrayList<Tutor> arrayList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT prefix, name, surname, subject FROM " + TABLE_NAME + " WHERE surname = 'Hurley'", null);


            while (cursor.moveToNext()) {
                String prefix = cursor.getString(0);
                String name = cursor.getString(1);
                String surname = cursor.getString(2);
                String subject = cursor.getString(3);


                Tutor tutor = new Tutor(prefix, name, surname, subject);

                arrayList.add(tutor);

            }

        return arrayList;

    }






    //Display Eoin Hurley's name for teacher profile
    public Cursor ViewEH() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME +  " WHERE surname = 'Hurley'", null);
        return cursor;
    }

    //Display Eoin Hurley's bio for tutor profile
    public Cursor ViewEHbio() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME +  " WHERE surname = 'Hurley'", null);
        return cursor;
    }

    //Display Colm Dineen's name for teacher profile
    public Cursor ViewCD() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME +  " WHERE surname = 'Dineen'", null);
        return cursor;
    }

    //Display Colm Dineen's bio for tutor profile
    public Cursor ViewCDbio() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME +  " WHERE surname = 'Dineen'", null);
        return cursor;
    }

    //Display Oran Bergin's name for teacher profile
    public Cursor ViewOB() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME +  " WHERE surname = 'Bergin'", null);
        return cursor;
    }

    //Display Oran Bergin's bio for tutor profile
    public Cursor ViewOBbio() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME +  " WHERE surname = 'Bergin'", null);
        return cursor;
    }
}

