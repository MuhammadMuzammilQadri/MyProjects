package com.example.android.newsapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android.newsapp.model.DataHandler;

public class MainActivity extends AppCompatActivity implements PullData.OnCompleteListener {

    public static final String TOPIC = "technology/technology";
    ListView listView;
    private CustomArrayAdapter customArrayAdpater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.mylistview);

        fetchData();
    }

    private void fetchData() {
        PullData pullData = new PullData(MainActivity.this);
        pullData.onCompleteListener = this;
        pullData.execute();
    }

    @Override
    public void onSuccess(Object object) {
        if (object instanceof PullData) {
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
            Log.d("Muz", "PullData onSuccess");
            customArrayAdpater = new CustomArrayAdapter(MainActivity.this, DataHandler.getInstance().getData().getResponse().getResults());
            listView.setAdapter(customArrayAdpater);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Uri uri = Uri.parse(customArrayAdpater.getItem(position).getWebUrl());
                    Intent i = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(i);
                }
            });

        }
    }

    @Override
    public void onFailure(Object object) {
        if (object instanceof PullData) {
            Toast.makeText(this, "Failure", Toast.LENGTH_SHORT).show();
        }
    }

}

