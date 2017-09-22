package com.narij.narijsocialnetwork.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.narij.narijsocialnetwork.R;
import com.narij.narijsocialnetwork.adapter.recycler.FriendListRecyclerAdapter;
import com.narij.narijsocialnetwork.adapter.recycler.FriendSuggestionListRecyclerAdapter;
import com.narij.narijsocialnetwork.env.Globals;
import com.narij.narijsocialnetwork.model.base.Member;
import com.narij.narijsocialnetwork.model.retrofit.FriendsRetrofitModel;
import com.narij.narijsocialnetwork.model.retrofit.WebServiceMessage;
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


        Call<FriendsRetrofitModel> call = apiInterface.getSuggestions(Globals.token);
        call.enqueue(new Callback<FriendsRetrofitModel>() {
            @Override
            public void onResponse(Call<FriendsRetrofitModel> call, Response<FriendsRetrofitModel> response) {

                ArrayList<Member> members = response.body().members;
                WebServiceMessage message = response.body().message;

                FriendSuggestionListRecyclerAdapter friendSuggestionListRecyclerAdapter = new FriendSuggestionListRecyclerAdapter(members, getContext());
                rcSuggestion.setAdapter(friendSuggestionListRecyclerAdapter);
                rcSuggestion.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
            }

            @Override
            public void onFailure(Call<FriendsRetrofitModel> call, Throwable t) {

            }
        });


        rcFriends = (RecyclerView) view.findViewById(R.id.rcFriends);


        ArrayList<Member> mmbrs = new ArrayList<>();
        final FriendListRecyclerAdapter friendListRecyclerAdapter = new FriendListRecyclerAdapter(mmbrs, getContext());
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

                if (s.toString().isEmpty()) {
                    friendListRecyclerAdapter.friends.clear();
                    friendListRecyclerAdapter.notifyDataSetChanged();
                    return;
                }

                try {

                    Log.d(Globals.LOG_TAG, s.toString());

                    Call<FriendsRetrofitModel> call = apiInterface.searchFriends(Globals.token, s.toString());
                    call.enqueue(new Callback<FriendsRetrofitModel>() {
                        @Override
                        public void onResponse(Call<FriendsRetrofitModel> call, Response<FriendsRetrofitModel> response) {
                            ArrayList<Member> members = response.body().members;
                            Log.d(Globals.LOG_TAG, "MEM SIZE :" + members.size());
                            WebServiceMessage message = response.body().message;

                            friendListRecyclerAdapter.friends.clear();
                            friendListRecyclerAdapter.friends.addAll(members);
                            friendListRecyclerAdapter.notifyDataSetChanged();


                        }

                        @Override
                        public void onFailure(Call<FriendsRetrofitModel> call, Throwable t) {

                            Log.d(Globals.LOG_TAG, t.getMessage());

                        }
                    });
                } catch (Exception e) {
                    Log.d(Globals.LOG_TAG, e.getMessage());
                }
            }
        });


        return view;
    }

}
