package com.hg.birdy;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context, "Birds.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String substring ="(name TEXT primary key,altName TEXT, latinName TEXT,origin TEXT, type TEXT, habitat TEXT, image TEXT, image2 TEXT, image3 TEXT, description TEXT, website TEXT) \" ";
        try {
            db.execSQL("create Table backyard (name TEXT primary key,altName TEXT, latinName TEXT,origin TEXT, type TEXT, habitat TEXT, image TEXT, image2 TEXT, image3 TEXT, description TEXT, website TEXT)" );

        } catch(SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public Cursor getData () {

        SQLiteDatabase db = this.getWritableDatabase() ;
        Cursor cursor = db.rawQuery ("Select * from backyard", null) ;
        return cursor ;

    }

}
