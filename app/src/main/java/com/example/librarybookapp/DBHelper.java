package com.example.librarybookapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    Context context;
    private static final String DATABASE_NAME = "Library";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "Books";
    private static final String COL_Name = "Book_Name";
    private static final String COL_Author = "Author";
    private static final String COL_NumberOfPages = "NumberofPages";
    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //in this method we will create the database and table and will define the sechema of database
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table " + TABLE_NAME +
                " (" + COL_Name + " text, " +
                COL_Author + " text, " +
                COL_NumberOfPages + " integer);";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists " + TABLE_NAME);
        onCreate(db);

    }

    public void addBooks(String name, String author,  int pNumber) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues val = new ContentValues();
        val.put(COL_Name, name);
        val.put(COL_Author, author);
        val.put(COL_NumberOfPages, pNumber);

        db.insert(TABLE_NAME, null, val);
    }
}
