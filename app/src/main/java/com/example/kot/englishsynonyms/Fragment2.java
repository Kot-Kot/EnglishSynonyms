package com.example.kot.englishsynonyms;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
//import android.app.Fragment;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Kot Kot on 22.04.2017.
 */

public class Fragment2 extends Fragment implements View.OnClickListener {

    private TextView myTextViewForInfo3;

    private Button myButtonVariant1;
    private Button myButtonVariant2;
    private Button myButtonVariant3;
    private Button myButtonVariant4;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View myRootView = inflater.inflate(R.layout.fragment2, container, false);


        //width and height in px for specific display

        //Display myDisplay = getWindowManager().getDefaultDisplay();
       /* WindowManager myWM = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
         Display myDisplay = myWM.getDefaultDisplay();

         Point mySize = new Point();
         myDisplay.getSize(mySize);
        int myWidth = mySize.x;
        int myHeight = mySize.y;
        Log.d("MY_LOG", "myWidth = "+myWidth);
        Log.d("MY_LOG", "myHeight = "+myHeight); */


        myButtonVariant1 = (Button) myRootView.findViewById(R.id.buttonVariant1);
        //myButtonVariant1.setTextSize((float) (myButtonVariant1.getHeight()*0.5));
        //Log.d("MY_LOG", "myButtonVariant1.getHeight() = "+myButtonVariant1.getHeight());
        //myButtonVariant1.setTextSize((float)(myHeight*0.015));

        myButtonVariant2 = (Button) myRootView.findViewById(R.id.buttonVariant2);
       // myButtonVariant2.setTextSize((float)(myHeight*0.015));

        myButtonVariant3 = (Button) myRootView.findViewById(R.id.buttonVariant3);
      //  myButtonVariant3.setTextSize((float)(myHeight*0.015));

        myButtonVariant4 = (Button) myRootView.findViewById(R.id.buttonVariant4);
      //  myButtonVariant4.setTextSize((float)(myHeight*0.015));




        myTextViewForInfo3 = (TextView) myRootView.findViewById(R.id.textViewForInfo3);


      // myTextViewForInfo3.setText(String.valueOf(myWidth)+"  "+String.valueOf(myHeight)+"   "+
              // String.valueOf((float)(myHeight*0.02)));









        myButtonVariant1.setOnClickListener(this);
        myButtonVariant2.setOnClickListener(this);
        myButtonVariant3.setOnClickListener(this);
        myButtonVariant4.setOnClickListener(this);




        return myRootView;


    }

    @Override
    public void onResume() {
        super.onResume();



    }

    @Override
    public void onClick(View v) {
        int buttonIndex = translateIdToIndex(v.getId());

        OnSelectedButtonListener myListener = (OnSelectedButtonListener) getActivity();
        myListener.onButtonSelected(buttonIndex);

       // Toast.makeText(getActivity(), String.valueOf(buttonIndex), Toast.LENGTH_SHORT).show();

    }

    int translateIdToIndex(int id){
        int index = -1;
        switch (id){
            case R.id.buttonVariant1:
                index = R.id.buttonVariant1;
                break;
            case R.id.buttonVariant2:
                index = R.id.buttonVariant2;
                break;
            case R.id.buttonVariant3:
                index = R.id.buttonVariant3;
                break;
            case R.id.buttonVariant4:
                index = R.id.buttonVariant4;
                break;

        }
        return index;
    }

    public interface OnSelectedButtonListener{

        void onButtonSelected(int ButtonIndex);

    }
}
