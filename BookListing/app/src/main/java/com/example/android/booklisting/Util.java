package com.example.android.booklisting;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by Muhammad Muzammil on 7/4/2016.
 */

public class Util {
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
