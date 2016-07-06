package com.example.android.habittracker.DatabaeRelatedClasses;

import android.provider.BaseColumns;

/**
 * Created by Muhammad Muzammil on 7/6/2016.
 */

public class DatabaseContract {
    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public DatabaseContract() {}

    /* Inner class that defines the table contents */
    public static abstract class HabitEntry {
        public static final String TABLE_NAME = "entry";
        public static final String COLUMN_ID = "id";
        public static final String HABIT_TITLE = "title";
        public static final String HABIT_DURATION_IN_MINUTES = "habitDurationInMinutes";

    }
}