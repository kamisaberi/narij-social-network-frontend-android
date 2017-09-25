package com.narij.narijsocialnetwork.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.narij.narijsocialnetwork.R;
import com.narij.narijsocialnetwork.activity.MainActivity;
import com.narij.narijsocialnetwork.activity.ProfileActivity;
import com.narij.narijsocialnetwork.adapter.fragmentadapter.MainFragmentPageAdapter;
import com.narij.narijsocialnetwork.env.Globals;
import com.narij.narijsocialnetwork.model.base.Member;
import com.narij.narijsocialnetwork.model.retrofit.MemberRetrofitModel;
import com.narij.narijsocialnetwork.model.retrofit.WebServiceMessage;
import com.narij.narijsocialnetwork.retrofit.APIClient;
import com.narij.narijsocialnetwork.retrofit.APIInterface;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    private long memberId;

    ImageView imgProfile;
    TextView txtName;
    TextView txtNumberOfPosts;
    TextView txtNumberOfFollowings;
    TextView txtNumberOfFollowers;
    Button btnFollow;

    APIInterface apiInterface;

    ViewPager pager;
    FragmentManager fragmentManager;

    public ProfileFragment(long memberId) {
        this.memberId = memberId;
        // Required empty public constructor
    }

    public ProfileFragment(long memberId, ViewPager pager, FragmentManager fragmentManager) {
        this.memberId = memberId;
        this.pager = pager;
        this.fragmentManager = fragmentManager;

        Globals.stackedFragments.add(this);
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);


        imgProfile = (ImageView) view.findViewById(R.id.imgProfile);
        txtName = (TextView) view.findViewById(R.id.txtName);
        txtNumberOfFollowers = (TextView) view.findViewById(R.id.txtNumberOfFollowers);
        txtNumberOfFollowings = (TextView) view.findViewById(R.id.txtNumberOfFollowings);
        txtNumberOfPosts = (TextView) view.findViewById(R.id.txtNumberOfPosts);
        btnFollow = (Button) view.findViewById(R.id.btnFollow);

        if (memberId == 0)
            btnFollow.setText("Edit Profile");
        else
            btnFollow.setText("Follow");

        apiInterface = APIClient.getClient().create(APIInterface.class);


        if (memberId > 0) {
            Call<MemberRetrofitModel> call = apiInterface.getMemberDetails(Globals.token, memberId);
            call.enqueue(new Callback<MemberRetrofitModel>() {
                @Override
                public void onResponse(Call<MemberRetrofitModel> call, Response<MemberRetrofitModel> response) {

                    MemberRetrofitModel model = response.body();
                    Member member = model.member;
                    WebServiceMessage message = model.message;

                    txtName.setText(member.getFullName());
                    txtNumberOfFollowers.setText(member.getFollowings().size() + "");
                    txtNumberOfFollowings.setText(member.getFollowers().size() + "");
                    txtNumberOfPosts.setText(member.getPosts().size() + "");


                }

                @Override
                public void onFailure(Call<MemberRetrofitModel> call, Throwable t) {

                }
            });
        } else {

            txtName.setText(Globals.loggedInData.member.getFullName());
            txtNumberOfFollowers.setText(Globals.loggedInData.member.getFollowings().size() + "");
            txtNumberOfFollowings.setText(Globals.loggedInData.member.getFollowers().size() + "");
            txtNumberOfPosts.setText(Globals.loggedInData.member.getPosts().size() + "");
        }


        btnFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (memberId == 0) {

                    Intent intent = new Intent(getContext(), ProfileActivity.class);
                    startActivity(intent);

                } else {

                    Call<WebServiceMessage> call = apiInterface.follow(Globals.token, memberId);
                    call.enqueue(new Callback<WebServiceMessage>() {
                        @Override
                        public void onResponse(Call<WebServiceMessage> call, Response<WebServiceMessage> response) {
                            WebServiceMessage message = response.body();
                            if (message.isError())
                                return;

                            if (message.getMessage().equals("followed")) {
                                btnFollow.setText("unFollow");

                            } else if (message.getMessage().equals("unFollowed")) {
                                btnFollow.setText("Follow");
                            }
                        }

                        @Override
                        public void onFailure(Call<WebServiceMessage> call, Throwable t) {

                        }
                    });
                }
            }
        });


        txtNumberOfFollowings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HashMap<String, Fragment> fragmentHashMap = new HashMap<>();
                fragmentHashMap.put("FOLLOWINGS", new FollowingFragment(memberId, pager, fragmentManager));
                pager.setAdapter(new MainFragmentPageAdapter(fragmentManager, getContext(), fragmentHashMap));
                //pager.getAdapter().notifyDataSetChanged();

            }
        });


        txtNumberOfFollowers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, Fragment> fragmentHashMap = new HashMap<>();
                fragmentHashMap.put("FOLLOWERS", new FollowersFragment(memberId, pager, fragmentManager));
                pager.setAdapter(new MainFragmentPageAdapter(fragmentManager, getContext(), fragmentHashMap));
            }
        });







        return view;
    }


}
