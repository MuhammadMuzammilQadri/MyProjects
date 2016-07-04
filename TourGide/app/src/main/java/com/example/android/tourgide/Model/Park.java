package com.example.android.tourgide.Model;

import android.graphics.drawable.Drawable;

/**
 * Created by panacloud on 04/07/16.
 */
public class Park {
    Drawable imageOfPark;
    String name;
    String address;

    public Park(Drawable imageOfPark, String name, String address) {
        this.imageOfPark = imageOfPark;
        this.name = name;
        this.address = address;
    }

    public Drawable getImageOfPark() {
        return imageOfPark;
    }

    public void setImageOfPark(Drawable imageOfPark) {
        this.imageOfPark = imageOfPark;
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
