package com.example.android.inventoryapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.inventoryapp.DatabaeRelatedClasses.DatabaseHelper;
import com.example.android.inventoryapp.InventoryApp;
import com.example.android.inventoryapp.R;
import com.example.android.inventoryapp.fragments.ConfirmationDialogFragment;
import com.example.android.inventoryapp.models.DataHandler;
import com.example.android.inventoryapp.models.Product;


public class DetailActivity extends AppCompatActivity implements ConfirmationDialogFragment.onDismissConfirmationDialogListener {

    TextView nameTextView;
    TextView descTextView;
    TextView quantityTextView;
    TextView priceTextView;
    ImageView imageView;

    Button saleButton;
    Button shipmentButton;
    Button ordernowButton;
    Button deleteButton;


    int position;
    Product product;
    DatabaseHelper databaseHelper;
    DataHandler dataHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initializeComponents();
        populateViews();
        setUpListeners();

        Intent returnIntent = new Intent();
        setResult(Activity.RESULT_OK, returnIntent);
    }


    private void populateViews() {
        nameTextView.setText(product.getName());
        descTextView.setText("Email for the supplier of this product is: " + product.getSupplierEmail());
        quantityTextView.setText("Quantity: " + Integer.toString(product.getQuantity()));
        priceTextView.setText("Price: " + Double.toString(product.getPrice()));
        imageView.setImageBitmap(product.getImage());
    }

    private void initializeComponents() {
        nameTextView = (TextView) findViewById(R.id.name);
        descTextView = (TextView) findViewById(R.id.desc);
        quantityTextView = (TextView) findViewById(R.id.quantity);
        priceTextView = (TextView) findViewById(R.id.price);
        imageView = (ImageView) findViewById(R.id.imageview);

        saleButton = (Button) findViewById(R.id.sale);
        shipmentButton = (Button) findViewById(R.id.shipment);
        ordernowButton = (Button) findViewById(R.id.ordernow);
        deleteButton = (Button) findViewById(R.id.delete);

        dataHandler = DataHandler.getInstance();
        databaseHelper = DatabaseHelper.getInstance(InventoryApp.getContext());
        position = getIntent().getIntExtra("position", 0);
        product = dataHandler.getCustomArrayAdapter().getItem(position);

    }


    private void setUpListeners() {
        saleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                product.updateDecementQuantity();
                quantityTextView.setText("Quantity: " + Integer.toString(product.getQuantity()));

            }
        });
        shipmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                product.updateIncementQuantity();
                quantityTextView.setText("Quantity: " + Integer.toString(product.getQuantity()));
            }
        });
        ordernowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOrderNowActivity();
            }
        });
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showConfirmationDialog();
            }
        });
    }

    private void deleteButtonWork() {
        dataHandler.getCustomArrayAdapter().removeItem(position);
        product.deleteProduct();    //to delete product from SQL
        finish();
    }

    private void showConfirmationDialog() {
        ConfirmationDialogFragment dialogFragment = ConfirmationDialogFragment.newInstance();
        dialogFragment.setOnDismissDialogListener(this);
        dialogFragment.show(this.getSupportFragmentManager(), "ConfirmationDialog");
    }

    private void openOrderNowActivity() {
        String email = product.getSupplierEmail();
        String emailSubject = "Booking order for " + product.getName();
        String emailBody = "We want to book an order of 15 inventory items.";

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        String uriText = "mailto:" + Uri.encode(email) +
                "?subject=" + Uri.encode(emailSubject) +
                "&body=" + Uri.encode(emailBody);
        Uri uri = Uri.parse(uriText);
        emailIntent.setData(uri);
        startActivity(Intent.createChooser(emailIntent, "Send mail..."));
    }

    @Override
    public void onSuccessConfirmationDialog() {
        deleteButtonWork();
    }
}
