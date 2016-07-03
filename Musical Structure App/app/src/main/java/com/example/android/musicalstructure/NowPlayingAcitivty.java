package com.example.android.musicalstructure;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class NowPlayingAcitivty extends AppCompatActivity {
    Drawable drawable;
    String songName;
    String artistName;

    ImageView imageView;
    TextView songNameTextView;
    TextView artistNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing_acitivty);

        DataHandler dataHandler = DataHandler.getInstance();
        drawable = dataHandler.getDrawable();
        songName = dataHandler.getSongName();
        artistName = dataHandler.getArtistName();

        imageView = (ImageView) findViewById(R.id.customImageView);
        songNameTextView = (TextView) findViewById(R.id.tv_song_name);
        artistNameTextView = (TextView) findViewById(R.id.tv_artist_name);

        populateViews();



    }

    private void populateViews() {
        imageView.setImageDrawable(drawable);
        songNameTextView.setText(songName);
        artistNameTextView.setText(artistName);
    }

}
