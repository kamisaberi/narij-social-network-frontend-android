package com.narij.narijsocialnetwork.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.narij.narijsocialnetwork.R;
import com.narij.narijsocialnetwork.env.Globals;
import com.narij.narijsocialnetwork.model.retrofit.WebServiceMessage;
import com.narij.narijsocialnetwork.receiver.BroadcastSmsReceiver;
import com.narij.narijsocialnetwork.retrofit.APIClient;
import com.narij.narijsocialnetwork.retrofit.APIInterface;

import mehdi.sakout.fancybuttons.FancyButton;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EnterVerificationCodeActivity extends AppCompatActivity {


    public String phone = "";

    public EditText edtVerificationCode;
    BroadcastSmsReceiver incomingSms = new BroadcastSmsReceiver();
    public static EnterVerificationCodeActivity ins;

    APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_phone_number);


        phone = getIntent().getStringExtra("phone");


        final ProgressBar prgLoading = (ProgressBar) findViewById(R.id.prgLoading);

        edtVerificationCode = (EditText) findViewById(R.id.edtVerificationCode);
        edtVerificationCode.setTypeface(Globals.typeface, Typeface.NORMAL);
        apiInterface = APIClient.getClient().create(APIInterface.class);
        //final EditText edtVerificationCode = (EditText) findViewById(R.id.edtVerificationCode);
        FancyButton btnSend = (FancyButton) findViewById(R.id.btnSend);
        btnSend.setCustomIconFont(Globals.LATO_MEDIUM_FONT);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prgLoading.setVisibility(View.VISIBLE);

                Call<WebServiceMessage> call = apiInterface.enterVerificationCode(
                        phone,
                        edtVerificationCode.getText().toString().trim()
                        , System.currentTimeMillis()
                );

                call.enqueue(new Callback<WebServiceMessage>() {
                    @Override
                    public void onResponse(Call<WebServiceMessage> call, Response<WebServiceMessage> response) {

                        try {
                            WebServiceMessage message = response.body();
                            Log.d(Globals.LOG_TAG, message.getMessage());
                            if (!message.isError()) {
                                Log.d(Globals.LOG_TAG, message.getMessage());
                                Intent intent = new Intent(getBaseContext(), ProfileFullNameActivity.class);
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
                        Log.d(Globals.LOG_TAG, t.getMessage());
                        prgLoading.setVisibility(View.GONE);
                    }
                });
            }
        });


        ins = this;

    }
}
