package com.example.muzamil.fragmentlifecycle;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.*;

import com.example.lifecyclelog.R;

@TargetApi(Build.VERSION_CODES.KITKAT)
public class TestFragment extends Fragment {

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Util.recLifeCycle(getClass(), Util.LifecycleState.CALL_TO_SUPER);
        super.onActivityCreated(savedInstanceState);
        Util.recLifeCycle(getClass(), Util.LifecycleState.RETURN_FROM_SUPER);
    }

    @Override
    public View
    onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Util.recLifeCycle(getClass(), Util.LifecycleState.CALL_TO_SUPER);
        View v = inflater.inflate(R.layout.fragment_test, container, false);
        Util.recLifeCycle(getClass(), Util.LifecycleState.RETURN_FROM_SUPER);
        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Util.recLifeCycle(getClass(), Util.LifecycleState.CALL_TO_SUPER);
        super.onViewCreated(view, savedInstanceState);
        Util.recLifeCycle(getClass(), Util.LifecycleState.RETURN_FROM_SUPER);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Util.recLifeCycle(getClass(), Util.LifecycleState.CALL_TO_SUPER);
        super.onActivityResult(requestCode, resultCode, data);
        Util.recLifeCycle(getClass(), Util.LifecycleState.RETURN_FROM_SUPER);

    }

    @Override
    public void onAttach(Activity activity) {
        Util.recLifeCycle(getClass(), Util.LifecycleState.CALL_TO_SUPER);
        super.onAttach(activity);
        Util.recLifeCycle(getClass(), Util.LifecycleState.RETURN_FROM_SUPER);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Util.recLifeCycle(getClass(), Util.LifecycleState.CALL_TO_SUPER);
        super.onConfigurationChanged(newConfig);
        Util.recLifeCycle(getClass(), Util.LifecycleState.RETURN_FROM_SUPER);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Util.recLifeCycle(getClass(), Util.LifecycleState.CALL_TO_SUPER);
        super.onCreate(savedInstanceState);
        Util.recLifeCycle(getClass(), Util.LifecycleState.RETURN_FROM_SUPER);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(final Menu menu, final MenuInflater inflater) {
        Util.recLifeCycle(getClass(), Util.LifecycleState.CALL_TO_SUPER);
        super.onCreateOptionsMenu(menu, inflater);
        Util.recLifeCycle(getClass(), Util.LifecycleState.RETURN_FROM_SUPER);
    }

    @Override
    public void onDestroy() {
        Util.recLifeCycle(getClass(), Util.LifecycleState.CALL_TO_SUPER);
        super.onDestroy();
        Util.recLifeCycle(getClass(), Util.LifecycleState.RETURN_FROM_SUPER);
    }

    @Override
    public void onDestroyOptionsMenu() {
        Util.recLifeCycle(getClass(), Util.LifecycleState.CALL_TO_SUPER);
        super.onDestroyOptionsMenu();
        Util.recLifeCycle(getClass(), Util.LifecycleState.RETURN_FROM_SUPER);
    }

    @Override
    public void onDestroyView() {
        Util.recLifeCycle(getClass(), Util.LifecycleState.CALL_TO_SUPER);
        super.onDestroyView();
        Util.recLifeCycle(getClass(), Util.LifecycleState.RETURN_FROM_SUPER);
    }

    @Override
    public void onDetach() {
        Util.recLifeCycle(getClass(), Util.LifecycleState.CALL_TO_SUPER);
        super.onDetach();
        Util.recLifeCycle(getClass(), Util.LifecycleState.RETURN_FROM_SUPER);
    }

    @Override
    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        Util.recLifeCycle(getClass(), Util.LifecycleState.CALL_TO_SUPER);
        super.onInflate(activity, attrs, savedInstanceState);
        Util.recLifeCycle(getClass(), Util.LifecycleState.RETURN_FROM_SUPER);
    }

    @Override
    public void onPause() {
        Util.recLifeCycle(getClass(), Util.LifecycleState.CALL_TO_SUPER);
        super.onPause();
        Util.recLifeCycle(getClass(), Util.LifecycleState.RETURN_FROM_SUPER);
    }

    @Override
    public void onPrepareOptionsMenu(final Menu menu) {
        Util.recLifeCycle(getClass(), Util.LifecycleState.CALL_TO_SUPER);
        super.onPrepareOptionsMenu(menu);
        Util.recLifeCycle(getClass(), Util.LifecycleState.RETURN_FROM_SUPER);
    }

    @Override
    public void onResume() {
        Util.recLifeCycle(getClass(), Util.LifecycleState.CALL_TO_SUPER);
        super.onResume();
        Util.recLifeCycle(getClass(), Util.LifecycleState.RETURN_FROM_SUPER);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        Util.recLifeCycle(getClass(), Util.LifecycleState.CALL_TO_SUPER);
        super.onSaveInstanceState(outState);
        Util.recLifeCycle(getClass(), Util.LifecycleState.RETURN_FROM_SUPER);
    }

    @Override
    public void onStart() {
        Util.recLifeCycle(getClass(), Util.LifecycleState.CALL_TO_SUPER);
        super.onStart();
        Util.recLifeCycle(getClass(), Util.LifecycleState.RETURN_FROM_SUPER);
    }

    @Override
    public void onStop() {
        Util.recLifeCycle(getClass(), Util.LifecycleState.CALL_TO_SUPER);
        super.onStop();

        Util.recLifeCycle(getClass(), Util.LifecycleState.RETURN_FROM_SUPER);
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        Util.recLifeCycle(getClass(), Util.LifecycleState.CALL_TO_SUPER);
        super.onViewStateRestored(savedInstanceState);
        Util.recLifeCycle(getClass(), Util.LifecycleState.RETURN_FROM_SUPER);
    }
}
