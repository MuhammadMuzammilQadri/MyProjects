package com.example.android.newsapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android.newsapp.model.Data;
import com.example.android.newsapp.model.DataHandler;
import com.example.android.newsapp.model.QueryEntries;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PullData.OnCompleteListener, PullFeedData.OnCompleteListener {

    public static final String TOPIC = "popular";
    ListView listView;
    private CustomArrayAdapter customArrayAdpater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.mylistview);
        customArrayAdpater = new CustomArrayAdapter(MainActivity.this);
        listView.setAdapter(customArrayAdpater);

        fetchData();
    }

    private void fetchData() {
        PullData pullData = new PullData();
        pullData.onCompleteListener = this;
        pullData.execute();
    }

    @Override
    public void onSuccess(Object object) {
        if (object instanceof PullData) {
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
            Log.d("Muz", "PullData onSuccess");

            pullAllFeedData();

        } else if (object instanceof PullFeedData) {
            Log.d("Muz", "PullFeedData onSuccess, " + DataHandler.getInstance().getData().getQueryResponseData().getEntries().size()
                    + " == " + DataHandler.getInstance().getFeedDatas().size());

            customArrayAdpater.notifyDataSetChanged();

//            extractDataFromFeedData(DataHandler.getInstance().getFeedDatas());

//            if (DataHandler.getInstance().getData().getQueryResponseData().getEntries().size() ==
//                    DataHandler.getInstance().getFeedDatas().size()){
//                customArrayAdpater.notifyDataSetChanged();
//            }
        }


    }


    private void pullAllFeedData() {
        Data data = DataHandler.getInstance().getData();
        ArrayList<QueryEntries> queryEntries = data.getQueryResponseData().getEntries();
        for (int i = 0; i < queryEntries.size(); i++) {
            String queryUrl = queryEntries.get(i).getUrl();
            PullFeedData pullFeedData = new PullFeedData();
            pullFeedData.onCompleteListener = this;
            pullFeedData.execute(queryUrl);
        }

    }

    @Override
    public void onFailure(Object object) {
        if (object instanceof PullData) {
            Toast.makeText(this, "Failure", Toast.LENGTH_SHORT).show();
        } else if (object instanceof PullFeedData) {
            Log.d("Muz", "PullFeedData onFailure");

        }
    }

}

