package com.example.android.habittracker.DatabaeRelatedClasses;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.android.habittracker.DatabaeRelatedClasses.DatabaseContract.HabitEntry;
import com.example.android.habittracker.model.Habit;

import java.util.ArrayList;

/**
 * Created by Omii026 on 3/23/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;
    public static DatabaseHelper ourInstance;

    // Database Name
    private static final String DATABASE_NAME = "HabitTracker.db";

    private static final String TEXT_TYPE = " TEXT";
    private static final String INT_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + HabitEntry.TABLE_NAME + " (" +
                    HabitEntry.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    HabitEntry.HABIT_TITLE + TEXT_TYPE + COMMA_SEP +
                    HabitEntry.HABIT_DURATION_IN_MINUTES + INT_TYPE +
            " )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + HabitEntry.TABLE_NAME;

    public static DatabaseHelper getInstance (Context context){

        if (ourInstance == null)
            ourInstance = new DatabaseHelper(context);

        return ourInstance;
    }

    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        deleteDatabase(context);
    }

    private void deleteDatabase(Context context) {
        context.deleteDatabase(DATABASE_NAME);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d("testing", "in onCreate");
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        Log.d("testing", "in onUpgrade");
        sqLiteDatabase.execSQL("DROP TABLE IF EXIST " + HabitEntry.TABLE_NAME);
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }



//    add Habit
    public void addHabit(Habit habit){

        if (habit.getHabitId() != 0)
            throw new RuntimeException("While adding you cant set primary key on your own");

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(HabitEntry.HABIT_TITLE, habit.getHabitTitle());
        values.put(HabitEntry.HABIT_DURATION_IN_MINUTES, habit.getHabitDuartionInMinutes());

        db.insert(HabitEntry.TABLE_NAME,HabitEntry.HABIT_TITLE,values);
        db.close();
    }

//    get specific Habit
    public Habit getHabit(int id){
    SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(HabitEntry.TABLE_NAME,
                new String[]{HabitEntry.HABIT_TITLE,HabitEntry.HABIT_DURATION_IN_MINUTES},
                HabitEntry.COLUMN_ID + "=?",new String[]{String.valueOf(id)},
                null,null,null,null
                );

        if(cursor != null)
            cursor.moveToFirst();

        Habit habit = new Habit(
                cursor.getInt(0),
                cursor.getString(1),
                cursor.getInt(2)
        );
        return habit;
    }

//    get all Habits
    public ArrayList<Habit> getAllHabits(){

        ArrayList<Habit> habitList = new ArrayList<Habit>();
        String selectQuery = "SELECT * FROM " + HabitEntry.TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);

        if(cursor.moveToFirst()){
            do{
                Habit habit = new Habit();
                habit.setHabitId(cursor.getInt(0));
                habit.setHabitTitle(cursor.getString(1));
                habit.setHabitDuartionInMinutes(cursor.getInt(2));
                habitList.add(habit);
            }while(cursor.moveToNext());

        }
        return habitList;
    }

//    get Habits count
    public int getHabitsCount(){
        SQLiteDatabase db = this.getReadableDatabase();
        String countQuery = "SELECT * FROM "+HabitEntry.TABLE_NAME;
        Cursor cursor = db.rawQuery(countQuery,null);
        db.close();
        return cursor.getCount();
    }

//    update Habit
    public int updateHabit(Habit habit){
        if (habit.getHabitId() <= 0)
            throw new RuntimeException("While updating Habit ID can not be less than equal to zero");

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(HabitEntry.COLUMN_ID,habit.getHabitId());
        values.put(HabitEntry.HABIT_TITLE,habit.getHabitTitle());
        values.put(HabitEntry.HABIT_DURATION_IN_MINUTES,habit.getHabitDuartionInMinutes());

        return  db.update(HabitEntry.TABLE_NAME,values,HabitEntry.COLUMN_ID + "=?", new String[] {String.valueOf(habit.getHabitId())});
    }

//    delete Habit
    public void deleteHabit(int habitId){

        if (habitId <= 0)
            throw new RuntimeException("While deleting Habit ID can not be less than equal to zero");

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(HabitEntry.TABLE_NAME,HabitEntry.COLUMN_ID + "=?",new String[]{String.valueOf(habitId)});
        db.close();
    }


    //    delete all Habits
    public void deleteAllHabits(){

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(HabitEntry.TABLE_NAME,null,null);
        db.close();
    }




























}
