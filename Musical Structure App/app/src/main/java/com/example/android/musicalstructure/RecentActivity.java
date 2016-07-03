package com.example.android.musicalstructure;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class RecentActivity extends AppCompatActivity {

    RelativeLayout songContainer1;
    RelativeLayout songContainer2;
    Drawable drawable;
    String songName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recent);
        songContainer1 = (RelativeLayout) findViewById(R.id.song_conatiner1);
        songContainer2 = (RelativeLayout) findViewById(R.id.song_conatiner2);

        songContainer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNowPlayingActivity(v, "Michael Jackson");
            }
        });


        songContainer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNowPlayingActivity(v, "Taylor Swift");
            }
        });

    }

    private void startNowPlayingActivity(View v, String artistName) {
        drawable = ((ImageView) ((ViewGroup) v).getChildAt(0)).getDrawable();
        songName = ((TextView) ((ViewGroup) v).getChildAt(1)).getText().toString();

        DataHandler dataHandler= DataHandler.getInstance();
        dataHandler.setDrawable(drawable);
        dataHandler.setSongName(songName);
        dataHandler.setArtistName(artistName);

        Intent intent = new Intent(RecentActivity.this, NowPlayingAcitivty.class);
        startActivity(intent);


    }
}
