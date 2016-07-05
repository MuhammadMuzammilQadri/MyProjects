package com.example.android.newsapp.model;

/**
 * Created by Muhammad Muzammil on 7/5/2016.
 */

public class MediaGroups {
    private Contents[] contents;

    public Contents[] getContents() {
        return contents;
    }

    public void setContents(Contents[] contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "ClassPojo [contents = " + contents + "]";
    }
}

