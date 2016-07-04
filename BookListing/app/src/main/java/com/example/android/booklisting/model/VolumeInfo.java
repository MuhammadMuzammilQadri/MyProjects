package com.example.android.booklisting.model;

/**
 * Created by Muhammad Muzammil on 7/4/2016.
 */

public class VolumeInfo {
    private String[] authors;
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }
}
