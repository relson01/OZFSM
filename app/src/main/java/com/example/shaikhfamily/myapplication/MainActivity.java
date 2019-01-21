package com.example.shaikhfamily.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {


    private static int SPLASH_TIME = 2000; //This is 4 seconds
    private static String TAG = "splash";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Code to start timer and take action after the timer ends
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "run: ");
                Intent mySuperIntent = new Intent(MainActivity.this, LoginPage.class);
                startActivity(mySuperIntent);
                Log.d(TAG, "run: After Intent");
                finish();
                Log.d(TAG, "run: After finish");
            }
        }, SPLASH_TIME);


    }
}

