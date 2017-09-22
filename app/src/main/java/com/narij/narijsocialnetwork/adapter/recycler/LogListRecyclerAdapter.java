package com.narij.narijsocialnetwork.adapter.recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.narij.narijsocialnetwork.R;
import com.narij.narijsocialnetwork.model.base.Member;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kami on 8/20/2017.
 */

public class LogListRecyclerAdapter extends RecyclerView.Adapter<LogListRecyclerAdapter.ViewHolder> {

    List<Member> logs = new ArrayList<>();
    Context context;

    public LogListRecyclerAdapter(List<Member> logs, Context context) {
        this.logs = logs;
        this.context = context;
    }

    @Override
    public LogListRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.recycler_followers_item, parent, false);

        // Return a new holder instance
        LogListRecyclerAdapter.ViewHolder viewHolder = new LogListRecyclerAdapter.ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(LogListRecyclerAdapter.ViewHolder holder, int position) {
        Member log = logs.get(position);
        // Set item views based on your views and data model
        ImageView imgProfiel = holder.imgProfile;
        TextView txtName = holder.txtName;

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgProfile;
        TextView txtName;

        public ViewHolder(View itemView) {
            super(itemView);

            imgProfile = (ImageView) itemView.findViewById(R.id.imgProfile);
            txtName = (TextView) itemView.findViewById(R.id.txtName);
        }
    }

}
