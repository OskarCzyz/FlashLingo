package com.example.sqlitecrud.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.sqlitecrud.model.FlashCard;

import java.util.Calendar;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "flashcards";
    public static final int DB_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE animals(id INTEGER PRIMARY KEY AUTOINCREMENT, eng TEXT, pl TEXT, counter INTEGER, guess_time INTEGER)");
        sqLiteDatabase.execSQL("INSERT INTO animals('eng','pl','counter','guess_time') VALUES ('Cow','Krowa','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO animals('eng','pl','counter','guess_time') VALUES ('Dog','Pies','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO animals('eng','pl','counter','guess_time') VALUES ('Cat','Kot','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO animals('eng','pl','counter','guess_time') VALUES ('Duck','Kaczka','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO animals('eng','pl','counter','guess_time') VALUES ('Goose','Gęś','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO animals('eng','pl','counter','guess_time') VALUES ('Horse','Koń','0','0')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS animals");
        onCreate(sqLiteDatabase);
    }
    public Cursor getSet(String set) {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM " + set;
        Cursor cursor = null;
        if( db != null) {
            cursor = db.rawQuery(sql, null);
        }
        return cursor;
    }
    public void updateTable(FlashCard flashCard, String TABLE_NAME, boolean correct) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("eng", flashCard.getEng());
        values.put("pl", flashCard.getPl());
        values.put("counter", correct ? flashCard.getCounter() + 1 : 0);
        values.put("guess_time", Calendar.getInstance().getTimeInMillis());

        db.update(TABLE_NAME, values, "eng=?", new String[]{flashCard.getEng()});
        db.close();
    }
}
