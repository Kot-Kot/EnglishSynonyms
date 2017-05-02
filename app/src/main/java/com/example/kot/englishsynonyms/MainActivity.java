package com.example.kot.englishsynonyms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button myButtonStart;
    TextView myTestTV;
    TextView myMainTV1;
    TextView myMainTV2;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        int id = item.getItemId();

        switch (id) {
            case R.id.action_start:

                Intent myIntent = new Intent(getApplicationContext(), GameActivity.class);
                startActivity(myIntent);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        myButtonStart = (Button) findViewById(R.id.buttonStart);
        myTestTV = (TextView) findViewById(R.id.textViewForTests);
        myMainTV1 = (TextView) findViewById(R.id.textViewMain1);
        myMainTV2 = (TextView) findViewById(R.id.textViewMain2);


        myButtonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(getApplicationContext(), GameActivity.class);
                startActivity(myIntent);




            }
        });

        RotateAnimation myRotateAnimation1  = (RotateAnimation) AnimationUtils.loadAnimation
                (getApplicationContext(), R.anim.rotate_animation1);

        myMainTV1.setAnimation(myRotateAnimation1);

        RotateAnimation myRotateAnimation2  = (RotateAnimation) AnimationUtils.loadAnimation
                (getApplicationContext(), R.anim.rotate_animation2);

        myMainTV2.setAnimation(myRotateAnimation2);









    }
}
