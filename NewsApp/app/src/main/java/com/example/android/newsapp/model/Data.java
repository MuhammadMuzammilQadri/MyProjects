package com.example.android.newsapp.model;

/**
 * Created by Muhammad Muzammil on 7/5/2016.
 */

public class Data {
    private Response response;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "ClassPojo [response = " + response + "]";
    }
}

