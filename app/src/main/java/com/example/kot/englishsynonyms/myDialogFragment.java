package com.example.kot.englishsynonyms;

//import android.app.DialogFragment;

//import android.support.v7.app.AlertDialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Kot Kot on 28.04.2017.
 */

public class myDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
       // return super.onCreateDialog(savedInstanceState);
        final AlertDialog.Builder myADB = new AlertDialog.Builder(getActivity());
        myADB.setTitle("Informational message.")
                .setMessage("Sorry, you've watched all the groups. " +
                        "All the counters will be reset, but You will be able to start app from scratch.")
                .setIcon(R.drawable.ic_priority_high_black_24dp)
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ((GameActivity) getActivity()).okClickedDialog();


                       /* GameActivity myGA = new GameActivity();
                        myGA.myFinishedGroupCounter = 0;
                        myGA.myTotalScore = 0;
                        myGA.myFinishedGroupCounter = 0;
                        myGA.myIterationCounter = 0;
                        myGA.myCurrentGroup = "";

                        Intent myIntent = new Intent(getContext(),MainActivity.class);
                        startActivity(myIntent);  */




                        dialog.cancel();

                    }
                });

        return myADB.create();






    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
