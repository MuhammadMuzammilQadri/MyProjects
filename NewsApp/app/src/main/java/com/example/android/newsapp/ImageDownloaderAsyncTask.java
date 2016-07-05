package com.example.android.newsapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.android.newsapp.model.Results;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Muhammad Muzammil on 7/5/2016.
 */

class ImageDownloaderAsyncTask extends AsyncTask<String, Void, Bitmap> {
    private final WeakReference<ImageView> imageViewReference;
    private final BaseAdapter baseAdapter;
    private Results results;

    public ImageDownloaderAsyncTask(ImageView imageView, Results results, BaseAdapter baseAdapter) {
        imageViewReference = new WeakReference<ImageView>(imageView);
        this.results = results;
        this.baseAdapter = baseAdapter;
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        return downloadBitmap(params[0]);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        if (imageViewReference != null) {
            ImageView imageView = imageViewReference.get();
            if (imageView != null) {
                if (bitmap != null) {
//                        imageView.setImageBitmap(bitmap);
                    if (this.results.getImage() == null) {
                        this.results.setImage(bitmap);
                        baseAdapter.notifyDataSetChanged();
                    }
                } else {
                    Drawable placeholder = imageView.getContext().getResources().getDrawable(android.R.drawable.ic_delete);
                    imageView.setImageDrawable(placeholder);
                }
            }
        }
    }


    private Bitmap downloadBitmap(String url) {
        BufferedInputStream bis = null;
        HttpURLConnection urlConnection = null;
        try {
            URL uri = new URL(url);
            urlConnection = (HttpURLConnection) uri.openConnection();
            urlConnection.setInstanceFollowRedirects(false);

            //For handling HTTPS urls
            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_MOVED_PERM || urlConnection.getResponseCode() == HttpURLConnection.HTTP_MOVED_TEMP) {
                Log.d("responsechecking", "Redirecting.. " + urlConnection.getResponseCode());
                urlConnection.disconnect();
                url = getFinalRedirectedUrl(url);
                uri = new URL(url);
                urlConnection = (HttpURLConnection) uri.openConnection();
            }
            InputStream inputStream = urlConnection.getInputStream();
            bis = new BufferedInputStream(inputStream, 8192);
            Log.d("responsechecking", "" + urlConnection.getResponseCode());

            if (inputStream != null && bis != null) {
                Bitmap bitmap = BitmapFactory.decodeStream(bis);
                return bitmap;
            }
        } catch (Exception e) {
            Log.w("ImageDownloader", "Error downloading image from " + url);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (bis != null)
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return null;
    }

    public String getFinalRedirectedUrl(String url) {

        HttpURLConnection connection;
        String finalUrl = url;
        try {
            do {
                connection = (HttpURLConnection) new URL(finalUrl)
                        .openConnection();
                connection.setInstanceFollowRedirects(false);
                connection.setUseCaches(false);
                connection.setRequestMethod("GET");
                connection.connect();
                int responseCode = connection.getResponseCode();
                if (responseCode >= 300 && responseCode < 400) {
                    String redirectedUrl = connection.getHeaderField("Location");
                    if (null == redirectedUrl)
                        break;
                    finalUrl = redirectedUrl;
                    System.out.println("redirected url: " + finalUrl);
                } else
                    break;
            } while (connection.getResponseCode() != HttpURLConnection.HTTP_OK);
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return finalUrl;
    }

}
