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
import com.narij.narijsocialnetwork.model.base.Member;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kami on 8/20/2017.
 */

public class FriendListRecyclerAdapter extends  RecyclerView.Adapter<FriendListRecyclerAdapter.ViewHolder> {

    public List<Member> friends = new ArrayList<>();
    public Context context;


    public FriendListRecyclerAdapter(List<Member> friends, Context context) {
        this.friends = friends;
        this.context = context;
    }

    @Override
    public FriendListRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.recycler_friend_item, parent, false);

        // Return a new holder instance
        FriendListRecyclerAdapter.ViewHolder viewHolder = new FriendListRecyclerAdapter.ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FriendListRecyclerAdapter.ViewHolder holder, int position) {
        Member friend = friends.get(position);
        // Set item views based on your views and data model
        ImageView imgMenu = holder.imgMenu;
        ImageView imgProfile = holder.imgProfile;
        TextView txtName = holder.txtName;
        Button btnFollow = holder.btnFollow;
        txtName.setText(friend.getFullName());


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
        return friends.size();
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
