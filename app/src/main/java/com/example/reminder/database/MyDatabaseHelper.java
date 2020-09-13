package com.example.reminder.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.reminder.models.Event;

import java.util.ArrayList;
import java.util.List;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;

    private static final String DATABASE_NAME = "data";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "binh";
    private static final String ID = "id";
    private static final String TITLE = "title";
    private static final String CATEGORY = "category";
    private static final String DATE= "date";
    private static final String TIME = "time";
    private static final String REPEAT = "repeat";
    private static final String REMIND = "remind";
    private static final String RING = "ring";
    private static final String THEME = "theme";
    private static final String GHIM = "ghim";
    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlQuery = "CREATE TABLE "+TABLE_NAME +" (" +
                ID +" integer primary key, "+
                TITLE + " TEXT, "+
                CATEGORY + " TEXT, "+
                DATE +" TEXT, "+
                TIME+" TEXT," +
                REPEAT+" TEXT," +
                REMIND+" TEXT," +
                RING+" TEXT," +
                THEME+" TEXT," +
                GHIM +" TEXT)";
        db.execSQL(sqlQuery);
        Toast.makeText(context, "Create successfylly", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
        Toast.makeText(context, "Drop successfylly", Toast.LENGTH_SHORT).show();
    }
    public void addEventt(Event event){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TITLE, event.getTitle());
        values.put(CATEGORY, event.getCategory());
        values.put(DATE, event.getDate());
        values.put(TIME, event.getTime());
        values.put(REPEAT, event.getRepeat());
        values.put(REMIND, event.getRemind());
        values.put(RING, event.getRing());
        values.put(THEME, event.getTheme());
        values.put(GHIM, event.getGhim());

        db.insert(TABLE_NAME,null,values);
        db.close();
    }
    public Event getEventById(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[] { ID,
                        TITLE,CATEGORY,DATE,TIME,REPEAT,REMIND,RING,THEME,GHIM }, ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
//        Cursor cursor;
//        cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME +" WHERE id = '1'",null);
        if (cursor != null)
            cursor.moveToFirst();

        Event event = new Event(cursor.getInt(0)
                ,cursor.getString(1)
                ,cursor.getString(2)
                ,cursor.getString(3)
                ,cursor.getString(4)
                ,cursor.getString(5)
                ,cursor.getString(6)
                ,cursor.getString(7)
                ,cursor.getString(8)
                ,cursor.getString(9));
        cursor.close();
        db.close();
        return event;
    }
    public List<Event> getAllEvent() {
        List<Event> listEvent = new ArrayList<Event>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Event event = new Event();
                event.setId(cursor.getInt(0));
                event.setTitle(cursor.getString(1));
                event.setCategory(cursor.getString(2));
                event.setDate(cursor.getString(3));
                event.setTime(cursor.getString(4));
                event.setRepeat(cursor.getString(5));
                event.setRemind(cursor.getString(6));
                event.setRing(cursor.getString(7));
                event.setTheme(cursor.getString(8));
                event.setGhim(cursor.getString(9));

                listEvent.add(event);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listEvent;
    }
    public int Update(Event event){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(TITLE,event.getTitle());

        return db.update(TABLE_NAME,values,ID +"=?",new String[] { String.valueOf(event.getId())});


    }
    public void deleteEvent(Event event) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, ID + " = ?",
                new String[] { String.valueOf(event.getId()) });
        db.close();
    }
    public int getEventsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        return cursor.getCount();
    }

}
