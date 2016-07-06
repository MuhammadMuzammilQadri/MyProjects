package com.example.android.inventoryapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.inventoryapp.CustomArrayAdapter;
import com.example.android.inventoryapp.DatabaeRelatedClasses.DatabaseHelper;
import com.example.android.inventoryapp.InventoryApp;
import com.example.android.inventoryapp.R;
import com.example.android.inventoryapp.Util;
import com.example.android.inventoryapp.models.Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int MAIN_TO_ADDNEWPRODUCT = 3;
    private static final int MAIN_TO_DETAIL = 1;
    ListView listView;
    CustomArrayAdapter customArrayAdapter;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseHelper = DatabaseHelper.getInstance(InventoryApp.getContext());
        initializeComponents();
        setUpListeners();
    }


    private void initializeComponents() {
        listView = (ListView) findViewById(R.id.mylistview);
        new AsyncTask<Void,Void,ArrayList<Product>>(){

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                Util.showProgressDialog(MainActivity.this);
            }

            @Override
            protected ArrayList<Product> doInBackground(Void... params) {
                ArrayList<Product> products = databaseHelper.getAllProducts();
                return products;
            }

            @Override
            protected void onPostExecute(ArrayList<Product> products) {
                super.onPostExecute(products);
                customArrayAdapter = new CustomArrayAdapter(MainActivity.this, products);
                listView.setAdapter(customArrayAdapter);
                Util.dismissProgressDialog();
            }
        }.execute();
    }


    private void setUpListeners() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("position", position);
                startActivityForResult(intent,MAIN_TO_DETAIL);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return super.onCreateOptionsMenu(menu);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.addproduct:
                addProduct();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void addProduct() {
        startActivityForResult(new Intent(MainActivity.this,AddNewProductActivity.class), MAIN_TO_ADDNEWPRODUCT);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == MAIN_TO_DETAIL && resultCode == Activity.RESULT_OK) {
                customArrayAdapter.notifyDataSetChanged();
        }

        if (requestCode == MAIN_TO_ADDNEWPRODUCT && resultCode == Activity.RESULT_OK) {
            if (data == null) {
                return;
            }
                final String name = data.getStringExtra("name");
                final String mail = data.getStringExtra("mail");
                final double price = Double.parseDouble(data.getStringExtra("price")) ;
                final int quantity = Integer.parseInt(data.getStringExtra("quantity"));
                final String filename = data.getStringExtra("image");


                new AsyncTask<Void, Void, Product>(){
                    @Override
                    protected Product doInBackground(Void... params) {
                        Bitmap bitmap = loadTempImage(filename);
                        Product product = new Product(name, quantity, price, bitmap, mail);
                        databaseHelper.addProduct(product);
                        return product;
                    }

                    @Override
                    protected void onPostExecute(Product product) {
                        super.onPostExecute(product);
                        customArrayAdapter.addItem(product);
                    }
                }.execute();
        }
    }

    private Bitmap loadTempImage(String filename){
        Bitmap bmp = null;
        try {
            FileInputStream is = this.openFileInput(filename);
            bmp = BitmapFactory.decodeStream(is);
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bmp;
    }
}
