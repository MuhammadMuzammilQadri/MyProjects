package com.example.android.tourgide.Model;

import android.graphics.drawable.Drawable;

/**
 * Created by panacloud on 04/07/16.
 */
public class PublicPlace {
    Drawable imageOfPublicPlace;
    String name;
    String address;

    public PublicPlace(Drawable imageOfPublicPlace, String name, String address) {
        this.imageOfPublicPlace = imageOfPublicPlace;
        this.name = name;
        this.address = address;
    }

    public Drawable getImageOfPublicPlace() {
        return imageOfPublicPlace;
    }

    public void setImageOfPublicPlace(Drawable imageOfPublicPlace) {
        this.imageOfPublicPlace = imageOfPublicPlace;
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
