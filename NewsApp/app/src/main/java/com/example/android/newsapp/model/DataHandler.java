package com.example.android.newsapp.model;

import java.util.ArrayList;

/**
 * Created by Muhammad Muzammil on 7/4/2016.
 */

public class DataHandler {
    private static DataHandler singleton;
    private Data data;
    private ArrayList<FeedData> feedDatas = new ArrayList<>();
    private ArrayList<Entries> entriesList = new ArrayList<>();

    public static DataHandler getInstance() {
        if (singleton == null) {
            singleton = new DataHandler();
        }

        return singleton;
    }

    public ArrayList<Entries> getEntriesList() {
        return entriesList;
    }

    public void addEntries(Entries entry) {
        if (entry != null)
            this.entriesList.add(entry);
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public ArrayList<FeedData> getFeedDatas() {
        return feedDatas;
    }

    public void addFeedData(FeedData feedDatas) {
        if (feedDatas != null)
            this.feedDatas.add(feedDatas);
    }


}
