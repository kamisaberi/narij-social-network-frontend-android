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
import com.narij.narijsocialnetwork.adapter.recycler.FollowerListRecyclerAdapter;
import com.narij.narijsocialnetwork.adapter.recycler.FollowingListRecyclerAdapter;
import com.narij.narijsocialnetwork.env.Globals;
import com.narij.narijsocialnetwork.model.base.Follow;
import com.narij.narijsocialnetwork.model.retrofit.FollowsRetrofitModel;
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
@SuppressLint("ValidFragment")
public class FollowingFragment extends Fragment {

    APIInterface apiInterface;
    private long memberId;

    public ArrayList<Follow> followings = new ArrayList<>();

    ViewPager pager;
    FragmentManager fragmentManager;


    @SuppressLint("ValidFragment")
    public FollowingFragment(long memberId) {

        this.memberId = memberId;
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public FollowingFragment(long memberId, ViewPager pager, FragmentManager fm) {
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
        View view = inflater.inflate(R.layout.fragment_following, container, false);

        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rcFollowings);


        apiInterface = APIClient.getClient().create(APIInterface.class);

        Call<FollowsRetrofitModel> call = apiInterface.getFollowingsList(Globals.token, memberId);
        call.enqueue(new Callback<FollowsRetrofitModel>() {
            @Override
            public void onResponse(Call<FollowsRetrofitModel> call, Response<FollowsRetrofitModel> response) {


                followings = response.body().follows;
                WebServiceMessage message = response.body().message;
//                FollowingListRecyclerAdapter adapter = new FollowingListRecyclerAdapter(followings, getContext());
                FollowingListRecyclerAdapter adapter= new FollowingListRecyclerAdapter(followings, getContext(), pager,fragmentManager);

                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

            }

            @Override
            public void onFailure(Call<FollowsRetrofitModel> call, Throwable t) {

            }
        });


        FollowingListRecyclerAdapter adapter = new FollowingListRecyclerAdapter(new ArrayList<Follow>(), getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

}
