package com.narij.narijsocialnetwork.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.narij.narijsocialnetwork.R;
import com.narij.narijsocialnetwork.adapter.recycler.LogListRecyclerAdapter;
import com.narij.narijsocialnetwork.adapter.recycler.LogSuggestionListRecyclerAdapter;
import com.narij.narijsocialnetwork.env.Globals;
import com.narij.narijsocialnetwork.model.base.Log;
import com.narij.narijsocialnetwork.model.retrofit.FriendsRetrofitModel;
import com.narij.narijsocialnetwork.model.retrofit.LogsRetrofitModel;
import com.narij.narijsocialnetwork.retrofit.APIClient;
import com.narij.narijsocialnetwork.retrofit.APIInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class LogsFragment extends Fragment {

    APIInterface apiInterface;
    private long memberId;

    ViewPager pager;
    FragmentManager fragmentManager;

    public ArrayList<Log> logs = new ArrayList<>();


    @SuppressLint("ValidFragment")
    public LogsFragment(long memberId) {
        this.memberId = memberId;
        Globals.stackedFragments.add(this);
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public LogsFragment(long memberId, ViewPager pager, FragmentManager fm) {
        this.memberId = memberId;
        this.pager = pager;
        this.fragmentManager = fm;
        Globals.stackedFragments.add(this);
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_logs, container, false);

        final RecyclerView rcSuggestion = (RecyclerView) view.findViewById(R.id.rcSuggestion);


        final RecyclerView rcLogs = (RecyclerView) view.findViewById(R.id.rcLogs);

        apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<LogsRetrofitModel> call = apiInterface.getLogs(Globals.token, memberId);
        call.enqueue(new Callback<LogsRetrofitModel>() {
            @Override
            public void onResponse(Call<LogsRetrofitModel> call, Response<LogsRetrofitModel> response) {

                LogsRetrofitModel logsRetrofitModel = response.body();
                logs = logsRetrofitModel.logs;
                LogListRecyclerAdapter friendListRecyclerAdapter = new LogListRecyclerAdapter(logs, getContext(),pager,fragmentManager);
                rcLogs.setAdapter(friendListRecyclerAdapter);
                rcLogs.setLayoutManager(new LinearLayoutManager(getContext()));

            }

            @Override
            public void onFailure(Call<LogsRetrofitModel> call, Throwable t) {

            }
        });


        Call<FriendsRetrofitModel> call1 = apiInterface.getSuggestions(Globals.token);
        call1.enqueue(new Callback<FriendsRetrofitModel>() {
            @Override
            public void onResponse(Call<FriendsRetrofitModel> call, Response<FriendsRetrofitModel> response) {

                FriendsRetrofitModel friendsRetrofitModel = response.body();

                android.util.Log.d(Globals.LOG_TAG, "LS S : "+friendsRetrofitModel.members.size() + "");


                LogSuggestionListRecyclerAdapter friendSuggestionListRecyclerAdapter = new LogSuggestionListRecyclerAdapter(friendsRetrofitModel.members, getContext(),pager,fragmentManager);
                rcSuggestion.setAdapter(friendSuggestionListRecyclerAdapter);
                rcSuggestion.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
            }

            @Override
            public void onFailure(Call<FriendsRetrofitModel> call, Throwable t) {

            }
        });


        return view;
    }

}
