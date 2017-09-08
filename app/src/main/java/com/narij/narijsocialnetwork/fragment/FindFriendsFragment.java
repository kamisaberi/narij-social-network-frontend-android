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

/**
 * A simple {@link Fragment} subclass.
 */
public class FindFriendsFragment extends Fragment {


    public FindFriendsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_find_friends, container, false);

        RecyclerView rcSuggestion = (RecyclerView) view.findViewById(R.id.rcSuggestion);

        FriendSuggestionListRecyclerAdapter friendSuggestionListRecyclerAdapter = new FriendSuggestionListRecyclerAdapter();
        rcSuggestion.setAdapter(friendSuggestionListRecyclerAdapter);
        rcSuggestion.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));


        RecyclerView rcFriends = (RecyclerView) view.findViewById(R.id.rcFriends);
        FriendListRecyclerAdapter friendListRecyclerAdapter = new FriendListRecyclerAdapter();
        rcFriends.setAdapter(friendListRecyclerAdapter);
        rcFriends.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

}
