package com.narij.narijsocialnetwork.adapter.recycler;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.narij.narijsocialnetwork.R;
import com.narij.narijsocialnetwork.adapter.fragmentadapter.MainFragmentPageAdapter;
import com.narij.narijsocialnetwork.env.Globals;
import com.narij.narijsocialnetwork.fragment.ProfileFragment;
import com.narij.narijsocialnetwork.library.CircleTransform;
import com.narij.narijsocialnetwork.model.base.Message;
import com.narij.narijsocialnetwork.retrofit.APIClient;
import com.narij.narijsocialnetwork.retrofit.APIInterface;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by kami on 8/20/2017.
 */

public class MessageListRecyclerAdapter extends RecyclerView.Adapter<MessageListRecyclerAdapter.ViewHolder> {


    List<Message> messages = new ArrayList<>();
    Context context;
    APIInterface apiInterface;

    ViewPager pager;
    FragmentManager fragmentManager;


    public MessageListRecyclerAdapter(List<Message> messages, Context context) {
        this.messages = messages;
        this.context = context;
    }

    public MessageListRecyclerAdapter(List<Message> messages, Context context, ViewPager pager, FragmentManager fragmentManager) {
        this.messages = messages;
        this.context = context;
        this.fragmentManager = fragmentManager;
        this.pager = pager;
    }


    @Override
    public MessageListRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.recycler_message_item, parent, false);
        // Return a new holder instance
        MessageListRecyclerAdapter.ViewHolder viewHolder = new MessageListRecyclerAdapter.ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MessageListRecyclerAdapter.ViewHolder holder, int position) {
        final Message message = messages.get(position);
        // Set item views based on your views and data model
        ImageView imgProfile = holder.imgProfile;
        TextView txtName = holder.txtName;
        txtName.setText(message.getMember().getFullName());

        String url = Globals.BASE_URL + "uploads/" + message.getMember().getMemberId() + "/Profile.jpg";
        Picasso.with(context).load(url).transform(new CircleTransform()).into(imgProfile);


        apiInterface = APIClient.getClient().create(APIInterface.class);
        imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HashMap<String, Fragment> fragmentHashMap;
                fragmentHashMap = new HashMap<>();
                Log.d(Globals.LOG_TAG, "MEMBER ID : " + message.getMember().getMemberId());
                fragmentHashMap.put("FOLLOWERS", new ProfileFragment(message.getMember().getMemberId(), pager,fragmentManager));
                Log.d(Globals.LOG_TAG, "MEMBER ID : " + message.getMember().getMemberId());
                pager.setAdapter(new MainFragmentPageAdapter(fragmentManager, context, fragmentHashMap));
                Log.d(Globals.LOG_TAG, "MEMBER ID : " + message.getMember().getMemberId());

            }
        });


    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        ImageView imgProfile;
        TextView txtName;


        public ViewHolder(View itemView) {
            super(itemView);
            imgProfile = (ImageView) itemView.findViewById(R.id.imgProfile);
            txtName = (TextView) itemView.findViewById(R.id.txtFullName);
            txtName.setTypeface(Globals.typeface, Typeface.NORMAL);
        }
    }

}
