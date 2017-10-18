package com.narij.narijsocialnetwork.model.flexible;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.narij.narijsocialnetwork.R;
import com.narij.narijsocialnetwork.env.Globals;
import com.narij.narijsocialnetwork.library.CircleTransform;
import com.narij.narijsocialnetwork.model.base.Post;
import com.squareup.picasso.Picasso;

import java.util.List;

import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.AbstractHeaderItem;
import eu.davidea.viewholders.FlexibleViewHolder;

/**
 * Created by kami on 9/30/2017.
 */

public class TimelineHeaderItem extends AbstractHeaderItem<TimelineHeaderItem.HeaderViewHolder> {


    private String id;
    private Post post;

    private Context context;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public TimelineHeaderItem(String id, Post post, Context context) {
        super();
        this.id = id;
        this.post = post;
        this.context = context;
    }


    @Override
    public boolean equals(Object o) {
        if (o instanceof TimelineHeaderItem) {
            TimelineHeaderItem inItem = (TimelineHeaderItem) o;
            return this.getId().equals(inItem.getId());
        }
        return false;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.recycler_timeline_sticky_header_item;
    }

    @Override
    public HeaderViewHolder createViewHolder(View view, FlexibleAdapter adapter) {
        return new TimelineHeaderItem.HeaderViewHolder(view, adapter);
    }

    @Override
    public void bindViewHolder(FlexibleAdapter adapter, HeaderViewHolder holder, int position, List payloads) {


        holder.txtTitle.setText("This Is a Test");
        //holder.txtDate.setText(post.getCreateTime()+"");
        holder.txtFullName.setText(post.getMember().getFullName());

        String url =  Globals.BASE_URL + "uploads/"  + post.getMember().getMemberId() + "/Profile.jpg";
        Picasso.with(context).load(url).transform(new CircleTransform()).into(holder.imgProfile);

        //holder.mTitle.setText(getTitle());
        //holder.mSubtitle.setText(getSubtitle());

    }

    static class HeaderViewHolder extends FlexibleViewHolder {

        TextView txtTitle;
        TextView txtFullName;
        TextView txtDate;
        ImageView imgProfile;
        ImageView imgMenu;
        ImageView imgShare;

        public HeaderViewHolder(View view, FlexibleAdapter adapter) {
            super(view, adapter, true);//True for sticky

            txtTitle = (TextView) view.findViewById(R.id.txtTitle);
            txtTitle.setTypeface(Globals.typeface, Typeface.NORMAL);
            txtFullName = (TextView) view.findViewById(R.id.txtFullName);
            txtFullName.setTypeface(Globals.typeface, Typeface.NORMAL);
            txtDate = (TextView) view.findViewById(R.id.txtDate);
            txtDate.setTypeface(Globals.typeface, Typeface.NORMAL);
            imgProfile = (ImageView) view.findViewById(R.id.imgProfile);
            imgMenu = (ImageView) view.findViewById(R.id.imgMenu);
            imgShare = (ImageView) view.findViewById(R.id.imgShare);

//            mAccountImage = (FlipView) view.findViewById(R.id.instagram_account_image);
//            mAccountImage.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Log.d("InstagramHeaderItem", "Registered internal click on Header AccountImageView!" + " position=" + getFlexibleAdapterPosition());
//                }
//            });
//            mTitle = (TextView) view.findViewById(R.id.instagram_account_title);
//            mSubtitle = (TextView) view.findViewById(R.id.instagram_place_subtitle);
//            mSubtitle.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Log.d("InstagramHeaderItem", "Registered internal click on Header SubTitleTextView! " + mSubtitle.getText() + " position=" + getFlexibleAdapterPosition());
//                }
//            });
        }
    }

}
