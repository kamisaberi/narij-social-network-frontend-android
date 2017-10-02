package com.narij.narijsocialnetwork.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.narij.narijsocialnetwork.R;
import com.narij.narijsocialnetwork.env.Globals;

public class ProfilePublicInfoActivity extends AppCompatActivity {


    EditText edtFullName;
    EditText edtBio;
    EditText edtWebsite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_public_info);


        edtFullName = (EditText) findViewById(R.id.edtFullName);
        edtFullName.setTypeface(Globals.typeface, Typeface.NORMAL);
        edtBio = (EditText) findViewById(R.id.edtBio);
        edtBio.setTypeface(Globals.typeface, Typeface.NORMAL);
        edtWebsite = (EditText) findViewById(R.id.edtWebsite);
        edtWebsite.setTypeface(Globals.typeface, Typeface.NORMAL);


    }
}
