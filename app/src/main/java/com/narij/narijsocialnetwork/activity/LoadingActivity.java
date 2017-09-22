package com.narij.narijsocialnetwork.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import com.narij.narijsocialnetwork.R;
import com.narij.narijsocialnetwork.env.Globals;
import com.narij.narijsocialnetwork.env.Login;
import com.narij.narijsocialnetwork.model.retrofit.WebServiceMessage;
import com.narij.narijsocialnetwork.retrofit.APIClient;
import com.narij.narijsocialnetwork.retrofit.APIInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoadingActivity extends AppCompatActivity {

    private static int TIME_OUT = 2000; //Time to launch the another activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

//        SharedPreferences.Editor editor = getSharedPreferences(Globals.PREF_FILE_NAME, MODE_PRIVATE).edit();
//        editor.putString(Globals.PREF_TOKEN_KEY, Globals.token);
//        editor.apply();


    }


    @Override
    protected void onStart() {
        super.onStart();

        final ProgressBar prgLoading = (ProgressBar) findViewById(R.id.prgLoading);
        prgLoading.setVisibility(View.VISIBLE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
                SharedPreferences prefs = getSharedPreferences(Globals.PREF_FILE_NAME, MODE_PRIVATE);
                Globals.token = prefs.getString(Globals.PREF_TOKEN_KEY, "");
                Globals.token = "";


                if (Globals.token.trim().isEmpty()) {
                    Intent intent;
                    intent = new Intent(getBaseContext(), LoginSignupActivity.class);
                    startActivity(intent);
                    prgLoading.setVisibility(View.GONE);
                    finish();
                    return;
                } else {

                    Call<WebServiceMessage> call = apiInterface.authenticate(Globals.token);
                    call.enqueue(new Callback<WebServiceMessage>() {
                        @Override
                        public void onResponse(Call<WebServiceMessage> call, Response<WebServiceMessage> response) {
                            if (response.body().isError())
                                return;
                            Intent intent;
                            switch (response.body().getMessage()) {
                                case Login.SUCCESS:
                                    intent = new Intent(getBaseContext(), MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                    break;
                                case Login.IP_CHANGED:
                                    intent = new Intent(getBaseContext(), ItIsMeActivity.class);
                                    startActivity(intent);
                                    finish();
                                    break;
                                case Login.INVALID:
                                    intent = new Intent(getBaseContext(), LoginSignupActivity.class);
                                    startActivity(intent);
                                    finish();
                                    break;
                            }
                            prgLoading.setVisibility(View.GONE);
                        }

                        @Override
                        public void onFailure(Call<WebServiceMessage> call, Throwable t) {

                        }
                    });
                }


            }
        }, TIME_OUT);
    }
}
