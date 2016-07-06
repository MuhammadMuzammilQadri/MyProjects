package com.example.android.inventoryapp.DatabaeRelatedClasses;

/**
 * Created by Muhammad Muzammil on 7/6/2016.
 */

public class DatabaseContract {
    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public DatabaseContract() {}

    /* Inner class that defines the table contents */
    public static abstract class ProductEntry {
        public static final String TABLE_NAME = "productinformation";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_QUANTITY = "quantity";
        public static final String COLUMN_PRICE = "price";
        public static final String COLUMN_IMAGE = "image";
        public static final String COLUMN_SUPP_EMAIL = "email";
    }
}