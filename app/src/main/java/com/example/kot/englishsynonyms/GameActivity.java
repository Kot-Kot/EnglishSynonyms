package com.example.kot.englishsynonyms;

import android.content.Intent;
import android.graphics.Point;
import android.icu.text.DecimalFormat;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatDialogFragment;
//import android.app.FragmentManager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v4.app.ActivityCompat;

public class GameActivity extends AppCompatActivity implements Fragment2.OnSelectedButtonListener {


    int myCurrentGroup;
    int myOverallQuantity;

    TextView myTextViewForStatus;
    TextView myTextViewForSynonym1;
    Button myButtonVariant1;
    Button myButtonVariant2;
    Button myButtonVariant3;
    Button myButtonVariant4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //width and height in px for specific display
        Display myDisplay = getWindowManager().getDefaultDisplay();
        Point mySize = new Point();
        myDisplay.getSize(mySize);
        int myWidth = mySize.x;
        int myHeight = mySize.y;
        Log.d("MY_LOG", "myWidth = "+myWidth);
        Log.d("MY_LOG", "myHeight = "+myHeight);

        myButtonVariant1 = (Button) findViewById(R.id.buttonVariant1);
        myButtonVariant1.setTextSize((float)(myHeight*0.02));

        myButtonVariant2 = (Button) findViewById(R.id.buttonVariant2);
        myButtonVariant2.setTextSize((float)(myHeight*0.02));

        myButtonVariant3 = (Button) findViewById(R.id.buttonVariant3);
        myButtonVariant3.setTextSize((float)(myHeight*0.02));

        myButtonVariant4 = (Button) findViewById(R.id.buttonVariant4);
        myButtonVariant4.setTextSize((float)(myHeight*0.02));

        myTextViewForSynonym1 = (TextView)findViewById(R.id.textViewForSynonym1);
        myTextViewForSynonym1.setTextSize((float)(myHeight*0.02));


        myTextViewForStatus = (TextView) findViewById(R.id.textViewForStatus);


        myTextViewForStatus.setText(String.valueOf(myWidth)+"  "+String.valueOf(myHeight)+"   "+
                String.valueOf((float)(myHeight*0.02)));

        Log.d("MY_LOG", "(float)(myHeight*0.02) = "+(float)(myHeight*0.02));

        myTextViewForSynonym1 = (TextView)findViewById(R.id.textViewForSynonym1);




        myOverallQuantity = Integer.valueOf(getResources().getString(R.string.synonyms_group_count));

        myCurrentGroup = (int)(Math.random()*myOverallQuantity);
        String myStringArrayName = "n"+String.valueOf(myCurrentGroup);
        Integer myStringArrayID = getResources().getIdentifier("n" + myCurrentGroup,"array", getPackageName());
        String[] myStringArray = getResources().getStringArray(myStringArrayID);

        myOneStageOfTheGame(myStringArray);

        //myTextViewForSynonym1.setText(myStringArray[0]);


    }

    public void myOneStageOfTheGame(String[] wholeArray){
        int myCurrentWordNumber;
        String myCurrentWord;

        Log.d("MY_LOG", "wholeArray[0] = "+wholeArray[0]);
        String[] myEnglishWordsArray = wholeArray[0].split(", ");

        myCurrentWordNumber = (int)(Math.random()*myEnglishWordsArray.length);
        Log.d("MY_LOG", "myCurrentWordNumber = "+myCurrentWordNumber);

        Integer[] myArrayForCheking = new Integer[myEnglishWordsArray.length-1];

        myCurrentWord = myEnglishWordsArray[myCurrentWordNumber];
        myTextViewForSynonym1.setText(myCurrentWord);


    }

    @Override
    public void onButtonSelected(int ButtonIndex) {
        FragmentManager myFragmentManager = getSupportFragmentManager();
        Fragment1 myFragment1 = (Fragment1) myFragmentManager.findFragmentById(R.id.fragment1);

        if(myFragment1!=null) myFragment1.

    }
}














                // myTestTV.setText(String.valueOf(myCurrentGroup));
                // Intent myIntent = new Intent(getApplicationContext(), GameActivity.class);
                // startActivity(myIntent);

