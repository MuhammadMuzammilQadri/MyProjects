package com.example.android.newsapp.model;

/**
 * Created by Muhammad Muzammil on 7/5/2016.
 */


public class Contents {
    private String height;

    private String width;

    private String type;

    private String medium;

    private String url;

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ClassPojo [height = " + height + ", width = " + width + ", type = " + type + ", medium = " + medium + ", url = " + url + "]";
    }
}
