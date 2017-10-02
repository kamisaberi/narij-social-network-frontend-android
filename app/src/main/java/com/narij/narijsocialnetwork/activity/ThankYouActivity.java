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

import org.w3c.dom.Text;

public class ThankYouActivity extends AppCompatActivity {

    public ThankYouActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thank_you);


        TextView txtThanks = (TextView)findViewById(R.id.txtThanks);
        txtThanks.setTypeface(Globals.typeface, Typeface.NORMAL);


        ImageView imgTick = (ImageView) findViewById(R.id.imgTick);

        imgTick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
