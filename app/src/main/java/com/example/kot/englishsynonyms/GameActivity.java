package com.example.kot.englishsynonyms;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentManager;
//import android.app.FragmentManager;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;

public class GameActivity extends AppCompatActivity implements Fragment2.OnSelectedButtonListener {

    //public final Integer myOverallQuantity = Integer.valueOf(getResources().getString(R.string.synonyms_group_count));
    public final static String WORD = "com.example.kot.englishsynonyms.WORD";
    public final static String TRANSLATION = "com.example.kot.englishsynonyms.TRANSLATION";




    public final String APP_VARIABLES_AND_COUNTERS = "app_variables_and_counters";


    public static final String KEY_isQuitDialogOnTop = "isQuitDialogOnTop";

    public static final String KEY_isButtonClicked = "isButtonClicked";
    public static final String KEY_myPushedButtonIndex = "myPushedButtonIndex";
    public static final String KEY_myPushedButtonColor = "myPushedButtonColor";
    public static final String KEY_myTotalScore = "myTotalScore";
    public static final String KEY_myFinishedGroupCounter = "myFinishedGroupCounter";
    public static final String KEY_myIterationCounter = "myIterationCounter";
    public static final String KEY_myCurrentGroupNumber = "myCurrentGroupNumber";
    public static final String KEY_myOverallQuantity = "myOverallQuantity";
    public static final String KEY_myRandomPositionsForAllGroups = "myRandomPositionsForAllGroups";
    public static final String KEY_myFirstWordInGroup = "myFirstWordInGroup";
    public static final String KEY_myCurrentWordInGroup = "myCurrentWordInGroup";
    public static final String KEY_myRandomPositionsForWordsInGroup = "myRandomPositionsForWordsInGroup";
    public static final String KEY_myCurrentGroup = "myCurrentGroup";
    public static final String KEY_myTotalScoreBeforeNewGroup = "myTotalScoreBeforeNewGroup";
    public static final String KEY_myCounterForSharedPreferences = "myCounterForSharedPreferences";

    public static final String KEY_myButton1InFragment2 = "myButton1InFragment2";
    public static final String KEY_myButton2InFragment2 = "myButton2InFragment2";
    public static final String KEY_myButton3InFragment2 = "myButton3InFragment2";
    public static final String KEY_myButton4InFragment2 = "myButton4InFragment2";

    public static final String KEY_myButtonsIsClickable = "myButtonsIsClickable";

    public static final String KEY_myTV1InFragment1 = "myTV1InFragment1";
    public static final String KEY_myTV2InFragment1 = "myTV2InFragment1";
    public static final String KEY_myTV3InFragment1 = "myTV3InFragment1";
    public static final String KEY_myTV4InFragment1 = "myTV4InFragment1";
    public static final String KEY_myTV5InFragment1 = "myTV5InFragment1";
    public static final String KEY_myTV6InFragment1 = "myTV6InFragment1";

    public static final String KEY_myTV2InFragment1Color = "myTV2InFragment1Color";
    public static final String KEY_myTV3InFragment1Color = "myTV3InFragment1Color";
    public static final String KEY_myTV4InFragment1Color = "myTV4InFragment1Color";
    public static final String KEY_myTV5InFragment1Color = "myTV5InFragment1Color";
    public static final String KEY_myTV6InFragment1Color = "myTV6InFragment1Color";

    public static final String KEY_myTV2InFragment1IsEnabled = "myTV2InFragment2IsEnabled";
    public static final String KEY_myTV3InFragment1IsEnabled = "myTV2InFragment3IsEnabled";
    public static final String KEY_myTV4InFragment1IsEnabled = "myTV2InFragment4IsEnabled";
    public static final String KEY_myTV5InFragment1IsEnabled = "myTV2InFragment5IsEnabled";
    public static final String KEY_myTV6InFragment1IsEnabled = "myTV2InFragment6IsEnabled";

    public static final String KEY_myTVInfo1InFragment1 = "myTVInfo1InFragment1";
    public static final String KEY_myTVInfo2InFragment1 = "myTVInfo2InFragment1";
    public static final String KEY_myTVInfo3InFragment2 = "myTVInfo3InFragment2";
    public static final String KEY_myTVInfo3InFragment2IsSelected = "myTVInfo3InFragment2IsSelected";

    //public static final String KEY_myTVHeight = "myTVHeight";

    public static final String KEY_myBundle = "myBundle";
    //final int action_translation = 1;

    SharedPreferences mySharedPreferences;


    Boolean isQuitDialogOnTop = false;
    Boolean isButtonClicked = false;
    //int myCounterForSharedPreferences = 0;
    int myTotalScoreBeforeNewGroup = 0;
    int myNumberOfSelectedTV = -1;
    int myPushedButtonIndex = 0;
    int myTotalScore = 0;
    int myFinishedGroupCounter = 0;
    int myIterationCounter = 0;
    int myCurrentGroupNumber;
    int myOverallQuantity;

    //int myTVHeight;

    String myRandomPositionsForAllGroups;
    String myFirstWordInGroup;
    String myCurrentWordInGroup;
    String myRandomPositionsForWordsInGroup;
    String myCurrentGroup;


    FragmentManager myFragmentManager;
    Fragment1 myFragment1;
    Fragment2 myFragment2;

    TextView myTV1InFragment1;
    TextView myTV2InFragment1;
    TextView myTV3InFragment1;
    TextView myTV4InFragment1;
    TextView myTV5InFragment1;
    TextView myTV6InFragment1;

    TextView myTVInfo1InFragment1;
    TextView myTVInfo2InFragment1;
    TextView myTVInfo3InFragment2;

    Button myButton1InFragment2;
    Button myButton2InFragment2;
    Button myButton3InFragment2;
    Button myButton4InFragment2;


    Button myPushedButton;
    //Button myPreviousPushedButton;


