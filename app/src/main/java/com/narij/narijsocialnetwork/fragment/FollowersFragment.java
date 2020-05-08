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
public class FollowersFragment extends Fragment {

    APIInterface apiInterface;
    private long memberId;

    ViewPager pager;
    FragmentManager fragmentManager;

    public ArrayList<Follow> followers = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @SuppressLint("ValidFragment")
    public FollowersFragment(long memberId) {
        this.memberId = memberId;
        Globals.stackedFragments.add(this);
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public FollowersFragment(long memberId, ViewPager pager, FragmentManager fm) {
        this.memberId = memberId;
        this.pager = pager;
        this.fragmentManager = fm;

        Globals.stackedFragments.add(this);
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_followers, container, false);
        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rcFollowers);

        apiInterface = APIClient.getClient().create(APIInterface.class);
        Log.d(Globals.LOG_TAG, "f s m : " + memberId);
        Log.d(Globals.LOG_TAG, Globals.token);
        Call<FollowsRetrofitModel> call = apiInterface.getFollowersList(
                Globals.token,
                memberId,
                System.currentTimeMillis()
        );

        try {
            call.enqueue(new Callback<FollowsRetrofitModel>() {
                @Override
                public void onResponse(Call<FollowsRetrofitModel> call, Response<FollowsRetrofitModel> response) {

                    followers = response.body().follows;


                    Log.d(Globals.LOG_TAG, "f s :" + followers.size());
                    WebServiceMessage message = response.body().message;
                    Log.d(Globals.LOG_TAG, message.getMessage());
                    FollowerListRecyclerAdapter adapter = new FollowerListRecyclerAdapter(followers, getContext(), pager, fragmentManager);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

//                    for (Follow follow : followers) {
//                        Log.d(Globals.LOG_TAG, follow.getMember().getMemberId() + " " + follow.getMember().getFullName() + " " + follow.getMember().getEmail());
//                    }

                    //Log.d(Globals.LOG_TAG, "FOLLOWERS SIZE : " + followers.size());
                }

                @Override
                public void onFailure(Call<FollowsRetrofitModel> call, Throwable t) {
                    Log.d(Globals.LOG_TAG, t.getMessage());
                }
            });
        } catch (Exception e) {
            Log.d(Globals.LOG_TAG, e.getMessage());
        }


        return view;
    }

}
