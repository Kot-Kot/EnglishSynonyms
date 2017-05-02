package com.example.kot.englishsynonyms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;


public class TranslationActivity extends AppCompatActivity {

    TextView myTVForTranslation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        //getActionBar().hide();
       // getSupportActionBar().hide();

        //GameActivity myGA = new GameActivity();

        setContentView(R.layout.activity_translation);
        myTVForTranslation = (TextView)findViewById(R.id.textViewForTranslation);
        Intent myIntent = getIntent();
        //String myWord = myIntent.getStringExtra(myGA.WORD);
        String myWord = myIntent.getStringExtra(GameActivity.WORD);
        //String myTranslation = myIntent.getStringExtra(myGA.TRANSLATION);

        String myTranslation = myIntent.getStringExtra(GameActivity.TRANSLATION);

        myWord = myWord.toUpperCase().toString() ;
        myTVForTranslation.setText(myWord + " - \n \n" + myTranslation);

    }
}
