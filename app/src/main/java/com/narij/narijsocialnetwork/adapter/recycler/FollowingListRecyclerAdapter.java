package com.narij.narijsocialnetwork.adapter.recycler;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.narij.narijsocialnetwork.R;
import com.narij.narijsocialnetwork.adapter.fragmentadapter.MainFragmentPageAdapter;
import com.narij.narijsocialnetwork.env.Globals;
import com.narij.narijsocialnetwork.fragment.ProfileFragment;
import com.narij.narijsocialnetwork.model.base.Follow;
import com.narij.narijsocialnetwork.model.retrofit.WebServiceMessage;
import com.narij.narijsocialnetwork.retrofit.APIClient;
import com.narij.narijsocialnetwork.retrofit.APIInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by kami on 8/20/2017.
 */

public class FollowingListRecyclerAdapter extends RecyclerView.Adapter<FollowingListRecyclerAdapter.ViewHolder> {


    public List<Follow> followings = new ArrayList<>();
    public Context context;


    APIInterface apiInterface;

    ViewPager pager;
    FragmentManager fragmentManager;


    public FollowingListRecyclerAdapter(List<Follow> followings, Context context) {
        this.followings = followings;
        this.context = context;
    }

    public FollowingListRecyclerAdapter(List<Follow> followers, Context context, ViewPager pager, FragmentManager fragmentManager) {
        this.followings = followers;
        this.context = context;
        this.fragmentManager = fragmentManager;
        this.pager = pager;
    }


    @Override
    public FollowingListRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.recycler_following_item, parent, false);

        // Return a new holder instance
        FollowingListRecyclerAdapter.ViewHolder viewHolder = new FollowingListRecyclerAdapter.ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FollowingListRecyclerAdapter.ViewHolder holder, final int position) {

        Follow following = followings.get(position);
        // Set item views based on your views and data model
        ImageView imgMenu = holder.imgMenu;
        ImageView imgProfile = holder.imgProfile;
        TextView txtName = holder.txtName;
        final Button btnFollow = holder.btnFollow;
        txtName.setText(following.getMember().getFullName());

        apiInterface = APIClient.getClient().create(APIInterface.class);

        imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HashMap<String, Fragment> fragmentHashMap;
                fragmentHashMap = new HashMap<>();
                fragmentHashMap.put("FOLLOWERS", new ProfileFragment(0));
                pager.setAdapter(new MainFragmentPageAdapter(fragmentManager, context, fragmentHashMap));


            }
        });

        btnFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Call<WebServiceMessage> call = apiInterface.follow(Globals.token, followings.get(position).getMember().getMemberId());
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
        });


    }

    @Override
    public int getItemCount() {
        return followings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgMenu;
        ImageView imgProfile;
        Button btnFollow;
        TextView txtName;

        public ViewHolder(View itemView) {
            super(itemView);
            imgMenu = (ImageView) itemView.findViewById(R.id.imgMenu);
            imgProfile = (ImageView) itemView.findViewById(R.id.imgProfile);
            txtName = (TextView) itemView.findViewById(R.id.txtFullName);
            txtName.setTypeface(Globals.typeface, Typeface.NORMAL);
            btnFollow = (Button) itemView.findViewById(R.id.btnFollow);
            btnFollow.setTypeface(Globals.typeface, Typeface.NORMAL);
        }
    }

}
