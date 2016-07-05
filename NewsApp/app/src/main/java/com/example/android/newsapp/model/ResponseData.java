package com.example.android.newsapp.model;

/**
 * Created by Muhammad Muzammil on 7/5/2016.
 */

public class ResponseData {
    private Feed feed;

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }

    @Override
    public String toString() {
        return "ClassPojo [feed = " + feed + "]";
    }
}

