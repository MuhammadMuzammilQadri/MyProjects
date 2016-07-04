package com.example.android.newsapp.model;

/**
 * Created by Muhammad Muzammil on 7/4/2016.
 */

public class DataHandler {
    private static DataHandler singleton;
    private Data data;


    public static DataHandler getInstance() {
        if (singleton == null) {
            singleton = new DataHandler();
        }

        return singleton;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }


}
