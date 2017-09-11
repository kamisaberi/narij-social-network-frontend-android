package com.narij.narijsocialnetwork.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.narij.narijsocialnetwork.R;
import com.narij.narijsocialnetwork.env.Globals;
import com.narij.narijsocialnetwork.model.WebServiceMessage;
import com.narij.narijsocialnetwork.receiver.BroadcastSmsReceiver;
import com.narij.narijsocialnetwork.retrofit.APIClient;
import com.narij.narijsocialnetwork.retrofit.APIInterface;

import mehdi.sakout.fancybuttons.FancyButton;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EnterVerificationCodeActivity extends AppCompatActivity {


    public String recovery = "";

    public EditText edtVerificationCode;
    BroadcastSmsReceiver incomingSms = new BroadcastSmsReceiver();
    public static EnterVerificationCodeActivity ins;

    APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_phone_number);


        recovery = getIntent().getStringExtra("recovery");



        edtVerificationCode = (EditText) findViewById(R.id.edtVerificationCode);
        apiInterface = APIClient.getClient().create(APIInterface.class);
        //final EditText edtVerificationCode = (EditText) findViewById(R.id.edtVerificationCode);
        FancyButton btnSend = (FancyButton) findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Call<WebServiceMessage> call = apiInterface.enterVerificationCode(Globals.token, edtVerificationCode.getText().toString().trim());

                call.enqueue(new Callback<WebServiceMessage>() {
                    @Override
                    public void onResponse(Call<WebServiceMessage> call, Response<WebServiceMessage> response) {

                        WebServiceMessage message = response.body();
                        if (!message.isError()) {
                            Intent intent = new Intent(getBaseContext(), CreatePasswordActivity.class);
                            startActivity(intent);
                        } else {

                        }
                    }

                    @Override
                    public void onFailure(Call<WebServiceMessage> call, Throwable t) {

                    }
                });
            }
        });


        ins = this;

    }
}
