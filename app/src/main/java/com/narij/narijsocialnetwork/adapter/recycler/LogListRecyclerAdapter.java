package com.narij.narijsocialnetwork.adapter.recycler;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.narij.narijsocialnetwork.R;
import com.narij.narijsocialnetwork.adapter.fragmentadapter.MainFragmentPageAdapter;
import com.narij.narijsocialnetwork.fragment.ProfileFragment;
import com.narij.narijsocialnetwork.model.base.Log;
import com.narij.narijsocialnetwork.model.base.Member;
import com.narij.narijsocialnetwork.retrofit.APIClient;
import com.narij.narijsocialnetwork.retrofit.APIInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by kami on 8/20/2017.
 */

public class LogListRecyclerAdapter extends RecyclerView.Adapter<LogListRecyclerAdapter.ViewHolder> {

    List<Log> logs = new ArrayList<>();
    Context context;
    APIInterface apiInterface;
    ViewPager pager;
    FragmentManager fragmentManager;

    public LogListRecyclerAdapter(List<Log> logs, Context context) {
        this.logs = logs;
        this.context = context;
    }

    public LogListRecyclerAdapter(List<Log> logs, Context context, ViewPager pager, FragmentManager fragmentManager) {
        this.logs = logs;
        this.context = context;
        this.fragmentManager = fragmentManager;
        this.pager = pager;
    }

    @Override
    public LogListRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.recycler_log_item, parent, false);

        // Return a new holder instance
        LogListRecyclerAdapter.ViewHolder viewHolder = new LogListRecyclerAdapter.ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(LogListRecyclerAdapter.ViewHolder holder, int position) {
        Log log = logs.get(position);
        // Set item views based on your views and data model
        ImageView imgProfile = holder.imgProfile;
        TextView txtName = holder.txtName;

        txtName.setText(log.getContent());
        apiInterface = APIClient.getClient().create(APIInterface.class);
        imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HashMap<String, Fragment> fragmentHashMap;
                fragmentHashMap = new HashMap<>();
                fragmentHashMap.put("LOGS", new ProfileFragment(0));
                pager.setAdapter(new MainFragmentPageAdapter(fragmentManager, context, fragmentHashMap));

            }
        });

    }

    @Override
    public int getItemCount() {
        return logs.size();
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
