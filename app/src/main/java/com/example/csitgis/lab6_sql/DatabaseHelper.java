package com.example.csitgis.lab6_sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABAASE_NAME = "student_dp";

    public DatabaseHelper(Context context) {
        super(context, DATABAASE_NAME, null,DATABASE_VERSION);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Student.TABLE_NAME);

        onCreate(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Student.CREATE_TABLE);
    }
    public void insertStudent(String id,String Student){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(com.example.csitgis.lab6_sql.Student.COLUMN_ID,id);
        values.put(com.example.csitgis.lab6_sql.Student.COLUMN_NAME, student);

        db.insert(com.example.csitgis.lab6_sql.Student.TABLE_NAME,null,values);
        db.close();
    }
}
