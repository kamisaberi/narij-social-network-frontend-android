package com.narij.narijsocialnetwork.adapter.recycler;

import android.content.Context;
import android.graphics.Typeface;
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
import com.narij.narijsocialnetwork.env.Globals;
import com.narij.narijsocialnetwork.model.base.Member;
import com.narij.narijsocialnetwork.retrofit.APIInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kami on 8/20/2017.
 */

public class LogSuggestionListRecyclerAdapter extends RecyclerView.Adapter<LogSuggestionListRecyclerAdapter.ViewHolder> {

    List<Member> suggestions = new ArrayList<>();
    Context context;

    APIInterface apiInterface;
    ViewPager pager;
    FragmentManager fragmentManager;

    public LogSuggestionListRecyclerAdapter (List<Member> suggestions, Context context) {
        this.suggestions = suggestions;
        this.context = context;
    }

    public LogSuggestionListRecyclerAdapter (List<Member> suggestions, Context context, ViewPager pager, FragmentManager fragmentManager) {
        this.suggestions = suggestions;
        this.context = context;
        this.fragmentManager = fragmentManager;
        this.pager = pager;
    }

    @Override
    public LogSuggestionListRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.recycler_followers_item, parent, false);

        // Return a new holder instance
        LogSuggestionListRecyclerAdapter.ViewHolder viewHolder = new LogSuggestionListRecyclerAdapter.ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(LogSuggestionListRecyclerAdapter.ViewHolder holder, int position) {
        Member suggestion = suggestions.get(position);
        // Set item views based on your views and data model
        ImageView imgProfile = holder.imgProfile;
        TextView txtName = holder.txtName;
        Button btnAccept = holder.btnAccept;
        txtName.setText(suggestion.getFullName());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgProfile;
        TextView txtName;
        Button btnAccept;

        public ViewHolder(View itemView) {
            super(itemView);

            imgProfile = (ImageView) itemView.findViewById(R.id.imgProfile);
            txtName = (TextView) itemView.findViewById(R.id.txtFullName);
            txtName.setTypeface(Globals.typeface, Typeface.NORMAL);
            btnAccept = (Button) itemView.findViewById(R.id.btnAccept);
            btnAccept.setTypeface(Globals.typeface, Typeface.NORMAL);
        }
    }

}
