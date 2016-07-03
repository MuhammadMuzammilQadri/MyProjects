package com.example.android.musicalstructure;

import android.graphics.drawable.Drawable;

/**
 * Created by Muhammad Muzammil on 7/3/2016.
 */

public class DataHandler {
    private static DataHandler dataHandler;
    private Drawable drawable;
    private String songName;
    private String artistName;

    public static DataHandler getInstance(){
        if (dataHandler == null)
            dataHandler = new DataHandler();
        return dataHandler;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

}
