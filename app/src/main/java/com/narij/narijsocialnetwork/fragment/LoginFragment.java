package com.narij.narijsocialnetwork.fragment;


import android.content.Intent;
import android.graphics.Typeface;
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
import com.narij.narijsocialnetwork.model.retrofit.MemberRetrofitModel;
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
        edtPhoneNumber.setTypeface(Globals.typeface, Typeface.NORMAL);

        edtPassword = (EditText) view.findViewById(R.id.edtPassword);
        edtPassword.setTypeface(Globals.typeface, Typeface.NORMAL);
        txtForgotPassword = (TextView) view.findViewById(R.id.txtForgotPassword);
        txtForgotPassword.setTypeface(Globals.typeface, Typeface.NORMAL);
        btnLogin = (FancyButton) view.findViewById(R.id.btnLogin);
        btnLogin.setCustomTextFont(Globals.LATO_MEDIUM_FONT);
        if (Globals.DEBUG_MODE) {
            edtPhoneNumber.setText("09365982333");
            edtPassword.setText("1234");
        }

        apiInterface = APIClient.getClient().create(APIInterface.class);


        btnLogin = (FancyButton) view.findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                Call<MemberRetrofitModel> call = apiInterface.login(edtPhoneNumber.getText().toString(), edtPassword.getText().toString());
                call.enqueue(new Callback<MemberRetrofitModel>() {
                    @Override
                    public void onResponse(Call<MemberRetrofitModel> call, Response<MemberRetrofitModel> response) {

                        Globals.loggedInData = response.body();


                        Log.d(Globals.LOG_TAG, Globals.loggedInData.message.getMessage());

                        if (Globals.loggedInData.message.isError()) {

                        } else {
                            Globals.token = Globals.loggedInData.message.getMessage().trim();
                            Intent intent = new Intent(getContext(), MainActivity.class);
                            startActivity(intent);
                            getActivity().finish();
                        }
                    }

                    @Override
                    public void onFailure(Call<MemberRetrofitModel> call, Throwable t) {

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
