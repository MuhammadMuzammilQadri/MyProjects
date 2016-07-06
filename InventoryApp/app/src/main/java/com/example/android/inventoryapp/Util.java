package com.example.android.inventoryapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Muhammad Muzammil on 7/6/2016.
 */

public class Util {
    public static String savePictureInFileStorage(Context context, long id, Bitmap picture) {
        // Saves the new picture to the internal storage with the unique identifier of the product as
        // the name. That way, there will never be two product pictures with the same name.
        String picturePath = "";
        File internalStorage = context.getDir("InventoryPictures", Context.MODE_PRIVATE);
        File productFilePath = new File(internalStorage, id + ".jpg");
        picturePath = productFilePath.toString();

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(productFilePath);
            picture.compress(Bitmap.CompressFormat.JPEG, 100 /*quality*/, fos);
            fos.close();
        } catch (Exception ex) {
            Log.i("DATABASE", "Problem updating picture", ex);
            picturePath = "";
        }
        return picturePath;
    }

    public static Bitmap getPictureFromFileStorage(String picturePath) {
        if (picturePath == null || picturePath.length() == 0)
            return (null);

        return BitmapFactory.decodeFile(picturePath);
    }



    // validating email id
    public static boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    static ProgressDialog progress;

    public static void showProgressDialog(Context context) {
        progress = ProgressDialog.show(context, "dialog title",
                "dialog message", true);
    }

    public static void dismissProgressDialog() {
        if (progress != null) {
            progress.dismiss();
        }
    }

}
