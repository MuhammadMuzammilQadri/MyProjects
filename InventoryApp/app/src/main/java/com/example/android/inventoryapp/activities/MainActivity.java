package com.example.android.inventoryapp.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.inventoryapp.CustomArrayAdapter;
import com.example.android.inventoryapp.DatabaeRelatedClasses.DatabaseHelper;
import com.example.android.inventoryapp.InventoryApp;
import com.example.android.inventoryapp.R;
import com.example.android.inventoryapp.models.Product;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    CustomArrayAdapter customArrayAdapter;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseHelper = DatabaseHelper.getInstance(InventoryApp.getContext());
        addSomeDataInSQL();
        initializeComponents();
        setUpListeners();
    }


    private void addSomeDataInSQL() {
        databaseHelper.addProduct(new Product("First",10,50.6, BitmapFactory.decodeResource(getResources(),
                R.drawable.azizbhatti), "aa&gmail.com"));
        databaseHelper.addProduct(new Product("Second",11,51.6, BitmapFactory.decodeResource(getResources(),
                R.drawable.bagheqasim), "bb&hotmail.com"));
        databaseHelper.addProduct(new Product("Third",12,52.6, BitmapFactory.decodeResource(getResources(),
                R.drawable.bbqtonight), "cc&live.com"));
        databaseHelper.addProduct(new Product("Fourth",13,53.6, BitmapFactory.decodeResource(getResources(),
                R.drawable.botanicalgarden), "dd&yahoo.com"));
        databaseHelper.addProduct(new Product("Fifth",14,54.6, BitmapFactory.decodeResource(getResources(),
                R.drawable.cafeaylanto), "ee&hotmail.com"));
        databaseHelper.addProduct(new Product("Sixth",15,55.6, BitmapFactory.decodeResource(getResources(),
                R.drawable.clifton), "ff&gmail.com"));
        databaseHelper.addProduct(new Product("Seventh",16,56.6, BitmapFactory.decodeResource(getResources(),
                R.drawable.earlyislamiccemetry), "gg&gmail.com"));
        databaseHelper.addProduct(new Product("Eighth",17,57.6, BitmapFactory.decodeResource(getResources(),
                R.drawable.empressmarketkarachi), "hh&live.com"));
    }

    private void initializeComponents() {
        listView = (ListView) findViewById(R.id.mylistview);
        ArrayList<Product> products = databaseHelper.getAllProducts();
        customArrayAdapter = new CustomArrayAdapter(MainActivity.this, products);
        listView.setAdapter(customArrayAdapter);
    }


    private void setUpListeners() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("position", position);
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
               customArrayAdapter.notifyDataSetChanged();
            }
        }
    }
}
