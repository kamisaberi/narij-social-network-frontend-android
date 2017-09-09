package com.narij.narijsocialnetwork.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.narij.narijsocialnetwork.R;
import com.narij.narijsocialnetwork.adapter.recycler.FriendListRecyclerAdapter;
import com.narij.narijsocialnetwork.adapter.recycler.FriendSuggestionListRecyclerAdapter;
import com.narij.narijsocialnetwork.adapter.recycler.LogListRecyclerAdapter;
import com.narij.narijsocialnetwork.adapter.recycler.LogSuggestionListRecyclerAdapter;
import com.narij.narijsocialnetwork.model.Member;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class LogsFragment extends Fragment {


    public LogsFragment() {
        super();
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_logs, container, false);

        RecyclerView rcSuggestion = (RecyclerView) view.findViewById(R.id.rcSuggestion);

        LogSuggestionListRecyclerAdapter friendSuggestionListRecyclerAdapter = new LogSuggestionListRecyclerAdapter(new ArrayList<Member>(), getContext());
        rcSuggestion.setAdapter(friendSuggestionListRecyclerAdapter);
        rcSuggestion.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        RecyclerView rcFriends = (RecyclerView) view.findViewById(R.id.rcLogs);
        LogListRecyclerAdapter friendListRecyclerAdapter = new LogListRecyclerAdapter(new ArrayList<Member>(), getContext());
        rcFriends.setAdapter(friendListRecyclerAdapter);
        rcFriends.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

}
