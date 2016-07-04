package com.example.android.newsapp.model;

/**
 * Created by Muhammad Muzammil on 7/4/2016.
 */


public class Data
{
    private QueryResponseData queryResponseData;

    private String responseStatus;

    public QueryResponseData getQueryResponseData()
    {
        return queryResponseData;
    }

    public void setQueryResponseData(QueryResponseData queryResponseData)
    {
        this.queryResponseData = queryResponseData;
    }


    public String getResponseStatus ()
    {
        return responseStatus;
    }

    public void setResponseStatus (String responseStatus)
    {
        this.responseStatus = responseStatus;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [queryResponseData = "+ queryResponseData +", responseStatus = "+responseStatus+"]";
    }
}
