package com.example.android.newsapp.model;

/**
 * Created by Muhammad Muzammil on 7/5/2016.
 */


public class FeedData
{
    private ResponseData responseData;


    private String responseStatus;

    public ResponseData getResponseData ()
    {
        return responseData;
    }

    public void setResponseData (ResponseData responseData)
    {
        this.responseData = responseData;
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
        return "ClassPojo [responseData = "+responseData+", responseStatus = "+responseStatus+"]";
    }
}

