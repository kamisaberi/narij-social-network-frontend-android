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

/**
 * A simple {@link Fragment} subclass.
 */
public class SignupFragment extends Fragment {


    Button btnLogin;
    EditText edtPhoneNumber;


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
        btnLogin = (Button) view.findViewById(R.id.btnLogin);

        return view;

    }


}
