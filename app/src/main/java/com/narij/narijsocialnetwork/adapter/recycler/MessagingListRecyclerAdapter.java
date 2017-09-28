package com.narij.narijsocialnetwork.adapter.recycler;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.narij.narijsocialnetwork.R;
import com.narij.narijsocialnetwork.model.base.Message;
import com.narij.narijsocialnetwork.retrofit.APIClient;
import com.narij.narijsocialnetwork.retrofit.APIInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kami on 8/20/2017.
 */

public class MessagingListRecyclerAdapter extends RecyclerView.Adapter<MessagingListRecyclerAdapter.ViewHolder> {


    List<Message> messages = new ArrayList<>();
    Context context;
    APIInterface apiInterface;

    ViewPager pager;
    FragmentManager fragmentManager;


    public MessagingListRecyclerAdapter(List<Message> messages, Context context) {
        this.messages= messages;
        this.context = context;
    }

    public MessagingListRecyclerAdapter(List<Message> messages, Context context, ViewPager pager, FragmentManager fragmentManager) {
        this.messages= messages;
        this.context = context;
        this.fragmentManager = fragmentManager;
        this.pager = pager;
    }


    @Override
    public MessagingListRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.recycler_message_item, parent, false);
        // Return a new holder instance
        MessagingListRecyclerAdapter.ViewHolder viewHolder = new MessagingListRecyclerAdapter.ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MessagingListRecyclerAdapter.ViewHolder holder, int position) {
        Message message = messages.get(position);
        // Set item views based on your views and data model
        ImageView imgProfile = holder.imgProfile;
        TextView txtName = holder.txtName;
        txtName.setText(message.getMember().getFullName());

        apiInterface = APIClient.getClient().create(APIInterface.class);
        imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                HashMap<String, Fragment> fragmentHashMap;
//                fragmentHashMap = new HashMap<>();
//                fragmentHashMap.put("FOLLOWERS", new ProfileFragment(0));
//                pager.setAdapter(new MainFragmentPageAdapter(fragmentManager, context, fragmentHashMap));

            }
        });






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
