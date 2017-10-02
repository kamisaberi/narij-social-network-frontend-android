package com.narij.narijsocialnetwork.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.narij.narijsocialnetwork.R;
import com.narij.narijsocialnetwork.env.Globals;

public class ForgotPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        Button btnPhoneNumber = (Button) findViewById(R.id.btnPhoneNumber);
        btnPhoneNumber.setTypeface(Globals.typeface, Typeface.NORMAL);
        Button btnEmailAddress = (Button) findViewById(R.id.btnEmailAddress);
        btnEmailAddress.setTypeface(Globals.typeface, Typeface.NORMAL);


        btnPhoneNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), EnterPhoneNumberForgotPasswordActivity.class);
                startActivity(intent);
            }
        });


        btnEmailAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), EnterEmailAddressForgotPasswordActivity.class);
                startActivity(intent);

            }
        });


    }
}
