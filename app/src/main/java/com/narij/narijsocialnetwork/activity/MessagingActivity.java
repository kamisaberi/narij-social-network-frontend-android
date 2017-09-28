package com.narij.narijsocialnetwork.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.narij.narijsocialnetwork.R;

public class MessagingActivity extends AppCompatActivity {


    RecyclerView rcMessages;
    EditText edtMessage;
    ImageView imgSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messaging);

        rcMessages = (RecyclerView) findViewById(R.id.rcMessages);
        edtMessage = (EditText) findViewById(R.id.edtMessage);
        imgSend = (ImageView) findViewById(R.id.imgSend);





        imgSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });







    }
}
