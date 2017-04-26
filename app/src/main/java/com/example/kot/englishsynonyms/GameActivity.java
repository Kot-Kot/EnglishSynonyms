package com.example.kot.englishsynonyms;

import android.content.Intent;
import android.graphics.Point;
import android.support.v4.app.FragmentManager;
//import android.app.FragmentManager;

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
import android.widget.Toast;

import java.util.Arrays;

public class GameActivity extends AppCompatActivity implements Fragment2.OnSelectedButtonListener {

    //public final Integer myOverallQuantity = Integer.valueOf(getResources().getString(R.string.synonyms_group_count));
    public final static String WORD = "com.example.kot.englishsynonyms.WORD";
    public final static String TRANSLATION = "com.example.kot.englishsynonyms.TRANSLATION";
    //final int action_translation = 1;

    Boolean isButtonClicked = false;
    int myNumberOfSelectedTV = -1;
    int myPushedButtonIndex;
    int myTotalScore = 0;
    int myFinishedGroupCounter = 0;
    int myIterationCounter = 0;
    int myCurrentGroupNumber;
    int myOverallQuantity;
    String myRandomPositionsForAllGroups;
    String myFirstWordInGroup;
    String myCurrentWordInGroup;
    String myRandomPositionsForWordsInGroup;
    String myCurrentGroup;
    Fragment1 myFragment1;
    Fragment2 myFragment2;




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
                   if (myFinishedGroupCounter==myOverallQuantity){
                      Toast.makeText(getApplicationContext(),"Sorry, you've watched all the groups.", Toast.LENGTH_LONG).show();
                   }else{

                       myIterationCounter = 0;
                       myFirstStageOfTheGame();
                   }


               }else{
                   myOneIterationOfTheGame();
               }



                isButtonClicked=false;
                //Refresh menu item enable state
                invalidateOptionsMenu();

                return true;

            case R.id.action_test:
                for (int i =0 ; i<100;i++) {
                   // Random myRandom = new Random();
                 // myArrayOfUniquePositions(33, 33, 0);
                    //myFirstElementZero(5,5,0);
                  // Log.d("MY_LOG", "  myPositions "  + myRandom.nextInt(11));
               }

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


                //Intent myIntent = new Intent(getApplicationContext(), TranslationActivity.class);

               // myIntent.putExtra(WORD, myFirstWordInGroup);
                //myIntent.putExtra(TRANSLATION, myFindRandomArrayFromXml(false)[1]);
               // startActivity(myIntent);

                break;

            //default:
                //return super.onOptionsItemSelected(item);

        }


       // return true;
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        FragmentManager myFragmentManager = getSupportFragmentManager();
        myFragment1 = (Fragment1) myFragmentManager.findFragmentById(R.id.fragment1);
        myFragment2 = (Fragment2) myFragmentManager.findFragmentById(R.id.fragment2);

        TextView myTV1InFragment1 = (TextView) myFragment1.getView().findViewById(R.id.textViewForSynonym1);
        TextView myTV2InFragment1 = (TextView) myFragment1.getView().findViewById(R.id.textViewForSynonym2);
        TextView myTV3InFragment1 = (TextView) myFragment1.getView().findViewById(R.id.textViewForSynonym3);
        TextView myTV4InFragment1 = (TextView) myFragment1.getView().findViewById(R.id.textViewForSynonym4);
        TextView myTV5InFragment1 = (TextView) myFragment1.getView().findViewById(R.id.textViewForSynonym5);
        TextView myTV6InFragment1 = (TextView) myFragment1.getView().findViewById(R.id.textViewForSynonym6);

        registerForContextMenu(myTV1InFragment1);
        registerForContextMenu(myTV2InFragment1);
        registerForContextMenu(myTV3InFragment1);
        registerForContextMenu(myTV4InFragment1);
        registerForContextMenu(myTV5InFragment1);
        registerForContextMenu(myTV6InFragment1);

        myOverallQuantity = Integer.valueOf(getResources().getString(R.string.synonyms_group_count));
        myRandomPositionsForAllGroups = Arrays.toString
                (myArrayOfUniquePositions(myOverallQuantity, myOverallQuantity, 0)).replaceAll("\\[|\\]","");
        Log.d("MY_LOG", "  myRandomPositionsForAllGroups = "  + myRandomPositionsForAllGroups);


        //if (myIterationCounter==0){
            myFirstStageOfTheGame();
        //}else if(myIterationCounter>0){
          //  myOneIterationOfTheGame();
       // }



    }




    @Override
    public void onButtonSelected(int ButtonIndex) {

        isButtonClicked = true;
        myPushedButtonIndex = ButtonIndex;



       // Fragment myFragment1 = getFragmentManager().findFragmentById(R.id.fragment1);

        FragmentManager myFragmentManager = getSupportFragmentManager();
        myFragment1 = (Fragment1) myFragmentManager.findFragmentById(R.id.fragment1);
        myFragment2 = (Fragment2) myFragmentManager.findFragmentById(R.id.fragment2);

        if (myFragment1!=null & myFragment2!=null){

            Button myButton1FromFragment2 = (Button) myFragment2.getView().findViewById(R.id.buttonVariant1);
            Button myButton2FromFragment2 = (Button) myFragment2.getView().findViewById(R.id.buttonVariant2);
            Button myButton3FromFragment2 = (Button) myFragment2.getView().findViewById(R.id.buttonVariant3);
            Button myButton4FromFragment2 = (Button) myFragment2.getView().findViewById(R.id.buttonVariant4);

            myButton1FromFragment2.setClickable(false);
            myButton2FromFragment2.setClickable(false);
            myButton3FromFragment2.setClickable(false);
            myButton4FromFragment2.setClickable(false);

            Button myPushedButton = (Button) myFragment2.getView().findViewById(ButtonIndex);


            TextView myTVInfo1 = (TextView) myFragment1.getView().findViewById(R.id.textViewForInfo1);

            TextView myTVInfo3 = (TextView) myFragment2.getView().findViewById(R.id.textViewForInfo3);
            myTVInfo3.setSelected(true);

            TextView myTVnInFragment1 = (TextView) myFragment1.getView().findViewById(myFindTVForSynonymsInFragment1(myIterationCounter));


            //Refresh menu item enable state
            invalidateOptionsMenu();



            if(myPushedButton.getText().toString() == myCurrentWordInGroup){
                //myPushedButton.setBackground(getResources().getDrawable(R.color.colorGreen));

                myPushedButton.setBackgroundColor(getResources().getColor(R.color.colorGreen));
                myTVnInFragment1.setText(myCurrentWordInGroup);
                myTVnInFragment1.setEnabled(true);
                myTVnInFragment1.setTextSize((float)(myFindScreenHeight()*0.02));

                myTotalScore++;


                myTVInfo3.setText("Congrats! You are right. Continue with the next word in this group.");

                if(myCurrentGroup.split(", ").length == myIterationCounter +1){

                    myTVInfo3.setText("Congrats! You are right. You've finished this group. Click \"Next\" to try another group.");


                }
            }else{
                myPushedButton.setBackgroundColor(getResources().getColor(R.color.colorRed));
                myTVnInFragment1.setText("Wrong answer");
                myTVnInFragment1.setTextColor(getResources().getColor(R.color.colorRed));
                myTVnInFragment1.setEnabled(false);
                myTVnInFragment1.setTextSize((float)(myFindScreenHeight()*0.02));

                myTotalScore--;

                myTVInfo3.setText("You did not guess it. Try another word in this group.");

                if(myCurrentGroup.split(", ").length == myIterationCounter +1){

                    myTVInfo3.setText("You did not guess it. You've finished this group. Click \"Next\" to try another group.");


                }
            }


            myTVInfo1.setText("Score: " + myTotalScore);
           // ((TextView) myFragment1.getView().findViewById(R.id.textViewForSynonym1))
                   // .setText(String.valueOf(ButtonIndex));

            //Log.d("MY_LOG", "myCurrentGroup.split = "+ myCurrentGroup.split(", ").length);

            if(myCurrentGroup.split(", ").length == myIterationCounter +1){

                myTVInfo3.setText(myTVInfo3.getText() + " You've finished this group. Click \"Next\" to try another group.");


            }
        }
       // Log.d("MY_LOG", "ButtonIndex = "+ButtonIndex);



    }

    public void myFirstStageOfTheGame(){



        String[] myEnglishWordsArray = myFindRandomArrayFromXml(false)[0].split(", ");
        myIterationCounter = 1;


        myCurrentGroup = myFindRandomArrayFromXml(false)[0];
        Log.d("MY_LOG", "myCurrentGroup = " + myCurrentGroup);
        int[] myArrayForCheking = new int[myEnglishWordsArray.length];
        //myRandomPositionsForWordsInGroup = Arrays.toString(myArrayOfUniquePositionsOld(myArrayForCheking)).replaceAll("\\[|\\]","");

        myRandomPositionsForWordsInGroup = Arrays.toString(myFirstElementZero
                (myEnglishWordsArray.length, myEnglishWordsArray.length, 0)).replaceAll("\\[|\\]","");

        Log.d("MY_LOG", "myRandomPositionsForWordsInGroup = " + myRandomPositionsForWordsInGroup);



        myFirstWordInGroup = myEnglishWordsArray[0].substring(0,1).toUpperCase()+
                myEnglishWordsArray[0].substring(1);




        FragmentManager myFragmentManager = getSupportFragmentManager();
        myFragment1 = (Fragment1) myFragmentManager.findFragmentById(R.id.fragment1);
        myFragment2 = (Fragment2) myFragmentManager.findFragmentById(R.id.fragment2);
        if(myFinishedGroupCounter > 0){

            TextView myTV2InFragment1 = (TextView) myFragment1.getView().findViewById(R.id.textViewForSynonym2);
            myTV2InFragment1.setText("");
            myTV2InFragment1.setTextColor(getResources().getColor(R.color.colorText));

            TextView myTV3InFragment1 = (TextView) myFragment1.getView().findViewById(R.id.textViewForSynonym3);
            myTV3InFragment1.setText("");
            myTV3InFragment1.setTextColor(getResources().getColor(R.color.colorText));

            TextView myTV4InFragment1 = (TextView) myFragment1.getView().findViewById(R.id.textViewForSynonym4);
            myTV4InFragment1.setText("");
            myTV4InFragment1.setTextColor(getResources().getColor(R.color.colorText));

            TextView myTV5InFragment1 = (TextView) myFragment1.getView().findViewById(R.id.textViewForSynonym5);
            myTV5InFragment1.setText("");
            myTV5InFragment1.setTextColor(getResources().getColor(R.color.colorText));

            TextView myTV6InFragment1 = (TextView) myFragment1.getView().findViewById(R.id.textViewForSynonym6);
            myTV6InFragment1.setText("");
            myTV6InFragment1.setTextColor(getResources().getColor(R.color.colorText));

            Button myButton1FromFragment2 = (Button) myFragment2.getView().findViewById(R.id.buttonVariant1);
            Button myButton2FromFragment2 = (Button) myFragment2.getView().findViewById(R.id.buttonVariant2);
            Button myButton3FromFragment2 = (Button) myFragment2.getView().findViewById(R.id.buttonVariant3);
            Button myButton4FromFragment2 = (Button) myFragment2.getView().findViewById(R.id.buttonVariant4);

            myButton1FromFragment2.setClickable(true);
            myButton2FromFragment2.setClickable(true);
            myButton3FromFragment2.setClickable(true);
            myButton4FromFragment2.setClickable(true);

            Button myPreviousPushedButton = (Button) myFragment2.getView().findViewById(myPushedButtonIndex);
            myPreviousPushedButton.setBackgroundColor(getResources().getColor(R.color.colorButton));

        }





        TextView myTVInfo1InFragment1 = (TextView) myFragment1.getView().findViewById(R.id.textViewForInfo1);
        myTVInfo1InFragment1.setText("Score: " + myTotalScore);

        TextView myTVInfo2InFragment1 = (TextView) myFragment1.getView().findViewById(R.id.textViewForInfo2);
        myTVInfo2InFragment1.setText("Current Group #: " + myCurrentGroupNumber);


       // myFragment1 = getSupportFragmentManager().findFragmentById(R.id.fragment1);
        TextView myTV1inFragment1 = (TextView) myFragment1.getView().findViewById(R.id.textViewForSynonym1);
        myTV1inFragment1.setText(myFirstWordInGroup);

        TextView myTVInfo3 = (TextView) myFragment2.getView().findViewById(R.id.textViewForInfo3);
        myTVInfo3.setSelected(true);
        myTVInfo3.setText("New synonyms' group. Choose synonym for word \""+myFirstWordInGroup+"\"");

        mySettingRandomWords();


        //myTextViewForSynonym1.setText(myStringArray[0]);
    }

    public void myOneIterationOfTheGame(){
        FragmentManager myFragmentManager = getSupportFragmentManager();
        myFragment1 = (Fragment1) myFragmentManager.findFragmentById(R.id.fragment1);
        myFragment2 = (Fragment2) myFragmentManager.findFragmentById(R.id.fragment2);

        Button myButton1FromFragment2 = (Button) myFragment2.getView().findViewById(R.id.buttonVariant1);
        Button myButton2FromFragment2 = (Button) myFragment2.getView().findViewById(R.id.buttonVariant2);
        Button myButton3FromFragment2 = (Button) myFragment2.getView().findViewById(R.id.buttonVariant3);
        Button myButton4FromFragment2 = (Button) myFragment2.getView().findViewById(R.id.buttonVariant4);

        myButton1FromFragment2.setClickable(true);
        myButton2FromFragment2.setClickable(true);
        myButton3FromFragment2.setClickable(true);
        myButton4FromFragment2.setClickable(true);

        Button myPreviousPushedButton = (Button) myFragment2.getView().findViewById(myPushedButtonIndex);
        //myPreviousPushedButton.setBackgroundColor(getResources().getColor(R.color.colorWhite));

      // TypedValue myTV = new TypedValue();
      // Resources.Theme myTheme = getApplicationContext().getTheme();
      // myTheme.resolveAttribute(R.attr.colorButtonNormal, myTV, true);
       // int myColorButtonNormal = myTV.data;


        //int[] myAttribute = new int[] { R.attr.colorButtonNormal };
       // TypedArray myArray = getApplicationContext().getTheme().obtainStyledAttributes(myAttribute);
       //int myColorButtonNormal = myArray.getColor(0, Color.TRANSPARENT);
       //myArray.recycle();





        myPreviousPushedButton.setBackgroundColor(getResources().getColor(R.color.colorButton));


        TextView myTVInfo3 = (TextView) myFragment2.getView().findViewById(R.id.textViewForInfo3);
        myTVInfo3.setSelected(true);
        myTVInfo3.setText("Choose synonym for word \""+myFirstWordInGroup+"\"");



        myIterationCounter++;
        Log.d("MY_LOG", "myIterationCounter = "+ myIterationCounter);

        mySettingRandomWords();


    }
    //public void mySettingRandomWords(Integer[] arrayForChecking,String[] englishWordsArray,String[] stringArray){
    public void mySettingRandomWords(){
        //String myAnotherWordFromGroup;

        String myAnotherWord1;
        String myAnotherWord2;
        String myAnotherWord3;
        Integer myAnotherWordPosition;
        Integer myRandomNumberForButtons;
        Integer[] myRandomNumbersForButtons=new Integer[4];

        //Integer myAnotherWordPositionFromGroup = (int)(Math.random()*englishWordsArray.length+1);
       //myCurrentWordInGroup = englishWordsArray[myAnotherWordPositionFromGroup];

        myCurrentWordInGroup = myCurrentGroup.split(", ")
                [Integer.valueOf(myRandomPositionsForWordsInGroup.split(", ")
                [myIterationCounter])].substring(0,1).toUpperCase() +

                 myCurrentGroup.split(", ")
                        [Integer.valueOf(myRandomPositionsForWordsInGroup.split(", ")
                        [myIterationCounter])].substring(1).toLowerCase();

        String[] myTempString1 = myFindRandomArrayFromXml(true)[0].split(", ");
        myAnotherWordPosition = (int)(Math.random()*(myTempString1.length-1));
        myAnotherWord1 = myTempString1[myAnotherWordPosition];

        String[] myTempString2 = myFindRandomArrayFromXml(true)[0].split(", ");
        myAnotherWordPosition = (int)(Math.random()*(myTempString2.length-1));
        myAnotherWord2 = myTempString2[myAnotherWordPosition];

        String[] myTempString3 = myFindRandomArrayFromXml(true)[0].split(", ");
        myAnotherWordPosition = (int)(Math.random()*(myTempString3.length-1));
        myAnotherWord3 = myTempString3[myAnotherWordPosition];

        myRandomNumberForButtons = (int) (Math.random() * 4 + 1);
        myRandomNumbersForButtons[0] = myRandomNumberForButtons;
        // Log.d("MY_LOG", "_______________");
        //  Log.d("MY_LOG", "myRandomNumbersForButtons [0] = "+myRandomNumbersForButtons[0]);

        for (int i = 2; i<=4; i++) {
            Boolean myFlag = false;

            while(myFlag==false){
                myRandomNumberForButtons = (int) (Math.random() * 4 + 1);
                myRandomNumbersForButtons[i - 1] = myRandomNumberForButtons;
                // Log.d("MY_LOG", "Iteration i = "+i);
                // Log.d("MY_LOG", "myRandomNumbersForButtons[i - 1] = "+myRandomNumbersForButtons[i - 1]);
                // Log.d("MY_LOG", " ");
                for(int ii=i-1; ii>=1;--ii){
                    //  Log.d("MY_LOG", "Iteration ii = "+ii);
                    //  Log.d("MY_LOG", "myRandomNumbersForButtons[ii - 1] = "+myRandomNumbersForButtons[ii - 1]);
                    if(myRandomNumbersForButtons[ii - 1] == myRandomNumbersForButtons[i-1]){
                        myFlag=false;
                        break;
                    }else{
                        myFlag=true;
                    }
                    // Log.d("MY_LOG", "myFlag = "+ myFlag);
                }


            }
            //Log.d("MY_LOG", "myRandomNumbersForButtons = "+myRandomNumbersForButtons[i-1]);
        }

        Log.d("MY_LOG", "myAnotherWordFromGroup = " + myCurrentWordInGroup);
        Log.d("MY_LOG", "myAnotherWord1 = "+myAnotherWord1);
        Log.d("MY_LOG", "myAnotherWord2 = "+myAnotherWord2);
        Log.d("MY_LOG", "myAnotherWord3 = "+myAnotherWord3);

        //FragmentManager myFragmentManager = getSupportFragmentManager();
       //myFragment2 = (Fragment2) myFragmentManager.findFragmentById(R.id.fragment2);
       // ((Button) myFragment2.getView().findViewById(R.id.buttonVariant1)).setText(myAnotherWordFromGroup);

        myFindNeededButton(myRandomNumbersForButtons[0]).setText(myCurrentWordInGroup);
        myFindNeededButton(myRandomNumbersForButtons[1]).setText(myAnotherWord1);
        myFindNeededButton(myRandomNumbersForButtons[2]).setText(myAnotherWord2);
        myFindNeededButton(myRandomNumbersForButtons[3]).setText(myAnotherWord3);








    }

    String[] myFindRandomArrayFromXml(Boolean findNewGroup){
        Integer myRandomNumber = -1;
        //myOverallQuantity = Integer.valueOf(getResources().getString(R.string.synonyms_group_count));
        if (myIterationCounter ==0 & findNewGroup == false){
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

        FragmentManager myFragmentManager = getSupportFragmentManager();
        myFragment2 = (Fragment2) myFragmentManager.findFragmentById(R.id.fragment2);


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
                neededArray[i]=0;
            }else{
                neededArray[i]=baseArray[i-1];
            }

        }
        //Log.d("MY_LOG", "neededArray = "+Arrays.toString(neededArray));
        return neededArray;

    }








}
















