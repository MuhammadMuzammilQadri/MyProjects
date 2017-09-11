package com.example.muzamil.fragmentlifecycle;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.LoaderManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;

import com.example.lifecyclelog.R;

/**
 * A standard Android Activity.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Util.recLifeCycle(getClass(), Util.LifecycleState.CALL_TO_SUPER);
        super.onCreate(savedInstanceState);
        Util.recLifeCycle(getClass(), Util.LifecycleState.RETURN_FROM_SUPER);
        setContentView(R.layout.activity_main);

        FragmentManager.enableDebugLogging(true);
        LoaderManager.enableDebugLogging(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Util.recLifeCycle(getClass(), Util.LifecycleState.CALL_TO_SUPER);
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        Util.recLifeCycle(getClass(), Util.LifecycleState.RETURN_FROM_SUPER);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Util.recLifeCycle(getClass(), Util.LifecycleState.CALL_TO_SUPER);
        super.onActivityResult(requestCode, resultCode, data);
        Util.recLifeCycle(getClass(), Util.LifecycleState.RETURN_FROM_SUPER);
    }

    @Override
    public void onAttachedToWindow() {
        Util.recLifeCycle(getClass(), Util.LifecycleState.CALL_TO_SUPER);
        super.onAttachedToWindow();
        Util.recLifeCycle(getClass(), Util.LifecycleState.RETURN_FROM_SUPER);
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        Util.recLifeCycle(getClass(), Util.LifecycleState.CALL_TO_SUPER);
        super.onAttachFragment(fragment);
        Util.recLifeCycle(getClass(), Util.LifecycleState.RETURN_FROM_SUPER);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Util.recLifeCycle(getClass(), Util.LifecycleState.CALL_TO_SUPER);
        super.onConfigurationChanged(newConfig);
        Util.recLifeCycle(getClass(), Util.LifecycleState.RETURN_FROM_SUPER);
    }

    @Override
    public void onContentChanged() {
        Util.recLifeCycle(getClass(), Util.LifecycleState.CALL_TO_SUPER);
        super.onContentChanged();
        Util.recLifeCycle(getClass(), Util.LifecycleState.RETURN_FROM_SUPER);
    }

    @Override
    protected void onDestroy() {
        Util.recLifeCycle(getClass(), Util.LifecycleState.CALL_TO_SUPER);
        super.onDestroy();
        Util.recLifeCycle(getClass(), Util.LifecycleState.RETURN_FROM_SUPER);
    }

    @Override
    public void onDetachedFromWindow() {
        Util.recLifeCycle(getClass(), Util.LifecycleState.CALL_TO_SUPER);
        super.onDetachedFromWindow();
        Util.recLifeCycle(getClass(), Util.LifecycleState.RETURN_FROM_SUPER);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        Util.recLifeCycle(getClass(), Util.LifecycleState.CALL_TO_SUPER);
        super.onNewIntent(intent);
        Util.recLifeCycle(getClass(), Util.LifecycleState.RETURN_FROM_SUPER);
    }

    @Override
    protected void onPause() {
        Util.recLifeCycle(getClass(), Util.LifecycleState.CALL_TO_SUPER);
        super.onPause();
        Util.recLifeCycle(getClass(), Util.LifecycleState.RETURN_FROM_SUPER);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        Util.recLifeCycle(getClass(), Util.LifecycleState.CALL_TO_SUPER);
        super.onPostCreate(savedInstanceState);
        Util.recLifeCycle(getClass(), Util.LifecycleState.RETURN_FROM_SUPER);

    }

    @Override
    protected void onPostResume() {
        Util.recLifeCycle(getClass(), Util.LifecycleState.CALL_TO_SUPER);
        super.onPostResume();
        Util.recLifeCycle(getClass(), Util.LifecycleState.RETURN_FROM_SUPER);
    }

    @Override
    public boolean onPrepareOptionsMenu(final Menu menu) {
        Util.recLifeCycle(getClass(), Util.LifecycleState.CALL_TO_SUPER);
        boolean result = super.onPrepareOptionsMenu(menu);
        Util.recLifeCycle(getClass(), Util.LifecycleState.RETURN_FROM_SUPER);

        return result;
    }

    @Override
    protected void onRestart() {
        Util.recLifeCycle(getClass(), Util.LifecycleState.CALL_TO_SUPER);
        super.onRestart();
        Util.recLifeCycle(getClass(), Util.LifecycleState.RETURN_FROM_SUPER);
    }

    @Override
    protected void onResume() {
        Util.recLifeCycle(getClass(), Util.LifecycleState.CALL_TO_SUPER);
        super.onResume();
        Util.recLifeCycle(getClass(), Util.LifecycleState.RETURN_FROM_SUPER);
    }

    @Override
    protected void onRestoreInstanceState(final Bundle savedInstanceState) {
        Util.recLifeCycle(getClass(), Util.LifecycleState.CALL_TO_SUPER);
        super.onRestoreInstanceState(savedInstanceState);
        Util.recLifeCycle(getClass(), Util.LifecycleState.RETURN_FROM_SUPER);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        Util.recLifeCycle(getClass(), Util.LifecycleState.CALL_TO_SUPER);
        super.onWindowFocusChanged(hasFocus);
        Util.recLifeCycle(getClass(), Util.LifecycleState.RETURN_FROM_SUPER);
    }

    @Override
    protected void onUserLeaveHint() {
        Util.recLifeCycle(getClass(), Util.LifecycleState.CALL_TO_SUPER);
        super.onUserLeaveHint();
        Util.recLifeCycle(getClass(), Util.LifecycleState.RETURN_FROM_SUPER);
    }

    @Override
    protected void onStart() {
        Util.recLifeCycle(getClass(), Util.LifecycleState.CALL_TO_SUPER);
        super.onStart();
        Util.recLifeCycle(getClass(), Util.LifecycleState.RETURN_FROM_SUPER);

    }

    @Override
    protected void onStop() {
        Util.recLifeCycle(getClass(), Util.LifecycleState.CALL_TO_SUPER);
        super.onStop();
        Util.recLifeCycle(getClass(), Util.LifecycleState.RETURN_FROM_SUPER);
    }

    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        Util.recLifeCycle(getClass(), Util.LifecycleState.CALL_TO_SUPER);
        super.onSaveInstanceState(outState);
        Util.recLifeCycle(getClass(), Util.LifecycleState.RETURN_FROM_SUPER);
    }

    @Override
    public void onUserInteraction() {
        Util.recLifeCycle(getClass(), Util.LifecycleState.CALL_TO_SUPER);
        super.onUserInteraction();
        Util.recLifeCycle(getClass(), Util.LifecycleState.RETURN_FROM_SUPER);
    }
}
