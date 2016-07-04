package com.example.android.tourgide.Model;

import android.content.Context;

import com.example.android.tourgide.R;

import java.util.ArrayList;

/**
 * Created by panacloud on 04/07/16.
 */
public class DataHandler {
    private static DataHandler singleton;
    private ArrayList<Restaurant> restaurants = new ArrayList<>();
    private ArrayList<PublicPlace> publicPlaces = new ArrayList<>();
    private ArrayList<Park> parks = new ArrayList<>();
    private ArrayList<HistoricalPlace> historicalPlaces = new ArrayList<>();
    private Context context;


    public static DataHandler getInstance(Context context){
        if (singleton == null) {
            singleton = new DataHandler(context);
        }
        return singleton;
    }

    private DataHandler(Context context){
        this.context = context;
        populateFields();
    }

    private void populateFields() {
        populateRestaurants();
        populatePublicPlaces();
        populateParks();
        populateHitoricalPlaces();
    }

    private void populateHitoricalPlaces() {
        historicalPlaces.add(new HistoricalPlace(context.getResources().getDrawable(R.drawable.earlyislamiccemetry),"Early Islami Cemetry","Landhi, Karachi",400));
        historicalPlaces.add(new HistoricalPlace(context.getResources().getDrawable(R.drawable.mizarequaid),"Mizar e Quaid","M. A. Jinnah Rd, Karachi",70));
        historicalPlaces.add(new HistoricalPlace(context.getResources().getDrawable(R.drawable.empressmarketkarachi),"Empress Market","Saddar, Karachi",125));

    }

    private void populateParks() {
        parks.add(new Park(context.getResources().getDrawable(R.drawable.azizbhatti),"Aziz Bhatti park","University Rd, Karachi"));
        parks.add(new Park(context.getResources().getDrawable(R.drawable.bagheqasim),"Bagh e Qasim","Block 3, Karachi"));
        parks.add(new Park(context.getResources().getDrawable(R.drawable.botanicalgarden),"Botanical Garden","University Botanical Garden, Karachi"));

    }

    private void populatePublicPlaces() {
        publicPlaces.add(new PublicPlace(context.getResources().getDrawable(R.drawable.clifton),"Clifton Beach","DHA, Karachi"));
        publicPlaces.add(new PublicPlace(context.getResources().getDrawable(R.drawable.pafmeuseum),"PAF Museum","PAF Faisal Air Base, Shahra e faisal, Karachi"));
        publicPlaces.add(new PublicPlace(context.getResources().getDrawable(R.drawable.paradisepoint),"Paradise Point","Kiamari, Karachi"));
        publicPlaces.add(new PublicPlace(context.getResources().getDrawable(R.drawable.seaview),"Sea view","Clifton, Karachi"));
    }

    private void populateRestaurants() {
        restaurants.add(new Restaurant(context.getResources().getDrawable(R.drawable.kolachi),"Kolachi","Sea View Rd, Karachi",5.0));
        restaurants.add(new Restaurant(context.getResources().getDrawable(R.drawable.bbqtonight),"BBQ Tonight","Boating Basin, Clifton, Karachi",4));
        restaurants.add(new Restaurant(context.getResources().getDrawable(R.drawable.cafeaylanto),"Cafe Aylanto","Block 4، Clifton، Karachi",3));
        restaurants.add(new Restaurant(context.getResources().getDrawable(R.drawable.sakura),"Sakura","Saddar, Karachi",4.5));
    }


    public ArrayList<Restaurant> getRestaurants() {
        return restaurants;
    }

    public ArrayList<PublicPlace> getPublicPlaces() {
        return publicPlaces;
    }

    public ArrayList<Park> getParks() {
        return parks;
    }

    public ArrayList<HistoricalPlace> getHistoricalPlaces() {
        return historicalPlaces;
    }

}
