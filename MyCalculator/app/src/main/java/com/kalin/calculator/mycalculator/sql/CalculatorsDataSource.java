package com.kalin.calculator.mycalculator.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kalin on 04.11.16.
 */

// This is where we are using DAO

public class CalculatorsDataSource {

    // Data fields
    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = {MySQLiteHelper.COLUMN_ID, MySQLiteHelper.COLUMN_CALCULATOR};

    public CalculatorsDataSource(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Calculator createCalculator(String calculator) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_CALCULATOR, calculator);
        long insertId = database.insert(MySQLiteHelper.TABLE_CALCULATORS, null, values);
        Cursor cursor = database.query(MySQLiteHelper.TABLE_CALCULATORS, allColumns,
                MySQLiteHelper.COLUMN_ID + " = " + insertId, null, null, null, null);
        cursor.moveToFirst();
        Calculator newCalculator = cursorToCalculator(cursor);
        cursor.close();
        return newCalculator;
    }

    public void deleteCalculator(Calculator calculator) {
        long id = calculator.getId();
        System.out.println("Calculator deleted with id: " + id);
        database.delete(MySQLiteHelper.TABLE_CALCULATORS, MySQLiteHelper.COLUMN_ID + " = " + id, null);
    }

    public List<Calculator> getAllCalculators() {
        List<Calculator> calculators = new ArrayList<Calculator>();

        Cursor cursor = database.query(MySQLiteHelper.TABLE_CALCULATORS, allColumns, null, null, null, null, null);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            Calculator calculator = cursorToCalculator(cursor);
            calculators.add(calculator);
            cursor.moveToNext();
        }

        //make sure to close the cursor
        cursor.close();
        return calculators;
    }

    private Calculator cursorToCalculator(Cursor cursor) {
        Calculator calculator = new Calculator();
        calculator.setId(cursor.getLong(0));
        calculator.setCalculator(cursor.getString(1));
        return calculator;
    }
}