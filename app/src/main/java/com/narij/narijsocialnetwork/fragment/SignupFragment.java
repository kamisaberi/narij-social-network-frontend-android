package com.narij.narijsocialnetwork.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.narij.narijsocialnetwork.R;
import com.narij.narijsocialnetwork.activity.EnterVerificationCodeActivity;
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
public class SignupFragment extends Fragment {


    FancyButton btnLogin;
    EditText edtPhoneNumber;

    APIInterface apiInterface;

    public SignupFragment() {
        super();
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_signup, container, false);

        edtPhoneNumber = (EditText) view.findViewById(R.id.edtPhoneNumber);

        if (Globals.DEBUG_MODE)
            edtPhoneNumber.setText("09365982333");

        btnLogin = (FancyButton) view.findViewById(R.id.btnLogin);
        final ProgressBar prgLoading = (ProgressBar) view.findViewById(R.id.prgLoading);
        apiInterface = APIClient.getClient().create(APIInterface.class);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prgLoading.setVisibility(View.VISIBLE);


                Call<WebServiceMessage> call = apiInterface.enterPhoneNumber(edtPhoneNumber.getText().toString().trim());

                call.enqueue(new Callback<WebServiceMessage>() {
                    @Override
                    public void onResponse(Call<WebServiceMessage> call, Response<WebServiceMessage> response) {

                        WebServiceMessage message = response.body();

                        if (!message.isError()) {


                            Globals.token = message.getMessage();

                            if (Globals.DEBUG_MODE)
                                Log.d(Globals.LOG_TAG, "TOKEN IS : " + Globals.token);


                            Intent intent = new Intent(getContext(), EnterVerificationCodeActivity.class);
                            intent.putExtra("phone", edtPhoneNumber.getText().toString());
                            startActivity(intent);
                        }
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


        return view;

    }


}
