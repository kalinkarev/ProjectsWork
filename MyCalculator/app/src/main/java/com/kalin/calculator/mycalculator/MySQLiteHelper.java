package com.kalin.calculator.mycalculator;

/**
 * Created by kalin on 16.12.16.
 */
//public class MySQLiteHelper extends SQLiteOpenHelper {
//
//    public static String TABLE_CALCULATIONS = "calculations";
//    public static final String COLUMN_ID = "_id";
//    public static final String COLUMN_CALCULATE = "calculate";
//
//    private static final String DATABASE_NAME = "calculations.db";
//    private static final int DATABASE_VERSION = 1;
//
//    private static final String DATABASE_CREATE = "create table " + TABLE_CALCULATIONS + "( " + COLUMN_ID +
//            " integer primary key autoincrement, " + COLUMN_CALCULATE + " text not null);";
//
//    public MySQLiteHelper(Context context) {
//        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase database) {
//        database.execSQL(DATABASE_CREATE);
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        Log.w(MySQLiteHelper.class.getName(), "Upgrade database from version " + oldVersion + " to " + newVersion
//                + ", which will destroy all old data");
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CALCULATIONS);
//        onCreate(db);
//    }
//
//}
