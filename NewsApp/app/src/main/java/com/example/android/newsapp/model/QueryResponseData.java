package com.example.android.newsapp.model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Muhammad Muzammil on 7/5/2016.
 */


public class QueryResponseData {
    private String query;

    private QueryEntries[] entries;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public ArrayList<QueryEntries> getEntries() {
        if (entries == null)
            return null;
        return new ArrayList<QueryEntries>(Arrays.asList(entries));
//        return entries;
    }

    public void setEntries(QueryEntries[] entries) {
        this.entries = entries;
    }

    @Override
    public String toString() {
        return "ClassPojo [query = " + query + ", entries = " + entries + "]";
    }
}
