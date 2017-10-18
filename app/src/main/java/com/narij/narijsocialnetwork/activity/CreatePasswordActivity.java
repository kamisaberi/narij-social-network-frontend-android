package com.narij.narijsocialnetwork.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.narij.narijsocialnetwork.R;
import com.narij.narijsocialnetwork.env.Globals;
import com.narij.narijsocialnetwork.model.retrofit.WebServiceMessage;
import com.narij.narijsocialnetwork.retrofit.APIClient;
import com.narij.narijsocialnetwork.retrofit.APIInterface;

import mehdi.sakout.fancybuttons.FancyButton;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreatePasswordActivity extends AppCompatActivity {


    APIInterface apiInterface;
    String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_password);


        apiInterface = APIClient.getClient().create(APIInterface.class);
        final EditText edtPassword = (EditText) findViewById(R.id.edtPassword);
        edtPassword.setTypeface(Globals.typeface, Typeface.NORMAL);
        FancyButton btnSend = (FancyButton) findViewById(R.id.btnSend);
        btnSend.setCustomIconFont(Globals.LATO_MEDIUM_FONT);

        phone = getIntent().getStringExtra("phone");
        final ProgressBar prgLoading = (ProgressBar) findViewById(R.id.prgLoading);


        //getActionBar().setDisplayHomeAsUpEnabled(true);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                prgLoading.setVisibility(View.VISIBLE);
                Call<WebServiceMessage> call = apiInterface.createPassword(phone, edtPassword.getText().toString().trim());
                call.enqueue(new Callback<WebServiceMessage>() {
                    @Override
                    public void onResponse(Call<WebServiceMessage> call, Response<WebServiceMessage> response) {

                        WebServiceMessage message = response.body();
                        Log.d(Globals.LOG_TAG, message.getMessage());

                        if (!message.isError()) {
                            Intent intent = new Intent(getBaseContext(), ProfilePhotoActivity.class);
                            intent.putExtra("phone", phone);
                            startActivity(intent);
                            finish();
                        }
                        prgLoading.setVisibility(View.GONE);
                    }

                    @Override
                    public void onFailure(Call<WebServiceMessage> call, Throwable t) {
                        prgLoading.setVisibility(View.GONE);
                    }
                });


            }
        });


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent intent;
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return true;
    }

}
