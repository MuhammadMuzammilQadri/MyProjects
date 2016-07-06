package com.example.android.inventoryapp.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.inventoryapp.R;
import com.example.android.inventoryapp.TextValidator;
import com.example.android.inventoryapp.Util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

public class AddNewProductActivity extends AppCompatActivity {

    private static final int PICK_PHOTO_FOR_PRODUCT = 2;
    EditText name;
    EditText mail;
    EditText price;
    EditText quantity;
    Button imagePicker;
    Button doneButton;

    boolean firstET;
    boolean secondET;
    boolean thirdET;
    boolean fourthET;
    boolean fifthIP;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_product);

        initializeComponents();
        setUpListeners();

    }

    private void setUpListeners() {
        name.addTextChangedListener(new TextValidator(name) {
            @Override
            public void validate(TextView textView, String text) {
                if (text.length() == 0) {
                    textView.setError("Name field cant not be null");
                    firstET = false;
                } else {
                    firstET = true;
                }
            }
        });


        mail.addTextChangedListener(new TextValidator(mail) {
            @Override
            public void validate(TextView textView, String text) {
                if (text.length() == 0 || !Util.isValidEmail(text)) {
                    textView.setError("Email is not valid");
                    secondET = false;
                } else {
                    secondET = true;

                }
            }
        });


        price.addTextChangedListener(new TextValidator(price) {
            @Override
            public void validate(TextView textView, String text) {
                boolean isDouble = false;
                try {
                    double price = Double.parseDouble(text);
                    isDouble = true;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    isDouble = false;
                }

                if (text.length() == 0 || !isDouble) {
                    textView.setError("Wrong value");
                    thirdET = false;
                } else {
                    thirdET = true;
                }
            }
        });


        quantity.addTextChangedListener(new TextValidator(quantity) {
            @Override
            public void validate(TextView textView, String text) {
                if (text.length() == 0) {
                    textView.setError("Wrong value");
                    fourthET = false;
                } else {
                    fourthET = true;
                }
            }
        });

        imagePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickImage();
            }
        });

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (firstET && secondET && thirdET && fourthET && fifthIP){
                    final Intent returnIntent = new Intent();
                    returnIntent.putExtra("name", name.getText().toString());
                    returnIntent.putExtra("mail",mail.getText().toString());
                    returnIntent.putExtra("price",price.getText().toString());
                    returnIntent.putExtra("quantity",quantity.getText().toString());

                    new AsyncTask<Void,Void,Void>(){

                        @Override
                        protected void onPreExecute() {
                            super.onPreExecute();
                            Util.showProgressDialog(AddNewProductActivity.this);
                        }

                        @Override
                        protected Void doInBackground(Void... params) {
                            if (bitmap != null)
                                saveTempImage(bitmap, returnIntent);
                            return null;
                        }

                        @Override
                        protected void onPostExecute(Void aVoid) {
                            super.onPostExecute(aVoid);
                            setResult(Activity.RESULT_OK, returnIntent);
                            Util.dismissProgressDialog();
                            finish();
                        }
                    }.execute();

                } else
                    Toast.makeText(AddNewProductActivity.this, "Please enter all values first", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void saveTempImage(Bitmap bmp, Intent returnIntent){
        try {
            //Write file
            String filename = "bitmap.png";
            FileOutputStream stream = this.openFileOutput(filename, Context.MODE_PRIVATE);
            bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);

            //Cleanup
            stream.close();
            bmp.recycle();

            //Pop intent
            returnIntent.putExtra("image", filename);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void initializeComponents() {
        name = (EditText) findViewById(R.id.name);
        mail = (EditText) findViewById(R.id.mail);
        price = (EditText) findViewById(R.id.price);
        quantity = (EditText) findViewById(R.id.quantity);
        imagePicker = (Button) findViewById(R.id.imagePicker);
        doneButton = (Button) findViewById(R.id.doneButton);
    }

    public void pickImage() {
        fifthIP = false;
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, PICK_PHOTO_FOR_PRODUCT);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_PHOTO_FOR_PRODUCT && resultCode == Activity.RESULT_OK) {
            if (data == null) {
                return;
            }

            try {
                InputStream inputStream = getContentResolver().openInputStream(data.getData());
                bitmap = BitmapFactory.decodeStream(inputStream);
                fifthIP = true;

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            //Now you can do whatever you want with your inpustream, save it as file, upload to a server, decode a bitmap...
        }
    }

}
