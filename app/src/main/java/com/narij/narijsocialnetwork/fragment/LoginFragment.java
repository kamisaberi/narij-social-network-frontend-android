package com.narij.narijsocialnetwork.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.narij.narijsocialnetwork.R;

import mehdi.sakout.fancybuttons.FancyButton;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {


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


        return view;
    }

}
