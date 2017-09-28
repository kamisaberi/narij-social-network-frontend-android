package com.narij.narijsocialnetwork.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.narij.narijsocialnetwork.R;

public class ProfilePublicInfoActivity extends AppCompatActivity {


    EditText edtFullName;
    EditText edtBio;
    EditText edtWebsite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_public_info);


        edtFullName = (EditText) findViewById(R.id.edtFullName);
        edtBio = (EditText) findViewById(R.id.edtBio);
        edtWebsite = (EditText) findViewById(R.id.edtWebsite);


    }
}
