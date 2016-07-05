package com.example.android.newsapp;

import android.content.Context;
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

    private final Context mContext;
    OnCompleteListener onCompleteListener;
    private HttpURLConnection urlConnection;
    private boolean isSuccessful = true;

    PullData(Context context) {
        mContext = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Util.showProgressDialog(mContext);
    }

    @Override
    protected String doInBackground(String... args) {

        StringBuilder result = new StringBuilder();

        try {
            URL url = new URL("http://content.guardianapis.com/search?tag=" + MainActivity.TOPIC + "&api-key=test&show-fields=thumbnail");
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

                try {
                    if (data.getResponse().getResults() == null || data.getResponse().getResults().size() < 1) {
                        onCompleteListener.onFailure(this);
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    onCompleteListener.onFailure(this);
                    return;
                }

                DataHandler.getInstance().setData(data);
                onCompleteListener.onSuccess(this);

            } catch (JsonSyntaxException e) {
                e.printStackTrace();
                onCompleteListener.onFailure(this);
            }
        } else {
            onCompleteListener.onFailure(this);
        }
    }

    interface OnCompleteListener {
        public void onSuccess(Object object);

        public void onFailure(Object object);
    }
}
