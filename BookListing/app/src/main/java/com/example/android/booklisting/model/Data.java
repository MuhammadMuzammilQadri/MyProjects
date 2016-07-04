package com.example.android.booklisting.model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Muhammad Muzammil on 7/4/2016.
 */

public class Data {
    private Items[] items;

    public ArrayList<Items> getItems() {
        if (items == null)
            return null;
        return new ArrayList<Items>(Arrays.asList(items));
    }

    public void setItems(Items[] items) {
        this.items = items;
    }
}
