package com.example.android.tourgide.Model;

import android.graphics.drawable.Drawable;

/**
 * Created by panacloud on 04/07/16.
 */
public class HistoricalPlace {
    Drawable imageOfHistoricalPlace;
    String name;
    String address;
    int ageInYears;

    public HistoricalPlace(Drawable imageOfHistoricalPlace, String name, String address, int ageInYears) {
        this.imageOfHistoricalPlace = imageOfHistoricalPlace;
        this.name = name;
        this.address = address;
        this.ageInYears = ageInYears;
    }

    public int getAgeInYears() {
        return ageInYears;
    }

    public void setAgeInYears(int ageInYears) {
        if (ageInYears > 0)
        this.ageInYears = ageInYears;
        else throw new RuntimeException("Invalid age");
    }

    public Drawable getImageOfHistoricalPlace() {
        return imageOfHistoricalPlace;
    }

    public void setImageOfHistoricalPlace(Drawable imageOfHistoricalPlace) {
        this.imageOfHistoricalPlace = imageOfHistoricalPlace;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address.trim();
    }


}
