package com.example.android.inventoryapp.models;

import android.graphics.Bitmap;

import com.example.android.inventoryapp.DatabaeRelatedClasses.DatabaseHelper;
import com.example.android.inventoryapp.InventoryApp;

/**
 * Created by Muhammad Muzammil on 7/6/2016.
 */

public class Product {
    private int id;
    private String name;
    private int quantity;
    private double price;
    private Bitmap image;
    private String supplierEmail;


    public Product(String name, int quantity, double price, Bitmap image, String supplierEmail) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.image = image;
        this.supplierEmail = supplierEmail;
    }


    public Product(int id, String name, int quantity, double price, Bitmap image, String supplierEmail) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.image = image;
        this.supplierEmail = supplierEmail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public void updateIncementQuantity(){
        quantity++;
        updateQuantityInSql();
    }

    public void updateDecementQuantity(){
        quantity--;
        updateQuantityInSql();
    }

    private void updateQuantityInSql() {
        DatabaseHelper databaseHelper = DatabaseHelper.getInstance(InventoryApp.getContext());
        databaseHelper.updateProduct(this);
    }


    public void deleteProduct(){
        deleteProductInSql();
    }

    private void deleteProductInSql() {
        DatabaseHelper databaseHelper = DatabaseHelper.getInstance(InventoryApp.getContext());
        databaseHelper.deleteProduct(this.getId());
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public void setSupplierEmail(String supplierEmail) {
        this.supplierEmail = supplierEmail;
    }
}
