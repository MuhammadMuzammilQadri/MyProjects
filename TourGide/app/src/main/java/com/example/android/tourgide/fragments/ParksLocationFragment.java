package com.example.android.tourgide.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.etsy.android.grid.StaggeredGridView;
import com.example.android.tourgide.R;
import com.example.android.tourgide.adapters.ParkGridViewAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ParksLocationFragment extends Fragment {

    StaggeredGridView gridView;
    private View rootView;

    public ParksLocationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_parks_location, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initializeComponents();
    }

    private void initializeComponents() {
        gridView = (StaggeredGridView) rootView.findViewById(R.id.park_gridview);
        gridView.setAdapter(new ParkGridViewAdapter(getActivity()));

    }


}
