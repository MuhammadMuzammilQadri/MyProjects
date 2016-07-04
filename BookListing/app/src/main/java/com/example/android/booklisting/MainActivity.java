package com.example.android.booklisting;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.booklisting.model.DataHandler;

public class MainActivity extends AppCompatActivity implements PullData.OnCompleteListener {

    Button searchButton;
    EditText searchField;
    ListView listView;
    private TextView listViewAlternativeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeComponents();
        setUpListeners();
    }

    private void setUpListeners() {
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = searchField.getText().toString();
                text = text.trim();
                if (text.equals(""))
                    return;

                Util.showProgressDialog(MainActivity.this);
                fetchData(text);

            }
        });
    }

    private void initializeComponents() {
        searchButton = (Button) findViewById(R.id.searchButton);
        searchField = (EditText) findViewById(R.id.searchField);
        listView = (ListView) findViewById(R.id.mylistview);
        listViewAlternativeTextView = (TextView) findViewById(R.id.mylistview_alternative);

        listView.setVisibility(View.GONE);
        listViewAlternativeTextView.setVisibility(View.VISIBLE);

    }

    private void fetchData(String text) {
        PullData object = new PullData();
        object.onCompleteListener = this;
        object.execute(text);
    }

    @Override
    public void onSuccess() {
//        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
        listView.setVisibility(View.VISIBLE);
        listViewAlternativeTextView.setVisibility(View.GONE);
        listView.setAdapter(new CustomArrayAdapter(MainActivity.this, DataHandler.getInstance().getData().getItems()));
//        ((BaseAdapter)listView.getAdapter()).notifyDataSetChanged();
    }


    @Override
    public void onFailure() {

        listView.setVisibility(View.GONE);
        listViewAlternativeTextView.setVisibility(View.VISIBLE);

        Toast.makeText(this, "Request failed.", Toast.LENGTH_SHORT).show();
        listView.setAdapter(null);


    }


}
