package com.example.android.habittracker.model;

/**
 * Created by Muhammad Muzammil on 7/6/2016.
 */
public class Habit {
    private int habitId;
    private String habitTitle;
    private int habitDuartionInMinutes;


    public Habit(){

    }

    public Habit(String habitTitle, int habitDuartionInMinutes) {
        this.habitTitle = habitTitle;
        this.habitDuartionInMinutes = habitDuartionInMinutes;
    }

    public Habit(int habitId, String habitTitle, int habitDuartionInMinutes) {
        this.habitId = habitId;
        this.habitTitle = habitTitle;
        this.habitDuartionInMinutes = habitDuartionInMinutes;
    }



    public int getHabitId() {
        return habitId;
    }

    public void setHabitId(int habitId) {
        this.habitId = habitId;
    }

    public String getHabitTitle() {
        return habitTitle;
    }

    public void setHabitTitle(String habitTitle) {
        this.habitTitle = habitTitle;
    }

    public int getHabitDuartionInMinutes() {
        return habitDuartionInMinutes;
    }

    public void setHabitDuartionInMinutes(int habitDuartionInMinutes) {
        this.habitDuartionInMinutes = habitDuartionInMinutes;
    }
}
