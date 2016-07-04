package com.example.android.tourgide.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.android.tourgide.fragments.HistoricalPlacesFragment;
import com.example.android.tourgide.fragments.ParksLocationFragment;
import com.example.android.tourgide.fragments.PublicPlacesFragment;
import com.example.android.tourgide.fragments.RestaurantLocationsFragment;


/**
 * Created by Muhammad Muzammil
 */
    public class AttractiveLocationsPagerAdapter extends FragmentStatePagerAdapter {


    public AttractiveLocationsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 0:
                return new RestaurantLocationsFragment();
            case 1:
                return new PublicPlacesFragment();
            case 2:
                return new HistoricalPlacesFragment();
            case 3:
                return new ParksLocationFragment();
            default:
                return null;
        }
    }



    @Override
    public int getCount() {
        return 4;
    }


}
