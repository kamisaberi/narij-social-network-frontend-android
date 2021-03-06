package com.narij.narijsocialnetwork.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.narij.narijsocialnetwork.R;
import com.narij.narijsocialnetwork.env.Globals;
import com.narij.narijsocialnetwork.model.retrofit.WebServiceMessage;
import com.narij.narijsocialnetwork.retrofit.APIClient;
import com.narij.narijsocialnetwork.retrofit.APIInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChangePasswordActivity extends AppCompatActivity {


    APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        apiInterface = APIClient.getClient().create(APIInterface.class);

        final EditText edtOldPassword = (EditText) findViewById(R.id.edtOldPassword);
        edtOldPassword.setTypeface(Globals.typeface, Typeface.NORMAL);
        final EditText edtNewPassword = (EditText) findViewById(R.id.edtNewPassword);
        edtNewPassword.setTypeface(Globals.typeface, Typeface.NORMAL);
        final EditText edtConfirmNewPassword = (EditText) findViewById(R.id.edtConfirmNewPassword);
        edtConfirmNewPassword.setTypeface(Globals.typeface, Typeface.NORMAL);
        Button btnSend = (Button) findViewById(R.id.btnSend);
        btnSend.setTypeface(Globals.typeface, Typeface.NORMAL);


        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtNewPassword.getText().toString().trim().equals(edtConfirmNewPassword.getText().toString().trim())) {


                    Call<WebServiceMessage> callGetPassword = apiInterface.checkPassword(
                            Globals.token,
                            edtOldPassword.getText().toString(),
                            System.currentTimeMillis()
                    );
                    callGetPassword.enqueue(new Callback<WebServiceMessage>() {
                        @Override
                        public void onResponse(Call<WebServiceMessage> call, Response<WebServiceMessage> response) {

                            if (!response.body().isError()) {
                                Call<WebServiceMessage> callChangePassword = apiInterface.changePassword(
                                        Globals.token, edtOldPassword.getText().toString(),
                                        edtNewPassword.getText().toString(),
                                        System.currentTimeMillis()
                                );
                                callChangePassword.enqueue(new Callback<WebServiceMessage>() {
                                    @Override
                                    public void onResponse(Call<WebServiceMessage> call, Response<WebServiceMessage> response) {

                                    }

                                    @Override
                                    public void onFailure(Call<WebServiceMessage> call, Throwable t) {

                                    }
                                });
                            }
                        }

                        @Override
                        public void onFailure(Call<WebServiceMessage> call, Throwable t) {

                        }
                    });

                } else {

                }
            }
        });

    }
}
