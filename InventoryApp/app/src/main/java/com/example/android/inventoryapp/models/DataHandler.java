package com.example.android.inventoryapp.models;

import com.example.android.inventoryapp.CustomArrayAdapter;

/**
 * Created by Muhammad Muzammil on 7/6/2016.
 */

public class DataHandler {
    private static DataHandler singleton;
    private CustomArrayAdapter customArrayAdapter;

    public static DataHandler getInstance() {
        if (singleton == null) {
            singleton = new DataHandler();
        }

        return singleton;
    }


    public CustomArrayAdapter getCustomArrayAdapter() {
        return customArrayAdapter;
    }

    public void setCustomArrayAdapter(CustomArrayAdapter customArrayAdapter) {
        this.customArrayAdapter = customArrayAdapter;
    }

}