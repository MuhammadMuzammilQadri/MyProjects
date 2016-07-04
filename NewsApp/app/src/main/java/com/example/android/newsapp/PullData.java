package com.example.android.newsapp;

import android.os.AsyncTask;
import android.util.Log;

import com.example.android.newsapp.model.Data;
import com.example.android.newsapp.model.DataHandler;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Muhammad Muzammil on 7/4/2016.
 */

class PullData extends AsyncTask<String, String, String> {

    private HttpURLConnection urlConnection;
    private boolean isSuccessful = true;
    OnCompleteListener onCompleteListener;

    @Override
    protected String doInBackground(String... args) {

        StringBuilder result = new StringBuilder();

        try {
            String queryText = args[0].replace(" ", "%20");
            URL url = new URL("https://www.googleapis.com/books/v1/volumes?q=" + queryText);
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
                Data data = gson.fromJson(result, Data.class);

//                if (data.getItems() == null || data.getItems().size() < 1) {
//                    onCompleteListener.onFailure();
//                    return;
//                }

                DataHandler.getInstance().setData(data);
                onCompleteListener.onSuccess();
            } catch (JsonSyntaxException e) {
                e.printStackTrace();
                onCompleteListener.onFailure();
            }
        } else {
            onCompleteListener.onFailure();
        }
    }

    interface OnCompleteListener {
        public void onSuccess();
        public void onFailure();
    }
}
