package com.narij.narijsocialnetwork.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.narij.narijsocialnetwork.R;
import com.narij.narijsocialnetwork.env.Globals;
import com.narij.narijsocialnetwork.model.WebServiceMessage;
import com.narij.narijsocialnetwork.retrofit.APIClient;
import com.narij.narijsocialnetwork.retrofit.APIInterface;

import mehdi.sakout.fancybuttons.FancyButton;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileEmailActivity extends AppCompatActivity {

    APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_email);


        apiInterface = APIClient.getClient().create(APIInterface.class);
        final EditText edtEmail = (EditText) findViewById(R.id.edtEmail);
        FancyButton btnSend = (FancyButton) findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Call<WebServiceMessage> call = apiInterface.setProfileEmail(Globals.token, edtEmail.getText().toString().trim());

                call.enqueue(new Callback<WebServiceMessage>() {
                    @Override
                    public void onResponse(Call<WebServiceMessage> call, Response<WebServiceMessage> response) {

                    }

                    @Override
                    public void onFailure(Call<WebServiceMessage> call, Throwable t) {

                    }
                });

            }
        });

    }
}
