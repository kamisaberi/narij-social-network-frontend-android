package com.narij.narijsocialnetwork.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.narij.narijsocialnetwork.R;
import com.narij.narijsocialnetwork.adapter.recycler.FollowerListRecyclerAdapter;
import com.narij.narijsocialnetwork.adapter.recycler.MessageListRecyclerAdapter;
import com.narij.narijsocialnetwork.model.Member;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessagesFragment extends Fragment {


    public MessagesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_messages, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rcMessages);
        MessageListRecyclerAdapter adapter = new MessageListRecyclerAdapter(new ArrayList<Member>(), getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

}
