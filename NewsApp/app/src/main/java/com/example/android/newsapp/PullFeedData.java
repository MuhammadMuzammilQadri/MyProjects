package com.example.android.newsapp;

import android.os.AsyncTask;
import android.util.Log;

import com.example.android.newsapp.model.DataHandler;
import com.example.android.newsapp.model.Entries;
import com.example.android.newsapp.model.FeedData;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Muhammad Muzammil on 7/4/2016.
 */

class PullFeedData extends AsyncTask<String, String, String> {

    OnCompleteListener onCompleteListener;
    private HttpURLConnection urlConnection;
    private boolean isSuccessful = true;

    @Override
    protected String doInBackground(String... args) {

        StringBuilder result = new StringBuilder();

        try {
            String queryText = args[0].replace(" ", "%20");
            URL url = new URL("https://ajax.googleapis.com/ajax/services/feed/load?v=1.0&q=" + queryText);
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }

        } catch (Exception e) {
            isSuccessful = false;
            e.printStackTrace();
        } finally {
            urlConnection.disconnect();
            Util.dismissProgressDialog();
        }


        return result.toString();
    }

    @Override
    protected void onPostExecute(String result) {
        if (isSuccessful) {
            try {
                Log.d("jsontesting", result);
                Gson gson = new Gson();
                FeedData feedData = gson.fromJson(result, FeedData.class);

                try {
                    if (feedData.getResponseData().getFeed().getEntries() == null || feedData.getResponseData().getFeed().getEntries().size() < 1) {
                        onCompleteListener.onFailure(this);
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    onCompleteListener.onFailure(this);
                    return;
                }

                DataHandler.getInstance().addFeedData(feedData);
                extractDataFromFeedData(feedData);
                onCompleteListener.onSuccess(this);

            } catch (JsonSyntaxException e) {
                e.printStackTrace();
                onCompleteListener.onFailure(this);
            }
        } else {
            onCompleteListener.onFailure(this);
        }
    }

    private void extractDataFromFeedData(FeedData feedData) {
        ArrayList<Entries> entriesList = DataHandler.getInstance().getEntriesList();
        ArrayList<Entries> entries = feedData.getResponseData().getFeed().getEntries();
        for (int i = 0; i < entries.size(); i++) {
            entriesList.add(entries.get(i));
        }

    }


    interface OnCompleteListener {
        public void onSuccess(Object object);

        public void onFailure(Object object);
    }

}
