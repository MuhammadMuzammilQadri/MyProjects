package com.example.android.inventoryapp.DatabaeRelatedClasses;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.util.Log;

import com.example.android.inventoryapp.models.Product;
import com.example.android.inventoryapp.DatabaeRelatedClasses.DatabaseContract.ProductEntry;
import com.example.android.inventoryapp.Util;

import java.util.ArrayList;

import static com.example.android.inventoryapp.DatabaeRelatedClasses.DatabaseContract.ProductEntry.COLUMN_IMAGE;
import static com.example.android.inventoryapp.DatabaeRelatedClasses.DatabaseContract.ProductEntry.TABLE_NAME;

/**
 * Created by Omii026 on 3/23/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;
    public static DatabaseHelper ourInstance;

    // Database Name
    private static final String DATABASE_NAME = "InventroyApp.db";

    private static final String TEXT_TYPE = " TEXT";
    private static final String INT_TYPE = " INTEGER";
    private static final String REAL_TYPE = " REAL";
    private static final String BLOB_TYPE = " BLOB";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + ProductEntry.TABLE_NAME + " (" +
                    ProductEntry.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    ProductEntry.COLUMN_NAME + TEXT_TYPE + COMMA_SEP +
                    ProductEntry.COLUMN_QUANTITY + INT_TYPE + COMMA_SEP +
                    ProductEntry.COLUMN_PRICE + REAL_TYPE + COMMA_SEP +
                    ProductEntry.COLUMN_IMAGE + BLOB_TYPE +  COMMA_SEP +
                    ProductEntry.COLUMN_SUPP_EMAIL + TEXT_TYPE +
            " )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + ProductEntry.TABLE_NAME;

    public static DatabaseHelper getInstance (Context context){

        if (ourInstance == null)
            ourInstance = new DatabaseHelper(context);

        return ourInstance;
    }

    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        deleteDatabase(context);
    }

    private void deleteDatabase(Context context) {
        context.deleteDatabase(DATABASE_NAME);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d("testing", "in onCreate");
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        Log.d("testing", "in onUpgrade");
        sqLiteDatabase.execSQL("DROP TABLE IF EXIST " + ProductEntry.TABLE_NAME);
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }



//    add Product
    public void addProduct(Product product){

        if (product.getId() != 0)
            throw new RuntimeException("While adding you cant set primary key on your own");

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ProductEntry.COLUMN_NAME, product.getName());
        values.put(ProductEntry.COLUMN_QUANTITY, product.getQuantity());
        values.put(ProductEntry.COLUMN_PRICE, product.getPrice());
        values.put(ProductEntry.COLUMN_IMAGE, Util.getBytes(product.getImage()) );
        values.put(ProductEntry.COLUMN_SUPP_EMAIL, product.getSupplierEmail() );

        db.insert(ProductEntry.TABLE_NAME,ProductEntry.COLUMN_NAME,values);
        db.close();
    }

//    get specific Product
    public Product getProduct(int id){
    SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(ProductEntry.TABLE_NAME,
                new String[]{ProductEntry.COLUMN_NAME,ProductEntry.COLUMN_QUANTITY,ProductEntry.COLUMN_PRICE
                ,ProductEntry.COLUMN_IMAGE,ProductEntry.COLUMN_SUPP_EMAIL},
                ProductEntry.COLUMN_ID + "=?",new String[]{String.valueOf(id)},
                null,null,null,null
                );

        if(cursor != null)
            cursor.moveToFirst();

        Product product = new Product(
                id,
                cursor.getString(0),
                cursor.getInt(1),
                cursor.getDouble(2),
                Util.getImage(cursor.getBlob(3)),
                cursor.getString(4)
        );

        return product;
    }

//    get all Products
    public ArrayList<Product> getAllProducts(){

        ArrayList<Product> productList = new ArrayList<Product>();
        String selectQuery = "SELECT * FROM " + ProductEntry.TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);

        if(cursor.moveToFirst()){
            cursor.moveToPosition(1);
            do{
                Product product = new Product(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getInt(2),
                        cursor.getDouble(3),
                        Util.getImage(cursor.getBlob(4)),
                        cursor.getString(5)
                );
                productList.add(product);
            }while(cursor.moveToNext());

        }
        return productList;
    }

//    get Products count
    public int getProductsCount(){
        SQLiteDatabase db = this.getReadableDatabase();
        String countQuery = "SELECT * FROM "+ProductEntry.TABLE_NAME;
        Cursor cursor = db.rawQuery(countQuery,null);
        db.close();
        return cursor.getCount();
    }

//    update Product
    public int updateProduct(Product product){
        if (product.getId() <= 0)
            throw new RuntimeException("While updating Product ID can not be less than equal to zero");

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ProductEntry.COLUMN_ID,product.getId());
        values.put(ProductEntry.COLUMN_NAME, product.getName());
        values.put(ProductEntry.COLUMN_QUANTITY, product.getQuantity());
        values.put(ProductEntry.COLUMN_PRICE, product.getPrice());
        values.put(ProductEntry.COLUMN_IMAGE, Util.getBytes(product.getImage()) );
        values.put(ProductEntry.COLUMN_SUPP_EMAIL, product.getSupplierEmail());

        return  db.update(ProductEntry.TABLE_NAME,values,ProductEntry.COLUMN_ID + "=?", new String[] {String.valueOf(product.getId())});
    }



    //    delete Product
    public void deleteProduct(int productId){

        if (productId <= 0)
            throw new RuntimeException("While deleting Product ID can not be less than equal to zero");

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(ProductEntry.TABLE_NAME,ProductEntry.COLUMN_ID + "=?",new String[]{String.valueOf(productId)});
        db.close();
    }


    //    delete all Products
    public void deleteAllProducts(){

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(ProductEntry.TABLE_NAME,null,null);
        db.close();
    }




























}
