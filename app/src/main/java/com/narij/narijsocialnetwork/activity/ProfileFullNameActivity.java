package com.narij.narijsocialnetwork.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
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

public class ProfileFullNameActivity extends AppCompatActivity {

    APIInterface apiInterface;

    String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_full_name);

        getActionBar().setTitle("Name");

        //getActionBar().setDisplayHomeAsUpEnabled(true);


        phone = getIntent().getStringExtra("phone");

        final ProgressBar prgLoading = (ProgressBar) findViewById(R.id.prgLoading);

        apiInterface = APIClient.getClient().create(APIInterface.class);
        final EditText edtFullName = (EditText) findViewById(R.id.edtFullName);
        FancyButton btnSend = (FancyButton) findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prgLoading.setVisibility(View.VISIBLE);

                Call<WebServiceMessage> call = apiInterface.setProfileFullName(phone, edtFullName.getText().toString().trim());

                call.enqueue(new Callback<WebServiceMessage>() {
                    @Override
                    public void onResponse(Call<WebServiceMessage> call, Response<WebServiceMessage> response) {
                        try {
                            WebServiceMessage message = response.body();
                            if (!message.isError()) {
                                Log.d(Globals.LOG_TAG, message.getMessage());
                                Intent intent = new Intent(getBaseContext(), ProfileEmailActivity.class);
                                intent.putExtra("phone", phone);
                                startActivity(intent);
                            } else {

                            }

                        } catch (Exception e) {
                            Log.d(Globals.LOG_TAG, e.getMessage());
                        }

//                        if (Globals.DEBUG_MODE) {
//                            try {
//                                Log.d(Globals.LOG_TAG, response.raw().body().string());
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                        }

                        prgLoading.setVisibility(View.GONE);

                    }

                    @Override
                    public void onFailure(Call<WebServiceMessage> call, Throwable t) {

                    }
                });

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.skip, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent intent;
        switch (item.getItemId()) {
            case R.id.mnuSkip:
                intent = new Intent(getBaseContext(), ProfileEmailActivity.class);
                intent.putExtra("phone", phone);
                startActivity(intent);
                break;
        }
        return (super.onOptionsItemSelected(item));
    }
}
