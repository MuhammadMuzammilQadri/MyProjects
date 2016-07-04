package com.example.android.tourgide.Model;

import android.graphics.drawable.Drawable;

/**
 * Created by panacloud on 04/07/16.
 */
public class Restaurant {
    Drawable imageOfRestaurant;
    String name;
    String address;
    double rating;

    public Restaurant(Drawable imageOfRestaurant, String name, String address, double rating) {
        this.imageOfRestaurant = imageOfRestaurant;
        this.name = name;
        this.address = address;
        this.rating = rating;
    }

    public Drawable getImageOfRestaurant() {
        return imageOfRestaurant;
    }

    public void setImageOfRestaurant(Drawable imageOfRestaurant) {
        this.imageOfRestaurant = imageOfRestaurant;
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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        if (rating >= 0 && rating <= 5)
        this.rating = rating;
        else throw new RuntimeException("Invalid rating");
    }
}
