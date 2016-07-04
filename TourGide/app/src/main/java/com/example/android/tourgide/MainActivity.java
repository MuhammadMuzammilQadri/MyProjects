package com.example.android.tourgide;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.android.tourgide.adapters.AttractiveLocationsPagerAdapter;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    Toolbar toolbar;
    TextView toolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeComponents();
        setUpComponents();

    }

    private void setUpComponents() {
        viewPager.setAdapter(new AttractiveLocationsPagerAdapter(getSupportFragmentManager()));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        changeToolbarTitle(toolbarTitle,"Restaurants");
                        break;
                    case 1:
                        changeToolbarTitle(toolbarTitle,"Public Places");
                        break;
                    case 2:
                        changeToolbarTitle(toolbarTitle,"Historical Places");
                        break;
                    case 3:
                        changeToolbarTitle(toolbarTitle,"Parks");
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void changeToolbarTitle(final TextView toolbarTitle, final String stringToChange) {
        final Animation in = new AlphaAnimation(0.0f, 1.0f);
        in.setDuration(250);

        final Animation out = new AlphaAnimation(1.0f, 0.0f);
        out.setDuration(250);

        out.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                toolbarTitle.setText(stringToChange);
                toolbarTitle.startAnimation(in);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        toolbarTitle.startAnimation(out);

    }

    private void setUpToolbar() {

        setSupportActionBar(toolbar);
    }

    private void initializeComponents() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbarTitle = (TextView) findViewById(R.id.toolbar_textview);
        setUpToolbar();
    }

}
