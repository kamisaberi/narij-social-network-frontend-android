package com.narij.narijsocialnetwork.adapter.recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.narij.narijsocialnetwork.R;
import com.narij.narijsocialnetwork.model.base.Follow;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kami on 8/20/2017.
 */

public class FollowingListRecyclerAdapter extends RecyclerView.Adapter<FollowingListRecyclerAdapter.ViewHolder> {


    public List<Follow> followings = new ArrayList<>();
    public Context context;


    public FollowingListRecyclerAdapter(List<Follow> followings, Context context) {
        this.followings = followings;
        this.context = context;
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
    public void onBindViewHolder(FollowingListRecyclerAdapter.ViewHolder holder, int position) {

        Follow following = followings.get(position);
        // Set item views based on your views and data model
        ImageView imgMenu = holder.imgMenu;
        ImageView imgProfile = holder.imgProfile;
        TextView txtName = holder.txtName;
        Button btnFollow = holder.btnFollow;
        txtName.setText(following.getMember().getFullName());

        imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        btnFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
            txtName = (TextView) itemView.findViewById(R.id.txtName);
            btnFollow = (Button) itemView.findViewById(R.id.btnFollow);
        }
    }

}
