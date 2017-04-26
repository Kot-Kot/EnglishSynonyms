package com.example.kot.englishsynonyms;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

/**
 * Created by Kot Kot on 22.04.2017.
 */

public class Fragment1 extends Fragment {
    private TextView myTextViewForInfo1;
    private TextView myTextViewForInfo2;
    private TextView myTextViewForSynonym1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
       // return super.onCreateView(inflater, container, savedInstanceState);
        View myRootView = inflater.inflate(R.layout.fragment1, container, false);

        WindowManager myWM = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        Display myDisplay = myWM.getDefaultDisplay();

        Point mySize = new Point();
        myDisplay.getSize(mySize);
        int myWidth = mySize.x;
        int myHeight = mySize.y;


        myTextViewForInfo1 = (TextView) myRootView.findViewById(R.id.textViewForInfo1);
        myTextViewForInfo2 = (TextView) myRootView.findViewById(R.id.textViewForInfo2);
        myTextViewForSynonym1 = (TextView) myRootView.findViewById(R.id.textViewForSynonym1);

        myTextViewForSynonym1.setTextSize((float)(myHeight*0.02));





        return myRootView;


    }

    public void setText (int buttonIndex){
        switch (buttonIndex){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                break;

        }
    }

}
