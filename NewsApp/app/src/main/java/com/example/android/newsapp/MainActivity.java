package com.example.android.newsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements PullData.OnCompleteListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void fetchData(String text) {
        PullData object = new PullData();
        object.onCompleteListener = this;
        object.execute(text);
    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onFailure() {

    }
}
