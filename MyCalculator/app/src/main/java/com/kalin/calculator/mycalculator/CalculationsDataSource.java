package com.kalin.calculator.mycalculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kalin on 16.12.16.
 */
public class CalculationsDataSource {

    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allCalculations = { MySQLiteHelper.COLUMN_ID, MySQLiteHelper.COLUMN_CALCULATE };

    public CalculationsDataSource(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Calculate createCalculate(String calculate) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_CALCULATE, calculate);
        long insertId = database.insert(MySQLiteHelper.TABLE_CALCULATIONS, null, values);
        Cursor cursor = database.query(MySQLiteHelper.TABLE_CALCULATIONS, allCalculations, MySQLiteHelper.COLUMN_ID + " = " + insertId, null, null,
                null, null);
        cursor.moveToFirst();
        Calculate newCalculate = cursorToCalculate(cursor);
        cursor.close();
        return newCalculate;
    }

    public void deleteCalculate(Calculate calculate) {
        long id = calculate.getId();
        System.out.println("Calculate delete with id: " + id);
        database.delete(MySQLiteHelper.TABLE_CALCULATIONS, MySQLiteHelper.COLUMN_ID + " = " + id, null);
    }

    public List<Calculate> getAllCalculations() {
        List<Calculate> calculates = new ArrayList<Calculate>();

        Cursor cursor = database.query(MySQLiteHelper.TABLE_CALCULATIONS, allCalculations, null, null, null, null, null);

        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            Calculate calculate = cursorToCalculate(cursor);
            calculates.add(calculate);
            cursor.moveToNext();
        }

        cursor.close();
        return calculates;
    }

    private Calculate cursorToCalculate(Cursor cursor) {
        Calculate calculate = new Calculate();
        calculate.setId(cursor.getLong(0));
        calculate.setCalculate(cursor.getString(1));
        return calculate;
    }

}