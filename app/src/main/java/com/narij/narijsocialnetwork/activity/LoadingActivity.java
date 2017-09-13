package com.narij.narijsocialnetwork.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.narij.narijsocialnetwork.R;
import com.narij.narijsocialnetwork.env.Globals;
import com.narij.narijsocialnetwork.env.Login;
import com.narij.narijsocialnetwork.model.WebServiceMessage;
import com.narij.narijsocialnetwork.retrofit.APIClient;
import com.narij.narijsocialnetwork.retrofit.APIInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoadingActivity extends AppCompatActivity {

    private static int TIME_OUT = 4000; //Time to launch the another activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

//        SharedPreferences.Editor editor = getSharedPreferences(Globals.PREF_FILE_NAME, MODE_PRIVATE).edit();
//        editor.putString(Globals.PREF_TOKEN_KEY, Globals.token);
//        editor.apply();

        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        SharedPreferences prefs = getSharedPreferences(Globals.PREF_FILE_NAME, MODE_PRIVATE);
        Globals.token = prefs.getString(Globals.PREF_TOKEN_KEY, "");

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


            }

            @Override
            public void onFailure(Call<WebServiceMessage> call, Throwable t) {

            }
        });


    }
}
