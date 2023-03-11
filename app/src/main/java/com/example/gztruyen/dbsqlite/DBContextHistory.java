package com.example.gztruyen.dbsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBContextHistory extends SQLiteOpenHelper {

    public static int DB_VERSION = 1;
    public static String DB_NAME = "goods";


    public DBContextHistory(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public static String TB_HISTORY_NAME = "history";
    public static String TB_HISTORY_COL_ID = "id";
    public static String TB_HISTORY_COL_NAME = "name";

    public static String TB_HISTORY_COL_IMAGE = "image";
    public static String TB_HISTORY_COL_CREATE_TIME = "create_time";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL( "CREATE TABLE " + TB_HISTORY_NAME + " (\n" +
                TB_HISTORY_COL_ID + "   INTEGER PRIMARY KEY,\n" +
                TB_HISTORY_COL_NAME + "   TEXT,\n" +
                TB_HISTORY_COL_IMAGE + "   TEXT,\n" +
                TB_HISTORY_COL_CREATE_TIME + "  TEXT\n" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
        if (newVer >= 2 && oldVer < 2) {
            db.execSQL("alter table dictionary\n" + "    add createdBy integer;");
        }
        if (newVer >= 3 && oldVer < 3) {
            db.execSQL("alter table dictionary\n" + "    add updatedBy integer;");
        }
    }

    public long insertHistory(String name, String image, String createTime) {
        ContentValues values = new ContentValues();
        values.put(TB_HISTORY_COL_NAME, name);
        values.put(TB_HISTORY_COL_IMAGE, image);
        values.put(TB_HISTORY_COL_CREATE_TIME, createTime);

        return this.getWritableDatabase().insert(TB_HISTORY_NAME, null, values);
    }

    public long updateHistory(int id, String name, String image, String createTime) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(TB_HISTORY_COL_NAME, name);
        contentValues.put(TB_HISTORY_COL_IMAGE, image);
        contentValues.put(TB_HISTORY_COL_CREATE_TIME, createTime);
        return this.getWritableDatabase().update(TB_HISTORY_NAME, contentValues, "id = ?", new String[]{id + ""});
    }

}
