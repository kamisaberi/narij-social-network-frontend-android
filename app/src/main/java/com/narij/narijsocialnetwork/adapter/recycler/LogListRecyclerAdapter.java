package com.narij.narijsocialnetwork.adapter.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.narij.narijsocialnetwork.activity.LoginSignupActivity;

/**
 * Created by kami on 8/20/2017.
 */

public class LogListRecyclerAdapter extends  RecyclerView.Adapter<LogListRecyclerAdapter.ViewHolder> {

    @Override
    public LogListRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(LogListRecyclerAdapter.ViewHolder holder, int position) {

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
