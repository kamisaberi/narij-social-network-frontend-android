package com.narij.narijsocialnetwork.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.narij.narijsocialnetwork.R;
import com.narij.narijsocialnetwork.env.Globals;

public class ProfileResumeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_resume);

        TextView txtComment = (TextView) findViewById(R.id.txtComment);
        txtComment.setTypeface(Globals.typeface, Typeface.NORMAL);
        EditText edtSearch = (EditText) findViewById(R.id.edtSearch);
        edtSearch.setTypeface(Globals.typeface, Typeface.NORMAL);
        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setTypeface(Globals.typeface, Typeface.NORMAL);


    }
}