    Bundle myBundle = new Bundle();



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putBundle(KEY_myBundle, myBundle);
        Log.d("MY_LOG", "onSaveInstanceState = "  + myBundle);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

    }





    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        //isQuitDialogOnTop = true;
        openQuitDialog();
       // Log.d ("MY_LOG", "onBackPressed isQuitDialogOnTop = " + isQuitDialogOnTop);

    }

    public void openQuitDialog() {
        AlertDialog.Builder myQuitDialog = new AlertDialog.Builder(GameActivity.this);


        isQuitDialogOnTop = true;
        myQuitDialog.setMessage("Do you want to quit from the Game?\n" +
                "You will lose all your progress for current group,\n" +
                "but your general progress (up to the first word in the current group) will be saved.");
        myQuitDialog.setTitle("Informational message.");
        myQuitDialog.setCancelable(false);
        myQuitDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                isQuitDialogOnTop = false;
                finish();
            }
        });
        myQuitDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                isQuitDialogOnTop = false;

            }
        });

        //myBundle.putBoolean(KEY_isQuitDialogOnTop, isQuitDialogOnTop);
        myQuitDialog.show();




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_game, menu);
        return super.onCreateOptionsMenu(menu);
       // return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        int id = item.getItemId();

        switch (id){
            case R.id.action_next:


               if(myCurrentGroup.split(", ").length == myIterationCounter +1){
                   myFinishedGroupCounter++;

                   myBundle.putInt(KEY_myFinishedGroupCounter, myFinishedGroupCounter);
                   if (myFinishedGroupCounter==myOverallQuantity){

                       myTVInfo3InFragment2.setText("Game over.");

                       myFragmentManager = getSupportFragmentManager();
                       myDialogFragment myDF = new myDialogFragment();
                       myDF.setCancelable(false);
                       myDF.show(myFragmentManager, "dialog");




                   }else{

                       myIterationCounter = 0;
                       myBundle.putInt(KEY_myIterationCounter, myIterationCounter);
                       myFirstStageOfTheGame();
                   }


               }else{
                   Log.d("MY_LOG", "  myOneIterationOfTheGame() in onOptionsItemSelected(MenuItem item)____");
                   myOneIterationOfTheGame();
               }



                isButtonClicked=false;
                myBundle.putBoolean(KEY_isButtonClicked, isButtonClicked);
                //Refresh menu item enable state
                invalidateOptionsMenu();

                return true;

            case R.id.action_test:
               // for (int i =0 ; i<100;i++) {
                  //  FragmentManager myFragmentManager = getSupportFragmentManager();
                   // myDialogFragment myDF = new myDialogFragment();
                   // myDF.show(myFragmentManager, "tag_dialog1");


              // }

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }




       // Log.d("MY_LOG", "onOptionsItemSelected ");

    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

            if (isButtonClicked == true) {
                // menu.setGroupEnabled(R.id.group1, true);
                menu.findItem(R.id.action_next).setEnabled(true);
            } else {
                //  menu.setGroupEnabled(R.id.group1, false);
                menu.findItem(R.id.action_next).setEnabled(false);
            }

       // menu.setGroupEnabled(R.id.group1,true);
        ///return super.onPrepareOptionsMenu(menu);
        return true;

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
       // super.onCreateContextMenu(menu, v, menuInfo);
        //menu.add(0,action_translation,0,"Show russian translation");
       getMenuInflater().inflate(R.menu.context_menu_game, menu);
        switch (v.getId()){
            case R.id.textViewForSynonym1:

                //myStr = myStr.toLowerCase();
                //myStr = myStr.substring(0,1).toUpperCase() + myStr.substring(1).toLowerCase();
                menu.setHeaderTitle("Word \"" + myFirstWordInGroup.toUpperCase() + "\"");
                myNumberOfSelectedTV = 1;
                break;

            case R.id.textViewForSynonym2:
                menu.setHeaderTitle("Word \"" + myCurrentGroup.split(", ")
                        [Integer.valueOf(myRandomPositionsForWordsInGroup.split(", ")[1])].toUpperCase() + "\"");
                myNumberOfSelectedTV = 2;
                break;

            case R.id.textViewForSynonym3:
                menu.setHeaderTitle("Word \"" + myCurrentGroup.split(", ")
                        [Integer.valueOf(myRandomPositionsForWordsInGroup.split(", ")[2])].toUpperCase() + "\"");
                myNumberOfSelectedTV = 3;
                break;

            case R.id.textViewForSynonym4:
                menu.setHeaderTitle("Word \"" + myCurrentGroup.split(", ")
                        [Integer.valueOf(myRandomPositionsForWordsInGroup.split(", ")[3])].toUpperCase() + "\"");
                myNumberOfSelectedTV = 4;
                break;

            case R.id.textViewForSynonym5:
                menu.setHeaderTitle("Word \"" + myCurrentGroup.split(", ")
                        [Integer.valueOf(myRandomPositionsForWordsInGroup.split(", ")[4])].toUpperCase() + "\"");
                myNumberOfSelectedTV = 5;
                break;

            case R.id.textViewForSynonym6:
                menu.setHeaderTitle("Word \"" + myCurrentGroup.split(", ")
                        [Integer.valueOf(myRandomPositionsForWordsInGroup.split(", ")[5])].toUpperCase() + "\"");
                myNumberOfSelectedTV = 6;
                break;

        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_translation:
                myFindForNeededRussianGroup(myNumberOfSelectedTV);

                break;


        }


       // return true;
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        myFragmentManager = getSupportFragmentManager();
        myFragment1 = (Fragment1) myFragmentManager.findFragmentById(R.id.fragment1);
        myFragment2 = (Fragment2) myFragmentManager.findFragmentById(R.id.fragment2);

        myTV1InFragment1 = (TextView) myFragment1.getView().findViewById(R.id.textViewForSynonym1);
        myTV2InFragment1 = (TextView) myFragment1.getView().findViewById(R.id.textViewForSynonym2);
        myTV3InFragment1 = (TextView) myFragment1.getView().findViewById(R.id.textViewForSynonym3);
        myTV4InFragment1 = (TextView) myFragment1.getView().findViewById(R.id.textViewForSynonym4);
        myTV5InFragment1 = (TextView) myFragment1.getView().findViewById(R.id.textViewForSynonym5);
        myTV6InFragment1 = (TextView) myFragment1.getView().findViewById(R.id.textViewForSynonym6);

        myTVInfo1InFragment1 = (TextView) myFragment1.getView().findViewById(R.id.textViewForInfo1);
        myTVInfo2InFragment1 = (TextView) myFragment1.getView().findViewById(R.id.textViewForInfo2);

        myTVInfo3InFragment2 = (TextView) myFragment2.getView().findViewById(R.id.textViewForInfo3);

        myButton1InFragment2 =(Button) myFragment2.getView().findViewById(R.id.buttonVariant1);
        myButton2InFragment2 =(Button) myFragment2.getView().findViewById(R.id.buttonVariant2);
        myButton3InFragment2 =(Button) myFragment2.getView().findViewById(R.id.buttonVariant3);
        myButton4InFragment2 =(Button) myFragment2.getView().findViewById(R.id.buttonVariant4);


        registerForContextMenu(myTV1InFragment1);
        registerForContextMenu(myTV2InFragment1);
        registerForContextMenu(myTV3InFragment1);
        registerForContextMenu(myTV4InFragment1);
        registerForContextMenu(myTV5InFragment1);
        registerForContextMenu(myTV6InFragment1);

        myOverallQuantity = Integer.valueOf(getResources().getString(R.string.synonyms_group_count));


        mySharedPreferences = getSharedPreferences(APP_VARIABLES_AND_COUNTERS, Context.MODE_PRIVATE);

        if (savedInstanceState != null){

            myBundle = savedInstanceState.getBundle(KEY_myBundle);

            myRandomPositionsForAllGroups = myBundle.getString(KEY_myRandomPositionsForAllGroups);
            isButtonClicked = myBundle.getBoolean(KEY_isButtonClicked);
            myIterationCounter = myBundle.getInt(KEY_myIterationCounter);
            myTotalScore = myBundle.getInt(KEY_myTotalScore);
            myCurrentGroup =  myBundle.getString(KEY_myCurrentGroup);
            myRandomPositionsForWordsInGroup = myBundle.getString(KEY_myRandomPositionsForWordsInGroup);
            myFirstWordInGroup = myBundle.getString(KEY_myFirstWordInGroup);
            myCurrentWordInGroup = myBundle.getString(KEY_myCurrentWordInGroup);
            myCurrentGroupNumber = myBundle.getInt(KEY_myCurrentGroupNumber);
            myFinishedGroupCounter = myBundle.getInt(KEY_myFinishedGroupCounter);
            myTotalScoreBeforeNewGroup = myBundle.getInt(KEY_myTotalScoreBeforeNewGroup);

            myButton1InFragment2.setText(myBundle.getString(KEY_myButton1InFragment2));
            myButton2InFragment2.setText(myBundle.getString(KEY_myButton2InFragment2));
            myButton3InFragment2.setText(myBundle.getString(KEY_myButton3InFragment2));
            myButton4InFragment2.setText(myBundle.getString(KEY_myButton4InFragment2));

            myButton1InFragment2.setClickable(myBundle.getBoolean(KEY_myButtonsIsClickable));
            myButton2InFragment2.setClickable(myBundle.getBoolean(KEY_myButtonsIsClickable));
            myButton3InFragment2.setClickable(myBundle.getBoolean(KEY_myButtonsIsClickable));
            myButton4InFragment2.setClickable(myBundle.getBoolean(KEY_myButtonsIsClickable));

            Log.d ("MY_LOG", "myBundle.getInt(KEY_myPushedButtonIndex) = " + myBundle.getInt(KEY_myPushedButtonIndex));

            if (myBundle.getInt(KEY_myPushedButtonIndex) != 0){
                myPushedButtonIndex = myBundle.getInt(KEY_myPushedButtonIndex);
                myPushedButton = (Button) myFragment2.getView().findViewById(myPushedButtonIndex);
                myPushedButton.setBackgroundColor(myBundle.getInt(KEY_myPushedButtonColor));

            }


            if (myBundle.getBoolean(KEY_isQuitDialogOnTop) == true){
                openQuitDialog();
            }

            Log.d ("MY_LOG", "BOUNDARY____________________________________________________");

            myTVInfo1InFragment1.setText(myBundle.getString(KEY_myTVInfo1InFragment1));
            myTVInfo2InFragment1.setText(myBundle.getString(KEY_myTVInfo2InFragment1));
            myTVInfo3InFragment2.setText(myBundle.getString(KEY_myTVInfo3InFragment2));
            myTVInfo3InFragment2.setSelected(myBundle.getBoolean(KEY_myTVInfo3InFragment2IsSelected));


            myTV1InFragment1.setText(myBundle.getString(KEY_myTV1InFragment1));
            myTV2InFragment1.setText(myBundle.getString(KEY_myTV2InFragment1));
            myTV3InFragment1.setText(myBundle.getString(KEY_myTV3InFragment1));
            myTV4InFragment1.setText(myBundle.getString(KEY_myTV4InFragment1));
            myTV5InFragment1.setText(myBundle.getString(KEY_myTV5InFragment1));
            myTV6InFragment1.setText(myBundle.getString(KEY_myTV6InFragment1));

            //myTV1InFragment1.setTextColor(Integer.valueOf(myBundle.getString("myTV1InFragment1Color")));
            myTV2InFragment1.setTextColor(myBundle.getInt(KEY_myTV2InFragment1Color));
            myTV3InFragment1.setTextColor(myBundle.getInt(KEY_myTV3InFragment1Color));
            myTV4InFragment1.setTextColor(myBundle.getInt(KEY_myTV4InFragment1Color));
            myTV5InFragment1.setTextColor(myBundle.getInt(KEY_myTV5InFragment1Color));
            myTV6InFragment1.setTextColor(myBundle.getInt(KEY_myTV6InFragment1Color));
           // myTV1InFragment1.setEnabled(myBundle.getBoolean("myTV1InFragment1IsEnabled"));
            myTV2InFragment1.setEnabled(myBundle.getBoolean(KEY_myTV2InFragment1IsEnabled));
            myTV3InFragment1.setEnabled(myBundle.getBoolean(KEY_myTV3InFragment1IsEnabled));
            myTV4InFragment1.setEnabled(myBundle.getBoolean(KEY_myTV4InFragment1IsEnabled));
            myTV5InFragment1.setEnabled(myBundle.getBoolean(KEY_myTV5InFragment1IsEnabled));
            myTV6InFragment1.setEnabled(myBundle.getBoolean(KEY_myTV6InFragment1IsEnabled));


            //Log.d ("MY_LOG", "savedInstanceState != null_____________________________________");


        }else if(mySharedPreferences.contains(KEY_myRandomPositionsForAllGroups)
                & mySharedPreferences.getString(KEY_myRandomPositionsForAllGroups, "") != "gameover") {

            myLoadSomeVariablesAndCounters();
            myBundle.putString(KEY_myRandomPositionsForAllGroups, myRandomPositionsForAllGroups);
            myFirstStageOfTheGame();

        }else{

                myRandomPositionsForAllGroups = Arrays.toString
                        (myArrayOfUniquePositions(myOverallQuantity, myOverallQuantity, 0)).replaceAll("\\[|\\]", "");
                myBundle.putString(KEY_myRandomPositionsForAllGroups, myRandomPositionsForAllGroups);

                Log.d("MY_LOG", "  myRandomPositionsForAllGroups = " + myRandomPositionsForAllGroups);

                myFirstStageOfTheGame();
        }

    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        myBundle.putBoolean(KEY_isQuitDialogOnTop, isQuitDialogOnTop);
        Log.d ("MY_LOG", "onWindowFocusChanged isQuitDialogOnTop = " + isQuitDialogOnTop);

        if(hasFocus) {

            myTV1InFragment1.setTextSize((float)(pxToDp(myTV1InFragment1.getMeasuredHeight())*0.5));
            myTV2InFragment1.setTextSize((float)(pxToDp(myTV1InFragment1.getMeasuredHeight())*0.5));
            myTV3InFragment1.setTextSize((float)(pxToDp(myTV1InFragment1.getMeasuredHeight())*0.5));
            myTV4InFragment1.setTextSize((float)(pxToDp(myTV1InFragment1.getMeasuredHeight())*0.5));
            myTV5InFragment1.setTextSize((float)(pxToDp(myTV1InFragment1.getMeasuredHeight())*0.5));
            myTV6InFragment1.setTextSize((float)(pxToDp(myTV1InFragment1.getMeasuredHeight())*0.5));

            myTVInfo1InFragment1.setTextSize((float)(pxToDp(myTVInfo1InFragment1.getMeasuredHeight())*0.6));
            myTVInfo2InFragment1.setTextSize((float)(pxToDp(myTVInfo2InFragment1.getMeasuredHeight())*0.6));
            myTVInfo3InFragment2.setTextSize((float)(pxToDp(myTVInfo3InFragment2.getMeasuredHeight())*0.6));



            if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){

                myButton1InFragment2.setTextSize((float) (pxToDp(myButton1InFragment2.getMeasuredHeight())*0.3));
                myButton2InFragment2.setTextSize((float) (pxToDp(myButton1InFragment2.getMeasuredHeight())*0.3));
                myButton3InFragment2.setTextSize((float) (pxToDp(myButton1InFragment2.getMeasuredHeight())*0.3));
                myButton4InFragment2.setTextSize((float) (pxToDp(myButton1InFragment2.getMeasuredHeight())*0.3));

            }else{

                myButton1InFragment2.setTextSize((float) (pxToDp(myButton1InFragment2.getMeasuredHeight())*0.5));
                myButton2InFragment2.setTextSize((float) (pxToDp(myButton1InFragment2.getMeasuredHeight())*0.5));
                myButton3InFragment2.setTextSize((float) (pxToDp(myButton1InFragment2.getMeasuredHeight())*0.5));
                myButton4InFragment2.setTextSize((float) (pxToDp(myButton1InFragment2.getMeasuredHeight())*0.5));

            }

        }

    }


    @Override
    protected void onStop() {

        super.onStop();
        mySaveSomeVariablesAndCounters();
       // Log.d("MY_LOG", "mySaveSomeVariablesAndCounters();");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mySaveSomeVariablesAndCounters();
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();

    }

    @Override
    public void onButtonSelected(int ButtonIndex) {

        isButtonClicked = true;
        myBundle.putBoolean(KEY_isButtonClicked, isButtonClicked);

        myPushedButtonIndex = ButtonIndex;

        if (myFragment1!=null & myFragment2!=null){


            myButton1InFragment2.setClickable(false);
            myButton2InFragment2.setClickable(false);
            myButton3InFragment2.setClickable(false);
            myButton4InFragment2.setClickable(false);
            myBundle.putBoolean(KEY_myButtonsIsClickable, myButton1InFragment2.isClickable());


            myPushedButton = (Button) myFragment2.getView().findViewById(ButtonIndex);
            myBundle.putInt(KEY_myPushedButtonIndex, ButtonIndex);
            //myTVInfo3InFragment2.setSelected(true);

            TextView myTVnInFragment1 = (TextView) myFragment1.getView().findViewById(myFindTVForSynonymsInFragment1(myIterationCounter));
            //myBundle.putInt("myTVnInFragment1ID", myFindTVForSynonymsInFragment1(myIterationCounter));

            //Refresh menu item enable state
            invalidateOptionsMenu();

            Log.d("MY_LOG", "_______________________________________________" );
            Log.d("MY_LOG", "myCurrentWordInGroup = " +myCurrentWordInGroup);
            Log.d("MY_LOG", "ButtonIndex = " +ButtonIndex);


            if(myPushedButton.getText().toString() == myCurrentWordInGroup){
                //myPushedButton.setBackground(getResources().getDrawable(R.color.colorGreen));

                myPushedButton.setBackgroundColor(getResources().getColor(R.color.colorGreen));


                myTVnInFragment1.setText(myCurrentWordInGroup);
                myTVnInFragment1.setEnabled(true);
                //myTVnInFragment1.setTextSize((float)(myFindScreenHeight()*0.02));

                myTotalScore++;


                myTVInfo3InFragment2.setText("Congrats! You are right. Continue with the next word in this group.");

                if(myCurrentGroup.split(", ").length == myIterationCounter +1){

                    myTVInfo3InFragment2.setText("Congrats! You are right. You've finished this group. Click \"Next\" to try another group.");


                }
            }else{
                myPushedButton.setBackgroundColor(getResources().getColor(R.color.colorRed));

                myTVnInFragment1.setText("Wrong answer");
                myTVnInFragment1.setTextColor(getResources().getColor(R.color.colorRed));
                myTVnInFragment1.setEnabled(false);
                //myTVnInFragment1.setTextSize((float)(myFindScreenHeight()*0.02));

                myTotalScore--;

                myTVInfo3InFragment2.setText("You did not guess it. Try another word in this group.");

                if(myCurrentGroup.split(", ").length == myIterationCounter +1){

                    myTVInfo3InFragment2.setText("You did not guess it. You've finished this group. Click \"Next\" to try another group.");


                }
            }

            //myBundle.putString("myPushedButtonColor", myPushedButton.getBackground().toString());
            //myBundle.putInt("myPushedButtonColor", myPushedButton.getSolidColor());
            myBundle.putInt(KEY_myPushedButtonColor, ((ColorDrawable)myPushedButton.getBackground()).getColor());



            String myTVnInFragment1ForBundleKey = "myTV" + (myIterationCounter+1) + "InFragment1";
            String myTVnInFragment1ColorForBundleKey = "myTV" + (myIterationCounter+1) + "InFragment1Color";
            String myTVnInFragment1IsEnabledForBundleKey = "myTV" + (myIterationCounter+1) + "InFragment1IsEnabled";

            myBundle.putString(myTVnInFragment1ForBundleKey, myTVnInFragment1.getText().toString());
            myBundle.putInt(myTVnInFragment1ColorForBundleKey, myTVnInFragment1.getCurrentTextColor());
            myBundle.putBoolean(myTVnInFragment1IsEnabledForBundleKey, myTVnInFragment1.isEnabled());

            //Log.d("MY_LOG", "myTVnInFragment1ForBundleID = "+myTVnInFragment1ForBundleID);
           // Log.d("MY_LOG", "myTVnInFragment1ColorForBundleID = "+myTVnInFragment1ColorForBundleID);
            //Log.d("MY_LOG", "myTVnInFragment1IsEnabledForBundleID = "+myTVnInFragment1IsEnabledForBundleID);

            myBundle.putString(KEY_myTVInfo3InFragment2, myTVInfo3InFragment2.getText().toString());


            myTVInfo1InFragment1.setText("Score: " + myTotalScore);
            myBundle.putString(KEY_myTVInfo1InFragment1, myTVInfo1InFragment1.getText().toString());
            myBundle.putInt(KEY_myTotalScore, myTotalScore);
        }

       // Log.d("MY_LOG", "ButtonIndex = "+ButtonIndex);
    }

    public void myFirstStageOfTheGame(){


        String[] myEnglishWordsArray = myFindRandomArrayFromXml(false)[0].split(", ");
        myTotalScoreBeforeNewGroup = myTotalScore;
        myBundle.putInt(KEY_myTotalScore, myTotalScore);
        myBundle.putInt(KEY_myTotalScoreBeforeNewGroup, myTotalScoreBeforeNewGroup);

        myIterationCounter = 1;
        myBundle.putInt(KEY_myIterationCounter, myIterationCounter);

        myCurrentGroup = myFindRandomArrayFromXml(false)[0];
        myBundle.putString(KEY_myCurrentGroup, myCurrentGroup);
        myBundle.putInt(KEY_myCurrentGroupNumber, myCurrentGroupNumber);
        Log.d("MY_LOG", "myCurrentGroup = " + myCurrentGroup);

        int[] myArrayForCheking = new int[myEnglishWordsArray.length];
            //myRandomPositionsForWordsInGroup = Arrays.toString(myArrayOfUniquePositionsOld(myArrayForCheking)).replaceAll("\\[|\\]","");

        myRandomPositionsForWordsInGroup = Arrays.toString(myFirstElementZero
                (myEnglishWordsArray.length, myEnglishWordsArray.length, 0)).replaceAll("\\[|\\]","");
        myBundle.putString(KEY_myRandomPositionsForWordsInGroup, myRandomPositionsForWordsInGroup);

        Log.d("MY_LOG", "myRandomPositionsForWordsInGroup = " + myRandomPositionsForWordsInGroup);

        myFirstWordInGroup = myEnglishWordsArray[0].substring(0,1).toUpperCase()+
                myEnglishWordsArray[0].substring(1);
        myBundle.putString(KEY_myFirstWordInGroup, myFirstWordInGroup);


            if(myFinishedGroupCounter > 0){


                myTV2InFragment1.setText("");
                myTV2InFragment1.setTextColor(getResources().getColor(R.color.colorText));


                myTV3InFragment1.setText("");
                myTV3InFragment1.setTextColor(getResources().getColor(R.color.colorText));


                myTV4InFragment1.setText("");
                myTV4InFragment1.setTextColor(getResources().getColor(R.color.colorText));


                myTV5InFragment1.setText("");
                myTV5InFragment1.setTextColor(getResources().getColor(R.color.colorText));


                myTV6InFragment1.setText("");
                myTV6InFragment1.setTextColor(getResources().getColor(R.color.colorText));



                myButton1InFragment2.setClickable(true);
                myButton2InFragment2.setClickable(true);
                myButton3InFragment2.setClickable(true);
                myButton4InFragment2.setClickable(true);
                myBundle.putBoolean(KEY_myButtonsIsClickable, myButton1InFragment2.isClickable());

                if (myPushedButtonIndex != 0) {
                    myPushedButton = (Button) myFragment2.getView().findViewById(myPushedButtonIndex);
                    myPushedButton.setBackgroundColor(getResources().getColor(R.color.colorButton));
                    myBundle.putInt(KEY_myPushedButtonIndex, myPushedButtonIndex);
                    // myBundle.putString("myPushedButtonColor", myPreviousPushedButton.getBackground().toString());
                    //myBundle.putInt("myPushedButtonColor", myPreviousPushedButton.getSolidColor());
                    myBundle.putInt(KEY_myPushedButtonColor, ((ColorDrawable)myPushedButton.getBackground()).getColor());
                }





            }



        myBundle.putInt(KEY_myFinishedGroupCounter, myFinishedGroupCounter);

        myBundle.putString(KEY_myTV2InFragment1, myTV2InFragment1.getText().toString());
        myBundle.putInt(KEY_myTV2InFragment1Color, myTV2InFragment1.getCurrentTextColor());
        myBundle.putBoolean(KEY_myTV2InFragment1IsEnabled, myTV2InFragment1.isEnabled());

        myBundle.putString(KEY_myTV3InFragment1, myTV3InFragment1.getText().toString());
        myBundle.putInt(KEY_myTV3InFragment1Color, myTV3InFragment1.getCurrentTextColor());
        myBundle.putBoolean(KEY_myTV3InFragment1IsEnabled, myTV3InFragment1.isEnabled());

        myBundle.putString(KEY_myTV4InFragment1, myTV4InFragment1.getText().toString());
        myBundle.putInt(KEY_myTV4InFragment1Color, myTV4InFragment1.getCurrentTextColor());
        myBundle.putBoolean(KEY_myTV4InFragment1IsEnabled, myTV4InFragment1.isEnabled());

        myBundle.putString(KEY_myTV5InFragment1,myTV5InFragment1.getText().toString());
        myBundle.putInt(KEY_myTV5InFragment1Color, myTV5InFragment1.getCurrentTextColor());
        myBundle.putBoolean(KEY_myTV5InFragment1IsEnabled, myTV5InFragment1.isEnabled());

        myBundle.putString(KEY_myTV6InFragment1,myTV6InFragment1.getText().toString());
        myBundle.putInt(KEY_myTV6InFragment1Color, myTV6InFragment1.getCurrentTextColor());
        myBundle.putBoolean(KEY_myTV6InFragment1IsEnabled, myTV6InFragment1.isEnabled());


        //TextView myTVInfo1InFragment1 = (TextView) myFragment1.getView().findViewById(R.id.textViewForInfo1);
        myTVInfo1InFragment1.setText("Score: " + myTotalScore);
        myBundle.putString(KEY_myTVInfo1InFragment1, myTVInfo1InFragment1.getText().toString());

            // TextView myTVInfo2InFragment1 = (TextView) myFragment1.getView().findViewById(R.id.textViewForInfo2);
        myTVInfo2InFragment1.setText("Current Group #: " + myCurrentGroupNumber);
        myBundle.putString(KEY_myTVInfo2InFragment1, myTVInfo2InFragment1.getText().toString());

            // myFragment1 = getSupportFragmentManager().findFragmentById(R.id.fragment1);
            //TextView myTV1inFragment1 = (TextView) myFragment1.getView().findViewById(R.id.textViewForSynonym1);
        myTV1InFragment1.setText(myFirstWordInGroup);
        myBundle.putString(KEY_myTV1InFragment1, myTV1InFragment1.getText().toString());

            // TextView myTVInfo3 = (TextView) myFragment2.getView().findViewById(R.id.textViewForInfo3);
        myTVInfo3InFragment2.setSelected(true);
        myTVInfo3InFragment2.setText("New synonyms' group. Choose synonym for word \""+myFirstWordInGroup+"\""+".");

        myBundle.putString(KEY_myTVInfo3InFragment2, myTVInfo3InFragment2.getText().toString());
        myBundle.putBoolean(KEY_myTVInfo3InFragment2IsSelected, myTVInfo3InFragment2.isSelected());

        Log.d("MY_LOG", "Before mySettingRandomWords()");

        mySettingRandomWords();



        Log.d("MY_LOG", "myFirstStageOfTheGame = " + myBundle);

        //myTextViewForSynonym1.setText(myStringArray[0]);

    }

    public void myOneIterationOfTheGame(){

        myButton1InFragment2.setClickable(true);
        myButton2InFragment2.setClickable(true);
        myButton3InFragment2.setClickable(true);
        myButton4InFragment2.setClickable(true);
        myBundle.putBoolean(KEY_myButtonsIsClickable, myButton1InFragment2.isClickable());

        myPushedButton = (Button) myFragment2.getView().findViewById(myPushedButtonIndex);
        myBundle.putInt(KEY_myPushedButtonIndex, myPushedButtonIndex);

        myPushedButton.setBackgroundColor(getResources().getColor(R.color.colorButton));

        //myBundle.putString("myPushedButtonColor", myPreviousPushedButton.getBackground().toString());
        //myBundle.putInt("myPushedButtonColor", myPreviousPushedButton.getSolidColor());
        myBundle.putInt(KEY_myPushedButtonColor, ((ColorDrawable)myPushedButton.getBackground()).getColor());
        Log.d("MY_LOG", "myOneIterationOfTheGame() AFTER ROTATION_______");
        //TextView myTVInfo3 = (TextView) myFragment2.getView().findViewById(R.id.textViewForInfo3);
        myTVInfo3InFragment2.setSelected(true);
        myTVInfo3InFragment2.setText("Choose synonym for word \""+myFirstWordInGroup+"\"");
        myBundle.putString(KEY_myTVInfo3InFragment2, myTVInfo3InFragment2.getText().toString());
        myBundle.putBoolean(KEY_myTVInfo3InFragment2IsSelected, myTVInfo3InFragment2.isSelected());

        myIterationCounter++;
        myBundle.putInt(KEY_myIterationCounter,  myIterationCounter);

        Log.d("MY_LOG", "myIterationCounter = "+ myIterationCounter);

        mySettingRandomWords();


    }

    public void mySettingRandomWords(){
        //String myAnotherWordFromGroup;

        String myAnotherWord1;
        String myAnotherWord2;
        String myAnotherWord3;
        Integer myAnotherWordPosition;
        Integer myRandomNumberForButtons;
        int[] myRandomNumbersForButtons=new int[4];

        //Integer myAnotherWordPositionFromGroup = (int)(Math.random()*englishWordsArray.length+1);
       //myCurrentWordInGroup = englishWordsArray[myAnotherWordPositionFromGroup];

        myCurrentWordInGroup = myCurrentGroup.split(", ")
                [Integer.valueOf(myRandomPositionsForWordsInGroup.split(", ")
                [myIterationCounter])].substring(0,1).toUpperCase() +
                 myCurrentGroup.split(", ")
                        [Integer.valueOf(myRandomPositionsForWordsInGroup.split(", ")
                        [myIterationCounter])].substring(1).toLowerCase();

        myBundle.putString(KEY_myCurrentWordInGroup, myCurrentWordInGroup);

        myAnotherWord1 = myAnotherWord();

        do{
            myAnotherWord2 = myAnotherWord();
            Log.d("MY_LOG", "myAnotherWord2   myAnotherWord1 = "+myAnotherWord2+"   "+myAnotherWord1);
        }while (myAnotherWord2.equals(myAnotherWord1));

        //}while (myAnotherWord1.toLowerCase()==myAnotherWord2.toLowerCase());

        do{
            myAnotherWord3 = myAnotherWord();
            Log.d("MY_LOG", "myAnotherWord3   myAnotherWord2   myAnotherWord1 = "
                    +myAnotherWord3+"   "+myAnotherWord2+"   "+myAnotherWord1);

            //  && и || - short version. dont see on the second part if the first is true
        }while (myAnotherWord3.equals(myAnotherWord1) || myAnotherWord3.equals(myAnotherWord2));


        myRandomNumbersForButtons = myArrayOfUniquePositions(4,4,1);
        Log.d("MY_LOG", "myRandomNumbersForButtons = "+Arrays.toString(myRandomNumbersForButtons));


        myFindNeededButton(myRandomNumbersForButtons[0]).setText(myCurrentWordInGroup);
        myFindNeededButton(myRandomNumbersForButtons[1]).setText(myAnotherWord1);
        myFindNeededButton(myRandomNumbersForButtons[2]).setText(myAnotherWord2);
        myFindNeededButton(myRandomNumbersForButtons[3]).setText(myAnotherWord3);

        myBundle.putString(KEY_myButton1InFragment2, myButton1InFragment2.getText().toString());
        myBundle.putString(KEY_myButton2InFragment2, myButton2InFragment2.getText().toString());
        myBundle.putString(KEY_myButton3InFragment2, myButton3InFragment2.getText().toString());
        myBundle.putString(KEY_myButton4InFragment2, myButton4InFragment2.getText().toString());

        myBundle.putBoolean(KEY_myButtonsIsClickable, myButton1InFragment2.isClickable());


        Log.d("MY_LOG", "myAnotherWordFromGroup = " + myCurrentWordInGroup);
        Log.d("MY_LOG", "myAnotherWord1 = "+myAnotherWord1);
        Log.d("MY_LOG", "myAnotherWord2 = "+myAnotherWord2);
        Log.d("MY_LOG", "myAnotherWord3 = "+myAnotherWord3);

    }

    String[] myFindRandomArrayFromXml(Boolean findNewGroup){
        Integer myRandomNumber = -1;
        //myOverallQuantity = Integer.valueOf(getResources().getString(R.string.synonyms_group_count));
        if (myIterationCounter == 0 & findNewGroup == false){
            //myRandomNumber = (int)(Math.random()*myOverallQuantity);
            myRandomNumber = Integer.valueOf(myRandomPositionsForAllGroups.split(", ")[myFinishedGroupCounter]);
            myCurrentGroupNumber = myRandomNumber;
        }else if(findNewGroup == false){
            myRandomNumber=myCurrentGroupNumber;
        }else if (findNewGroup==true){
            myRandomNumber = myFindRandomUniqueX(myCurrentGroupNumber, myOverallQuantity);
        }



        String myStringArrayName = "n"+String.valueOf(myRandomNumber);
        Integer myStringArrayID = getResources().getIdentifier("n" + myRandomNumber,"array", getPackageName());
        String[] myStringArray = getResources().getStringArray(myStringArrayID);

        return myStringArray;
    }


    Button myFindNeededButton(int randomNumber){

        Button myButtonVariantInFragment2 = (Button) myFragment2.getView().findViewById(R.id.buttonVariant1);
        switch (randomNumber){
            case 1:
               myButtonVariantInFragment2 = (Button) myFragment2.getView().findViewById(R.id.buttonVariant1);
                break;
            case 2:
               myButtonVariantInFragment2 = (Button) myFragment2.getView().findViewById(R.id.buttonVariant2);
                break;
            case 3:
               myButtonVariantInFragment2 = (Button) myFragment2.getView().findViewById(R.id.buttonVariant3);
                break;
            case 4:
               myButtonVariantInFragment2 = (Button) myFragment2.getView().findViewById(R.id.buttonVariant4);
                break;
        }
     return myButtonVariantInFragment2;
    }


    int myFindTVForSynonymsInFragment1(int id){
        int index = -1;
        switch (id){
            case 1:
                index = R.id.textViewForSynonym2;
                break;
            case 2:
                index = R.id.textViewForSynonym3;
                break;
            case 3:
                index = R.id.textViewForSynonym4;
                break;
            case 4:
                index = R.id.textViewForSynonym5;
                break;
            case 5:
                index = R.id.textViewForSynonym6;
                break;

        }
        return index;
    }

    float myFindScreenHeight(){

        //width and height in px for specific display
        Display myDisplay = getWindowManager().getDefaultDisplay();
        //WindowManager myWM = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        //Display myDisplay = myWM.getDefaultDisplay();

        Point mySize = new Point();
        myDisplay.getSize(mySize);
        int myWidth = mySize.x;
        int myHeight = mySize.y;
        //Log.d("MY_LOG", "myWidth = "+myWidth);
        //Log.d("MY_LOG", "myHeight = "+myHeight);
        return myHeight;
    }




    int myFindRandomUniqueX (int intA, int intSize){
        int myUniqueX = -1;
        do {
            myUniqueX = (int)(Math.random()*intSize);
        }while(myUniqueX==intA);
        return myUniqueX;

    }
    int[] myArrayOfUniquePositions (int arrayLength, int maxNumber, int minNumber){
        int[] myIntArray = new int[arrayLength];
        Integer myCurrentRandomNumber;
        //Random myRandom = new Random();

        myCurrentRandomNumber = (int) (Math.random() * maxNumber + minNumber);
        //myCurrentRandomNumber = myRandom.nextInt(maxNumber);
        myIntArray[0] = myCurrentRandomNumber;
      //  Log.d("MY_LOG", "myIntArray[0] = "+myIntArray[0]);
        for (int i = 1 ; i<myIntArray.length; i++) {
            Boolean myFlag = false;

            while(myFlag==false){
                myCurrentRandomNumber = (int) (Math.random() * maxNumber + minNumber);
               // myCurrentRandomNumber = myRandom.nextInt(maxNumber);
                myIntArray[i] =  myCurrentRandomNumber;

                //Log.d("MY_LOG", "Iteration i = "+i);
                //Log.d("MY_LOG", "myIntArray[i] = "+myIntArray[i]);
               // Log.d("MY_LOG", " ");
                for(int ii=i; ii>0;ii--){
                   // Log.d("MY_LOG", "Iteration ii = "+ii);
                   // Log.d("MY_LOG", "myIntArray[ii - 1] = "+myIntArray[ii - 1]);

                    if(myIntArray[ii - 1] == myIntArray[i]){
                        myFlag=false;
                        break;
                    }else{
                        myFlag=true;
                    }
                    // Log.d("MY_LOG", "myFlag = "+ myFlag);
                }


            }

        }
       // Log.d("MY_LOG", "myIntArray = "+Arrays.toString(myIntArray));
        // Log.d("MY_LOG", "_______________");


            //Log.d("MY_LOG", "myRandomNumbersForButtons= "+ i);

        return myIntArray;
    }

    public void myFindForNeededRussianGroup (int selectedTV){
        String myWord = "";
        String myTranslation = "";

        switch (selectedTV){
            case 1:
                myWord = myFirstWordInGroup;
                myTranslation = myFindRandomArrayFromXml(false)[1];

                break;
            case 2:
                myWord = myCurrentGroup.split(", ")
                        [Integer.valueOf(myRandomPositionsForWordsInGroup.split(", ")[1])];
                myTranslation = myFindRandomArrayFromXml(false)
                        [Integer.valueOf(myRandomPositionsForWordsInGroup.split(", ")[1])+1];

                break;

            case 3:
                myWord = myCurrentGroup.split(", ")
                        [Integer.valueOf(myRandomPositionsForWordsInGroup.split(", ")[2])];
                myTranslation = myFindRandomArrayFromXml(false)
                        [Integer.valueOf(myRandomPositionsForWordsInGroup.split(", ")[2])+1];

                break;

            case 4:
                myWord = myCurrentGroup.split(", ")
                        [Integer.valueOf(myRandomPositionsForWordsInGroup.split(", ")[3])];
                myTranslation = myFindRandomArrayFromXml(false)
                        [Integer.valueOf(myRandomPositionsForWordsInGroup.split(", ")[3])+1];

                break;

            case 5:
                myWord = myCurrentGroup.split(", ")
                        [Integer.valueOf(myRandomPositionsForWordsInGroup.split(", ")[4])];
                myTranslation = myFindRandomArrayFromXml(false)
                        [Integer.valueOf(myRandomPositionsForWordsInGroup.split(", ")[4])+1];

                break;

            case 6:
                myWord = myCurrentGroup.split(", ")
                        [Integer.valueOf(myRandomPositionsForWordsInGroup.split(", ")[5])];
                myTranslation = myFindRandomArrayFromXml(false)
                        [Integer.valueOf(myRandomPositionsForWordsInGroup.split(", ")[5])+1];

                break;

        }
                Intent myIntent = new Intent(getApplicationContext(), TranslationActivity.class);
                // Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
                myIntent.putExtra(WORD, myWord);
                myIntent.putExtra(TRANSLATION, myTranslation);
                startActivity(myIntent);


    }

    int[] myFirstElementZero (int arrayLength, int maxNumber, int minNumber) {
        int[] baseArray = myArrayOfUniquePositions(arrayLength-1, maxNumber-1, minNumber+1);
        int[] neededArray = new int[arrayLength];

        for(int i = 0; i < arrayLength; i++){
            if (i == 0){
                neededArray[i] = 0;
            }else{
                neededArray[i] = baseArray[i-1];
            }

        }
        //Log.d("MY_LOG", "neededArray = "+Arrays.toString(neededArray));
        return neededArray;

    }

    String myAnotherWord(){
        int myAnotherWordPosition;
        String myAnotherWord="";
        Boolean myFlagIsItSimilarWordGroup;

        do{

            myFlagIsItSimilarWordGroup = false;
            String[] myTempString = myFindRandomArrayFromXml(true)[0].split(", ");
            myAnotherWordPosition = (int)(Math.random()*(myTempString.length-1));
            myAnotherWord = myTempString[myAnotherWordPosition];

            for (String s : myCurrentGroup.split(", ")){
                Log.d("MY_LOG", "____For myCurrentGroup string = "+s+ "   "+myAnotherWord);
               // if (s.toLowerCase().toString() == myAnotherWord.toLowerCase().toString()){
                if(myAnotherWord.equals(s)){
                    myFlagIsItSimilarWordGroup = true;
                    Log.d("MY_LOG", "____myCurrentGroup WORD = "+s);
                    Log.d("MY_LOG", "____myAnotherWord WORD = "+myAnotherWord);
                    Log.d("MY_LOG", "_______________________________________");
                }
            }

        }while(myFlagIsItSimilarWordGroup == true);

        return myAnotherWord;

    }

    public void okClickedDialog(){


        myRandomPositionsForAllGroups = "gameover";
        myTotalScoreBeforeNewGroup = 0;
        myFinishedGroupCounter = 0;


        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(myIntent);
    }


    public void mySaveSomeVariablesAndCounters(){

       // mySharedPreferences = getSharedPreferences(APP_VARIABLES_AND_COUNTERS, Context.MODE_PRIVATE);
        SharedPreferences.Editor myEditor = mySharedPreferences.edit();

        myEditor.putString(KEY_myRandomPositionsForAllGroups, myRandomPositionsForAllGroups);

        myEditor.putInt(KEY_myTotalScoreBeforeNewGroup, myTotalScoreBeforeNewGroup);
        //myCounterForSharedPreferences += mySharedPreferences.getInt(KEY_myCounterForSharedPreferences, 0);
        //myEditor.putInt(KEY_myCounterForSharedPreferences, myCounterForSharedPreferences);
        myEditor.putInt(KEY_myFinishedGroupCounter, myFinishedGroupCounter);

        Log.d("MY_LOG", "_______________________________mySaveAllVariablesAndCounters()");
        Log.d("MY_LOG", "myRandomPositionsForAllGroups = "+myRandomPositionsForAllGroups);
        Log.d("MY_LOG", "myTotalScoreBeforeNewGroup = "+myTotalScoreBeforeNewGroup);
        Log.d("MY_LOG", "myFinishedGroupCounter = "+myFinishedGroupCounter);


        //myEditor.commit();
        myEditor.apply();


    }

    public void myLoadSomeVariablesAndCounters(){
       // mySharedPreferences = getSharedPreferences(APP_VARIABLES_AND_COUNTERS, Context.MODE_PRIVATE);

        myRandomPositionsForAllGroups = mySharedPreferences.getString(KEY_myRandomPositionsForAllGroups, "");
        myTotalScore = mySharedPreferences.getInt(KEY_myTotalScoreBeforeNewGroup, 0);
       // myCounterForSharedPreferences = mySharedPreferences.getInt(KEY_myCounterForSharedPreferences, 0);

        myFinishedGroupCounter = mySharedPreferences.getInt(KEY_myFinishedGroupCounter, 0);

        Log.d("MY_LOG", "_______________________________myLoadAllVariablesAndCounters()");
        Log.d("MY_LOG", "myRandomPositionsForAllGroups = "+myRandomPositionsForAllGroups);
        Log.d("MY_LOG", "myTotalScore = "+myTotalScore);
        Log.d("MY_LOG", "myFinishedGroupCounter = "+myFinishedGroupCounter);


    }

    public static int pxToDp(int px){
        Log.d ("MY_LOG", "Resources.getSystem().getDisplayMetrics().density =" +
                Resources.getSystem().getDisplayMetrics().density);
        return (int) (px / Resources.getSystem().getDisplayMetrics().density);

    }



}
















