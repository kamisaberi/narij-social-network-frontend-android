package com.narij.narijsocialnetwork.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.narij.narijsocialnetwork.R;
import com.narij.narijsocialnetwork.activity.ForgotPasswordActivity;
import com.narij.narijsocialnetwork.activity.MainActivity;
import com.narij.narijsocialnetwork.env.Globals;
import com.narij.narijsocialnetwork.model.retrofit.WebServiceMessage;
import com.narij.narijsocialnetwork.retrofit.APIClient;
import com.narij.narijsocialnetwork.retrofit.APIInterface;

import mehdi.sakout.fancybuttons.FancyButton;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {


    APIInterface apiInterface;

    public LoginFragment() {
        // Required empty public constructor
    }

    FancyButton btnLogin;
    EditText edtPhoneNumber;
    EditText edtPassword;
    TextView txtForgotPassword;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        edtPhoneNumber = (EditText) view.findViewById(R.id.edtPhoneNumber);
        edtPassword = (EditText) view.findViewById(R.id.edtPassword);
        txtForgotPassword = (TextView) view.findViewById(R.id.txtForgotPassword);
        btnLogin = (FancyButton) view.findViewById(R.id.btnLogin);

        if (Globals.DEBUG_MODE) {
            edtPhoneNumber.setText("09365982333");
            edtPassword.setText("1234");
        }

        apiInterface = APIClient.getClient().create(APIInterface.class);


        btnLogin = (FancyButton) view.findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                Call<WebServiceMessage> call = apiInterface.login(edtPhoneNumber.getText().toString(), edtPassword.getText().toString());
                call.enqueue(new Callback<WebServiceMessage>() {
                    @Override
                    public void onResponse(Call<WebServiceMessage> call, Response<WebServiceMessage> response) {

                        WebServiceMessage webServiceMessage = response.body();


                        Log.d(Globals.LOG_TAG, webServiceMessage.getMessage());

                        if (webServiceMessage.isError()) {

                        } else {
                            Globals.token = webServiceMessage.getMessage().trim();
                            Intent intent = new Intent(getContext(), MainActivity.class);
                            startActivity(intent);
                            getActivity().finish();
                        }
                    }

                    @Override
                    public void onFailure(Call<WebServiceMessage> call, Throwable t) {

                    }
                });


            }
        });

        txtForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });


        return view;
    }

}
