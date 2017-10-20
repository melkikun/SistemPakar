package com.example.it01.sistempakar.helper;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by IT01 on 10/20/2017.
 */

public class DBHelper extends SQLiteOpenHelper{

    public static final String db_name = "ta.db";
    public static final int db_version = 1;
    private final String TAG = this.getClass().getSimpleName();

    public DBHelper(Context context) {
        super(context, db_name, null, db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "create table user(id integer primary key autoincrement not null, username varchar(50) not null, password varchar(50) not null)";
        Log.d(TAG, "onCreate: "+sql);
        sqLiteDatabase.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
