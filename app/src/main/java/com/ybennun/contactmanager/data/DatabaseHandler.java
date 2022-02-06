package com.ybennun.contactmanager.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.ybennun.contactmanager.R;
import com.ybennun.contactmanager.util.Util;

import java.sql.SQLData;

public class DatabaseHandler extends SQLiteOpenHelper {

    public DatabaseHandler(Context context) {
        super(context, Util.DATABASE_NAME, null, Util.DATABASE_VERSION);
    }

    //We create our table
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //SQL - Structured Query Language
        /*
            create table_name(id, name, phone_number);
        */
        String CREATE_CONTACT_TABLE = "CREATE TABLE " + Util.TABLE_NAME + "("
                + Util.KEY_ID + " INTEGER PRIMARY KEY," + Util.KEY_NAME + " TEXT,"
                + Util.KEY_PHONE_NUMBER + " TEXT" + ")";

        sqLiteDatabase.execSQL(CREATE_CONTACT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        String DROP_TABLE = String.valueOf(R.string.db_drop);
        sqLiteDatabase.execSQL(DROP_TABLE, new String[]{Util.DATABASE_NAME});

        //Create a table again
        onCreate(sqLiteDatabase);
    }
}
