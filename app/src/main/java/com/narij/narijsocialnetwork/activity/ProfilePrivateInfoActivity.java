package com.narij.narijsocialnetwork.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Spinner;

import com.narij.narijsocialnetwork.R;
import com.narij.narijsocialnetwork.env.Globals;

public class ProfilePrivateInfoActivity extends AppCompatActivity {

    EditText edtEmail;
    EditText edtPhone;
    EditText edtRegistryCode;
    Spinner spnSex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_private_info);

        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtEmail.setTypeface(Globals.typeface, Typeface.NORMAL);
        edtPhone = (EditText) findViewById(R.id.edtPhone);
        edtPhone.setTypeface(Globals.typeface, Typeface.NORMAL);
        edtRegistryCode = (EditText) findViewById(R.id.edtRegistryCode);
        edtRegistryCode.setTypeface(Globals.typeface, Typeface.NORMAL);
        spnSex = (Spinner) findViewById(R.id.spnSex);




    }
}
