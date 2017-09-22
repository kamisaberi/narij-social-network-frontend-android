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

public class FollowerListRecyclerAdapter extends RecyclerView.Adapter<FollowerListRecyclerAdapter.ViewHolder> {

    public List<Follow> followers = new ArrayList<>();
    public Context context;


    public FollowerListRecyclerAdapter(List<Follow> followers, Context context) {
        this.followers = followers;
        this.context = context;
    }

    @Override
    public FollowerListRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.recycler_followers_item, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FollowerListRecyclerAdapter.ViewHolder holder, int position) {
        // Get the data model based on position
        Follow follower = followers.get(position);
        // Set item views based on your views and data model
        ImageView imgMenu = holder.imgMenu;
        ImageView imgProfile = holder.imgProfile;
        TextView txtName = holder.txtName;
        Button btnFollow = holder.btnFollow;
        txtName.setText(follower.getMember().getFullName());


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
        return followers.size();
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
