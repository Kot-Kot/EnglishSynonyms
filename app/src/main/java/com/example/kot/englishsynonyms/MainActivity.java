package com.example.kot.englishsynonyms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button myButtonStart;
    TextView myTestTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        myButtonStart = (Button) findViewById(R.id.buttonStart);
        myTestTV = (TextView) findViewById(R.id.textViewForTests);


        myButtonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(getApplicationContext(), GameActivity.class);
                startActivity(myIntent);

            }
        });







    }
}
