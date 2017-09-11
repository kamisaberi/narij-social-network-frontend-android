package com.narij.narijsocialnetwork.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.narij.narijsocialnetwork.R;
import com.narij.narijsocialnetwork.activity.EnterVerificationCodeActivity;
import com.narij.narijsocialnetwork.model.WebServiceMessage;
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
        btnLogin = (FancyButton) view.findViewById(R.id.btnLogin);

        apiInterface = APIClient.getClient().create(APIInterface.class);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Call<WebServiceMessage> call = apiInterface.enterPhoneNumber(edtPhoneNumber.getText().toString().trim());

                call.enqueue(new Callback<WebServiceMessage>() {
                    @Override
                    public void onResponse(Call<WebServiceMessage> call, Response<WebServiceMessage> response) {

                        WebServiceMessage message = response.body();

                        if (!message.isError()) {
                            //Globals.token = message.getMessage();
                            Intent intent = new Intent(getContext(), EnterVerificationCodeActivity.class);
                            intent.putExtra("recovery", "");
                            startActivity(intent);
                        }

                    }

                    @Override
                    public void onFailure(Call<WebServiceMessage> call, Throwable t) {

                    }
                });

            }
        });


        return view;

    }


}
