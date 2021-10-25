package com.ndt.appstudentmanagement.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.ndt.appstudentmanagement.model.Subject;

public class Database extends SQLiteOpenHelper {
    //Tên database
    private static String DATABASE_NAME = "studentmanagement";
    //Bảng môn học
    private static String TABLE_SUBJECTS = "subject";
    private static String ID_SUBJECTS = "idsubject";
    private static String SUBJECT_TITLE = "subjecttitle";
    private static String CREDITS = "credits";
    private static String TIME = "time";
    private static String PLACE = "place";
    private static int VERSION = 1;

    //Bảng sinh viên
    private static String TABLE_STUDENT = "student";
    private static String ID_STUDENT = "idstudent";
    private static String STUDENT_NAME = "sudentname";
    private static String SEX = "sex";
    private static String STUDENT_CODE = "studentcode";
    private static String DATE_OF_BIRTH = "dateofbirth";


    //Tạo bảng môn học
    private String SQLQuery = "CREATE TABLE " + TABLE_SUBJECTS + " ( " + ID_SUBJECTS + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + SUBJECT_TITLE + " TEXT, "
            + CREDITS + " INTEGER, "
            + TIME + " TEXT, "
            + PLACE + " TEXT) ";

    //Tạo bảng sinh viên
    private String SQLQuery1 = "CREATE TABLE " + TABLE_STUDENT + " ( " + ID_STUDENT + " integer primary key AUTOINCREMENT, "
            + STUDENT_NAME + " TEXT, "
            + SEX + " TEXT, "
            + STUDENT_CODE + " TEXT, "
            + DATE_OF_BIRTH + " TEXT, "
            + ID_SUBJECTS + " INTEGER , FOREIGN KEY ( " + ID_SUBJECTS + " ) REFERENCES " +
            TABLE_SUBJECTS + "(" + ID_SUBJECTS + "))";

    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQLQuery);
        sqLiteDatabase.execSQL(SQLQuery1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void AddSubject(Subject subject) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(SUBJECT_TITLE, subject.getSubject_title());
        values.put(CREDITS, subject.getNumber_of_credit());
        values.put(TIME, subject.getTime());
        values.put(PLACE, subject.getPlace());

        db.insert(TABLE_SUBJECTS, null, values);
        db.close();
    }

    public boolean UpdateSubject(Subject subject, int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(SUBJECT_TITLE, subject.getSubject_title());
        values.put(CREDITS, subject.getNumber_of_credit());
        values.put(TIME, subject.getTime());
        values.put(PLACE, subject.getPlace());

        db.update(TABLE_SUBJECTS, values, ID_SUBJECTS + " = " + id, null);
        return true;
    }
//lay du lieu subject
    public Cursor getDataSubject() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_SUBJECTS, null);
        return cursor;
    }
    public int DeleteSubject(int i){
        //getWritetableDatabase là cả đọc và ghi
        //getReadableDatabase chỉ đọc, không đc phép chỉnh sửa
        SQLiteDatabase db = this.getWritableDatabase();
        int res = db.delete(TABLE_SUBJECTS, ID_SUBJECTS+" = "+i, null);
        return res;
    }
}
