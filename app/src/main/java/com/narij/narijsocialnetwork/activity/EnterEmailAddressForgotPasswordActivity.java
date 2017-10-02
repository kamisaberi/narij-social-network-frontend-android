package com.narij.narijsocialnetwork.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.narij.narijsocialnetwork.R;
import com.narij.narijsocialnetwork.env.Globals;
import com.narij.narijsocialnetwork.model.retrofit.WebServiceMessage;
import com.narij.narijsocialnetwork.retrofit.APIClient;
import com.narij.narijsocialnetwork.retrofit.APIInterface;

import mehdi.sakout.fancybuttons.FancyButton;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EnterEmailAddressForgotPasswordActivity extends AppCompatActivity {


    APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_email_address_forgot_password);

        apiInterface = APIClient.getClient().create(APIInterface.class);

        final EditText edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtEmail.setTypeface(Globals.typeface, Typeface.NORMAL);
        FancyButton btnSend = (FancyButton) findViewById(R.id.btnSend);
        btnSend.setCustomIconFont(Globals.LATO_MEDIUM_FONT);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Call<WebServiceMessage> call = apiInterface.enterEmailToRecoverPassword(edtEmail.getText().toString().trim());
                call.enqueue(new Callback<WebServiceMessage>() {
                    @Override
                    public void onResponse(Call<WebServiceMessage> call, Response<WebServiceMessage> response) {
                        WebServiceMessage message = response.body();
                        if (!message.isError()) {
                            Intent intent = new Intent(getBaseContext(), EnterVerificationCodeActivity.class);
                            intent.putExtra("recovery","email");
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<WebServiceMessage> call, Throwable t) {

                    }
                });

            }
        });


    }
}
