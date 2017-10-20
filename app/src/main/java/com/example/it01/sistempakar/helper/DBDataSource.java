package com.example.it01.sistempakar.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.it01.sistempakar.entities.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IT01 on 10/20/2017.
 */

public class DBDataSource {
    private SQLiteDatabase database;
    private DBHelper dbHelper;
    private String[] column = {"id", "username", "password"};

    public DBDataSource(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public User createUser(String username, String password) {
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("password", password);

        long insert = database.insert("user", null, values);

        Cursor cursor = database.query("user", column, "id=" + insert, null, null, null, null);
        cursor.moveToFirst();
        User user = cursorToUser(cursor);
        cursor.close();
        return user;
    }

    public User cursorToUser(Cursor cursor) {
        User user = new User();
        Log.v("info", "The getLONG " + cursor.getLong(0));
        Log.v("info", "The setLatLng " + cursor.getString(1) + "," + cursor.getString(2));
        user.setId(cursor.getInt(0));
        user.setUsername(cursor.getString(1));
        user.setPassword(cursor.getString(2));
        return user;
    }

    public ArrayList<User> getUser(String username) {
        ArrayList<User> users = new ArrayList<>();
        Cursor cursor = database.rawQuery("select * from user where username='" + username + "'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            User user = cursorToUser(cursor);
            users.add(user);
            cursor.moveToNext();
        }
        cursor.close();
        return users;
    }

    public List<User> loginUser(String username, String password) {
        List<User> users = new ArrayList<>();
        Cursor cursor = database.rawQuery("select * from user where username='" + username + "' and password='" + password + "'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            User user = cursorToUser(cursor);
            users.add(user);
            cursor.moveToNext();
        }
        cursor.close();
        return users;
    }

}
