package com.narij.narijsocialnetwork.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.narij.narijsocialnetwork.R;
import com.narij.narijsocialnetwork.env.Globals;

public class ProfileActivity extends AppCompatActivity {


    TextView txtPublic;
    TextView txtPrivate;
    TextView txtLocation;
    TextView txtResume;

    ImageView imgPublic;
    ImageView imgPrivate;
    ImageView imgLocation;
    ImageView imgResume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        txtPublic = (TextView) findViewById(R.id.txtPublic);
        txtPublic.setTypeface(Globals.typeface, Typeface.NORMAL);
        txtPrivate= (TextView) findViewById(R.id.txtPrivate);
        txtPrivate.setTypeface(Globals.typeface, Typeface.NORMAL);
        txtLocation= (TextView) findViewById(R.id.txtLocation);
        txtLocation.setTypeface(Globals.typeface, Typeface.NORMAL);
        txtResume= (TextView) findViewById(R.id.txtResume);
        txtResume.setTypeface(Globals.typeface, Typeface.NORMAL);

        imgPublic = (ImageView) findViewById(R.id.imgPublic);
        imgPrivate = (ImageView) findViewById(R.id.imgPrivate);
        imgLocation = (ImageView) findViewById(R.id.imgLocation);
        imgResume = (ImageView) findViewById(R.id.imgResume);

        imgPublic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ProfilePublicInfoActivity.class);
                startActivityForResult(intent, 1001);
            }
        });

        imgPrivate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ProfilePrivateInfoActivity.class);
                startActivityForResult(intent, 1002);

            }
        });

        imgLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ProfileLocationActivity.class);
                startActivityForResult(intent, 1003);

            }
        });

        imgResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ProfileResumeActivity.class);
                startActivityForResult(intent, 1004);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode != RESULT_OK)
            return;

        switch (requestCode) {
            case 1001:


                break;
            case 1002:


                break;
            case 1003:


                break;
            case 1004:


                break;
        }






    }
}
