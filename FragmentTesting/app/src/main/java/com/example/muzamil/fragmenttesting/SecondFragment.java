package com.example.muzamil.fragmenttesting;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {


    private static final String TAG = SecondFragment.class.getSimpleName();
    private View rootView;


    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_second, container, false);
        return rootView;    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "in onCreate");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "in onResume");

        rootView.findViewById(R.id.second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getActivity().getSupportFragmentManager().popBackStack();

            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "in onStart");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "in onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "in onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "in onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "in onDestroy");
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "in onAttach");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "in onDetach");
    }
}
