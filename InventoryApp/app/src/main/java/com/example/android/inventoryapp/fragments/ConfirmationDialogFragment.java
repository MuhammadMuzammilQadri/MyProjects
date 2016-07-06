package com.example.android.inventoryapp.fragments;


/**
 * Created by Muhammad Muzammil on 20/01/16.
 */

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.example.android.inventoryapp.R;

/**
 * A custom DialogFragment that is positioned above given "source" component.
 */

public class ConfirmationDialogFragment extends DialogFragment {

    View view;
    private Button successButton;
    private Button discardButton;
    private boolean isConfirmed;
    private onDismissConfirmationDialogListener mODismissConfirmationDialogListener;

    public ConfirmationDialogFragment() {
    }

    public static ConfirmationDialogFragment newInstance() {
        ConfirmationDialogFragment customListDialogFragment = new ConfirmationDialogFragment();
        customListDialogFragment.setCancelable(false);
        return customListDialogFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_confirmation, null);
        AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).setView(view).create();
        return alertDialog;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Put your dialog layout in R.layout.dialog_more

        initializeComponents(view);
        setUpListeners();

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void setUpListeners() {


        successButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isConfirmed = true;
                dismiss();
            }
        });

        discardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isConfirmed = false;
                dismiss();
            }
        });

    }

    private void initializeComponents(View view) {
        successButton = (Button) view.findViewById(R.id.success_button);
        discardButton = (Button) view.findViewById(R.id.cancel_button);

    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        if (isConfirmed)
            mODismissConfirmationDialogListener.onSuccessConfirmationDialog();

    }

    public void setOnDismissDialogListener(onDismissConfirmationDialogListener onDismissConfirmationDialogListener) {
        mODismissConfirmationDialogListener = onDismissConfirmationDialogListener;
    }

    public interface onDismissConfirmationDialogListener {
        void onSuccessConfirmationDialog();
    }
}
