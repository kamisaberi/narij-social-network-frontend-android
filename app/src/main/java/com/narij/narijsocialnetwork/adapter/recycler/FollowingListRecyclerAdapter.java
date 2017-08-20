package com.narij.narijsocialnetwork.adapter.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by kami on 8/20/2017.
 */

public class FollowingListRecyclerAdapter extends  RecyclerView.Adapter<FollowingListRecyclerAdapter.ViewHolder> {
    @Override
    public FollowingListRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(FollowingListRecyclerAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);


        }
    }

}
