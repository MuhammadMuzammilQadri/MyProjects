package com.example.android.habittracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.android.habittracker.DatabaeRelatedClasses.DatabaseHelper;
import com.example.android.habittracker.model.Habit;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = DatabaseHelper.getInstance(MainActivity.this);
        databaseHelper.addHabit(new Habit("Sleep",65));
        databaseHelper.addHabit(new Habit("Wake",120));
        databaseHelper.addHabit(new Habit("Eating",30));

        databaseHelper.updateHabit(new Habit(1, "Sleeep", 90));
        databaseHelper.deleteHabit(2);

        databaseHelper.addHabit(new Habit("Playing",200));

        printHabits();

        Log.d("testing","Specific Habit");
        Habit habit = databaseHelper.getHabit(1);
        Log.d("testing", "ID: " + habit.getHabitId() + ", TITLE: " +
                habit.getHabitTitle() + ", DURATION: " + habit.getHabitDuartionInMinutes());

        Log.d("testing","Deleting entries..");
        databaseHelper.deleteAllHabits();
        printHabits();
    }

    private void printHabits() {

        ArrayList<Habit> list = databaseHelper.getAllHabits();
        for (Habit habit : list) {
            Log.d("testing", "ID: " + habit.getHabitId() + ", TITLE: " +
                    habit.getHabitTitle() + ", DURATION: " + habit.getHabitDuartionInMinutes());
        }
    }
}
