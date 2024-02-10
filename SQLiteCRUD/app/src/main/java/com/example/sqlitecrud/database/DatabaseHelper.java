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
        sqLiteDatabase.execSQL("INSERT INTO animals('eng','pl','counter','guess_time') VALUES ('Dog','Pies','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO animals('eng','pl','counter','guess_time') VALUES ('Cat','Kot','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO animals('eng','pl','counter','guess_time') VALUES ('Elephant','Słoń','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO animals('eng','pl','counter','guess_time') VALUES ('Lion','Lew','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO animals('eng','pl','counter','guess_time') VALUES ('Tiger','Tygrys','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO animals('eng','pl','counter','guess_time') VALUES ('Giraffe','Żyrafa','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO animals('eng','pl','counter','guess_time') VALUES ('Bear','Niedźwiedź','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO animals('eng','pl','counter','guess_time') VALUES ('Rabbit','Królik','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO animals('eng','pl','counter','guess_time') VALUES ('Horse','Koń','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO animals('eng','pl','counter','guess_time') VALUES ('Cow','Krowa','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO animals('eng','pl','counter','guess_time') VALUES ('Sheep','Owca','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO animals('eng','pl','counter','guess_time') VALUES ('Pig','Świnia','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO animals('eng','pl','counter','guess_time') VALUES ('Monkey','Małpa','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO animals('eng','pl','counter','guess_time') VALUES ('Bird','Ptak','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO animals('eng','pl','counter','guess_time') VALUES ('Fish','Ryba','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO animals('eng','pl','counter','guess_time') VALUES ('Dolphin','Delfin','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO animals('eng','pl','counter','guess_time') VALUES ('Snake','Wąż','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO animals('eng','pl','counter','guess_time') VALUES ('Fox','Lis','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO animals('eng','pl','counter','guess_time') VALUES ('Deer','Jeleń','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO animals('eng','pl','counter','guess_time') VALUES ('Penguin','Pingwin','0','0')");
        sqLiteDatabase.execSQL("CREATE TABLE tools(id INTEGER PRIMARY KEY AUTOINCREMENT, eng TEXT, pl TEXT, counter INTEGER, guess_time INTEGER)");
        sqLiteDatabase.execSQL("INSERT INTO tools('eng','pl','counter','guess_time') VALUES ('Hammer','Młotek','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO tools('eng','pl','counter','guess_time') VALUES ('Screwdriver','Śrubokręt','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO tools('eng','pl','counter','guess_time') VALUES ('Wrench','Klucz (do nakrętek)','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO tools('eng','pl','counter','guess_time') VALUES ('Pliers','Szczypce','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO tools('eng','pl','counter','guess_time') VALUES ('Saw','Piła','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO tools('eng','pl','counter','guess_time') VALUES ('Drill','Wiertarka','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO tools('eng','pl','counter','guess_time') VALUES ('Tape measure','Miarka','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO tools('eng','pl','counter','guess_time') VALUES ('Chisel','Dłuto','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO tools('eng','pl','counter','guess_time') VALUES ('Level','Poziomica','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO tools('eng','pl','counter','guess_time') VALUES ('Axe','Topór','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO tools('eng','pl','counter','guess_time') VALUES ('Screw','Śruba','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO tools('eng','pl','counter','guess_time') VALUES ('Nail','Gwóźdź','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO tools('eng','pl','counter','guess_time') VALUES ('Ruler','Linijka','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO tools('eng','pl','counter','guess_time') VALUES ('Glue','Klej','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO tools('eng','pl','counter','guess_time') VALUES ('Spanner','Klucz (do śrub)','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO tools('eng','pl','counter','guess_time') VALUES ('File','Pilnik','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO tools('eng','pl','counter','guess_time') VALUES ('Wire cutter','Obcinacz do drutu','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO tools('eng','pl','counter','guess_time') VALUES ('Trowel','Rydel','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO tools('eng','pl','counter','guess_time') VALUES ('Jack','Lewarek','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO tools('eng','pl','counter','guess_time') VALUES ('Clamp','Zszywka','0','0')");
        sqLiteDatabase.execSQL("CREATE TABLE plants(id INTEGER PRIMARY KEY AUTOINCREMENT, eng TEXT, pl TEXT, counter INTEGER, guess_time INTEGER)");
        sqLiteDatabase.execSQL("INSERT INTO plants('eng','pl','counter','guess_time') VALUES ('Tree','Drzewo','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO plants('eng','pl','counter','guess_time') VALUES ('Flower','Kwiat','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO plants('eng','pl','counter','guess_time') VALUES ('Grass','Trawa','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO plants('eng','pl','counter','guess_time') VALUES ('Rose','Róża','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO plants('eng','pl','counter','guess_time') VALUES ('Tulip','Tulipan','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO plants('eng','pl','counter','guess_time') VALUES ('Sunflower','Słonecznik','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO plants('eng','pl','counter','guess_time') VALUES ('Oak','Dąb','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO plants('eng','pl','counter','guess_time') VALUES ('Maple','Klon','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO plants('eng','pl','counter','guess_time') VALUES ('Pine','Sosna','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO plants('eng','pl','counter','guess_time') VALUES ('Bamboo','Bambus','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO plants('eng','pl','counter','guess_time') VALUES ('Cactus','Kaktus','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO plants('eng','pl','counter','guess_time') VALUES ('Fern','Paproć','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO plants('eng','pl','counter','guess_time') VALUES ('Daisy','Stokrotka','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO plants('eng','pl','counter','guess_time') VALUES ('Lily','Lilia','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO plants('eng','pl','counter','guess_time') VALUES ('Orchid','Storczyk','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO plants('eng','pl','counter','guess_time') VALUES ('Ivy','Bluszcz','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO plants('eng','pl','counter','guess_time') VALUES ('Dandelion','Mniszek lekarski','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO plants('eng','pl','counter','guess_time') VALUES ('Lavender','Lawenda','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO plants('eng','pl','counter','guess_time') VALUES ('Basil','Bazylia','0','0')");
        sqLiteDatabase.execSQL("INSERT INTO plants('eng','pl','counter','guess_time') VALUES ('Mint','Mięta','0','0')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS animals");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS tools");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS plants");
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
