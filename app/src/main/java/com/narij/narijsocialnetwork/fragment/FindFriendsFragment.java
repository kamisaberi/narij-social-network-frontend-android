package com.narij.narijsocialnetwork.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.narij.narijsocialnetwork.R;
import com.narij.narijsocialnetwork.adapter.recycler.FriendListRecyclerAdapter;
import com.narij.narijsocialnetwork.adapter.recycler.FriendSuggestionListRecyclerAdapter;
import com.narij.narijsocialnetwork.env.Globals;
import com.narij.narijsocialnetwork.model.Member;
import com.narij.narijsocialnetwork.model.WebServiceMessage;
import com.narij.narijsocialnetwork.retrofit.APIClient;
import com.narij.narijsocialnetwork.retrofit.APIInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class FindFriendsFragment extends Fragment {


    RecyclerView rcSuggestion;
    RecyclerView rcFriends;
    EditText edtSearch;

    APIInterface apiInterface;


    public FindFriendsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_find_friends, container, false);

        apiInterface = APIClient.getClient().create(APIInterface.class);


        rcSuggestion = (RecyclerView) view.findViewById(R.id.rcSuggestion);

        FriendSuggestionListRecyclerAdapter friendSuggestionListRecyclerAdapter = new FriendSuggestionListRecyclerAdapter(new ArrayList<Member>(), getContext());
        rcSuggestion.setAdapter(friendSuggestionListRecyclerAdapter);
        rcSuggestion.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        rcFriends = (RecyclerView) view.findViewById(R.id.rcFriends);
        FriendListRecyclerAdapter friendListRecyclerAdapter = new FriendListRecyclerAdapter(new ArrayList<Member>(), getContext());
        rcFriends.setAdapter(friendListRecyclerAdapter);
        rcFriends.setLayoutManager(new LinearLayoutManager(getContext()));


        edtSearch = (EditText) view.findViewById(R.id.edtSearch);

        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                Call<WebServiceMessage> call = apiInterface.searchFriends(Globals.token, s.toString());
                call.enqueue(new Callback<WebServiceMessage>() {
                    @Override
                    public void onResponse(Call<WebServiceMessage> call, Response<WebServiceMessage> response) {

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
