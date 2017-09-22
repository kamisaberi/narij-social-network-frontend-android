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

public class FriendSuggestionListRecyclerAdapter extends RecyclerView.Adapter<FriendSuggestionListRecyclerAdapter.ViewHolder> {

    public List<Member> suggestions = new ArrayList<>();
    public Context context;

    public FriendSuggestionListRecyclerAdapter(List<Member> suggestions, Context context) {
        this.suggestions = suggestions;
        this.context = context;
    }

    @Override
    public FriendSuggestionListRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.recycler_friend_suggestion_horizontal_item, parent, false);

        // Return a new holder instance
        FriendSuggestionListRecyclerAdapter.ViewHolder viewHolder = new FriendSuggestionListRecyclerAdapter.ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FriendSuggestionListRecyclerAdapter.ViewHolder holder, int position) {

        Member suggestion = suggestions.get(position);
        ImageView imgProfiel = holder.imgProfile;
        TextView txtName = holder.txtName;
        Button btnFollow = holder.btnFollow;
        txtName.setText(suggestion.getFullName());

    }

    @Override
    public int getItemCount() {
        return suggestions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        ImageView imgProfile;
        TextView txtName;
        Button btnFollow;

        public ViewHolder(View itemView) {
            super(itemView);

            imgProfile = (ImageView) itemView.findViewById(R.id.imgProfile);
            txtName = (TextView) itemView.findViewById(R.id.txtName);
            btnFollow = (Button) itemView.findViewById(R.id.btnFollow);

        }
    }


}
