package com.narij.narijsocialnetwork.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.narij.narijsocialnetwork.R;
import com.narij.narijsocialnetwork.adapter.recycler.FollowerListRecyclerAdapter;
import com.narij.narijsocialnetwork.adapter.recycler.MessageListRecyclerAdapter;
import com.narij.narijsocialnetwork.env.Globals;
import com.narij.narijsocialnetwork.model.base.Follow;
import com.narij.narijsocialnetwork.model.base.Member;
import com.narij.narijsocialnetwork.model.base.Message;
import com.narij.narijsocialnetwork.model.retrofit.FollowsRetrofitModel;
import com.narij.narijsocialnetwork.model.retrofit.MessagesRetrofitModel;
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
public class MessagesFragment extends Fragment {

    APIInterface apiInterface;
    private long memberId;

    ViewPager pager;
    FragmentManager fragmentManager;

    public ArrayList<Message> messages= new ArrayList<>();

    @SuppressLint("ValidFragment")
    public MessagesFragment(long memberId) {
        this.memberId = memberId;
        Globals.stackedFragments.add(this);
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public MessagesFragment(long memberId, ViewPager pager, FragmentManager fm) {
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
        View view = inflater.inflate(R.layout.fragment_messages, container, false);

        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rcMessages);


        apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<MessagesRetrofitModel> call = apiInterface.getMessages(Globals.token,memberId);

        try {
            call.enqueue(new Callback<MessagesRetrofitModel>() {
                @Override
                public void onResponse(Call<MessagesRetrofitModel> call, Response<MessagesRetrofitModel> response) {

                    messages= response.body().messages;
                    WebServiceMessage message = response.body().message;

                    MessageListRecyclerAdapter adapter = new MessageListRecyclerAdapter(messages, getContext());
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

                }

                @Override
                public void onFailure(Call<MessagesRetrofitModel> call, Throwable t) {
                    Log.d(Globals.LOG_TAG, t.getMessage());
                }
            });
        } catch (Exception e) {
            Log.d(Globals.LOG_TAG, e.getMessage());
        }


        return view;
    }

}
