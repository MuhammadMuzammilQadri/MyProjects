package com.example.android.newsapp.model;

/**
 * Created by Muhammad Muzammil on 7/5/2016.
 */


public class QueryResponseData {
    private String query;

    private QueryEntries[] entries;

    public String getQuery ()
    {
        return query;
    }

    public void setQuery (String query)
    {
        this.query = query;
    }

    public QueryEntries[] getEntries ()
    {
        return entries;
    }

    public void setEntries (QueryEntries[] entries)
    {
        this.entries = entries;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [query = "+query+", entries = "+entries+"]";
    }
}
