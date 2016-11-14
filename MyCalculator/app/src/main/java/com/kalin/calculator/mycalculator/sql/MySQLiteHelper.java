package com.kalin.calculator.mycalculator.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by kalin on 04.11.16.
 */

public class MySQLiteHelper extends SQLiteOpenHelper {

    public static final String TABLE_CALCULATORS = "calculators";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_CALCULATOR = "calculator";

    private static final String DATABASE_NAME = "calculators.db";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table" + TABLE_CALCULATORS + "(" + COLUMN_ID
            + "integer primary key autoincrement, " + COLUMN_CALCULATOR + " text not null);";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(), "Upgrading database from version " + oldVersion + "to "
            + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_CALCULATORS);
        onCreate(db);
    }

}