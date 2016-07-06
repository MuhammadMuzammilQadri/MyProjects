package com.example.android.inventoryapp;

import android.app.Application;
import android.content.Context;

/**
 * Created by Muhammad Muzammil on 7/6/2016.
 */

public class InventoryApp extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        this.context = getApplicationContext();
    }

    public static Context getContext(){
        return context;
    }

}
