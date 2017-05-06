package com.example.kot.englishsynonyms;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.zip.Inflater;

/**
 * Created by Kot Kot on 22.04.2017.
 */

public class Fragment1 extends Fragment {
    private TextView myTextViewForInfo1;
    private TextView myTextViewForInfo2;
    private TextView myTextViewForSynonym1;
    private View myRootView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
       // return super.onCreateView(inflater, container, savedInstanceState);
        myRootView = inflater.inflate(R.layout.fragment1, container, false);



        return myRootView;


    }



}
