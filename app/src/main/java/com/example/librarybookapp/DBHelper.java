package com.example.librarybookapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    Context context;
    private static final String DATABASE_NAME = "Library";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "Books";
    private static final String COL_Title = "Title";
    private static final String COL_Author = "Author";
    private static final String COL_Publisher = "Publisher";
    private static final String COL_NumberOfPages = "Number of Pages";
    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //in this method we will create the database and table and will define the sechema of database
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(" +
                COL_Title + "text"+
                COL_Author + "text" +
                COL_Publisher + "text" +
                COL_NumberOfPages + "integer"
                +")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists " + TABLE_NAME);
        onCreate(db);

    }

}
