package com.narij.narijsocialnetwork.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.narij.narijsocialnetwork.R;

public class LoadingActivity extends AppCompatActivity {

    private static int TIME_OUT = 4000; //Time to launch the another activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(LoadingActivity.this, LoginSignupActivity.class);
                startActivity(i);
                finish();
            }
        }, TIME_OUT);

    }
}
