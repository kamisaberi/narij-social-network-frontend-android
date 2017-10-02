package com.narij.narijsocialnetwork.model.flexible;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.narij.narijsocialnetwork.R;
import com.narij.narijsocialnetwork.flexibleadapter.items.InstagramItem;
import com.narij.narijsocialnetwork.model.base.Post;

import java.util.List;

import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.AbstractSectionableItem;
import eu.davidea.viewholders.FlexibleViewHolder;

/**
 * Created by kami on 9/30/2017.
 */

public class PhotoPostItem extends AbstractSectionableItem<PhotoPostItem.ViewHolder, TimelineHeaderItem> {

    public Post post = new Post();


    public PhotoPostItem(Post post, TimelineHeaderItem header) {
        super(header);
        this.header = header;
        this.post = post;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof InstagramItem) {
            PhotoPostItem item = (PhotoPostItem) o;
            return this.post.getPostId() == (item.post.getPostId());
        }
        return false;
    }

    @Override
    public int getLayoutRes() {

        return R.layout.recycler_timeline_photo_item;
    }

    @Override
    public ViewHolder createViewHolder(View view, FlexibleAdapter adapter) {
        return new ViewHolder(view, adapter);
    }

    @Override
    public void bindViewHolder(FlexibleAdapter adapter, ViewHolder holder, int position, List payloads) {

        Context context = holder.itemView.getContext();

        //Load image via Glide
        //Glide.clear(holder.mImage);
        //Glide.with(context).load(url).crossFade(500).into(holder.mImage);

    }

    static final class ViewHolder extends FlexibleViewHolder {

        ImageView imgPhoto;
        ImageView imgLike;
        TextView txtLikeNumber;
        TextView txtCommentNumber;
        TextView txtTitle;

        public ViewHolder(View view, FlexibleAdapter adapter) {
            super(view, adapter);
            this.imgPhoto = (ImageView) view.findViewById(R.id.imgPhoto);
            this.imgLike = (ImageView) view.findViewById(R.id.imgLike);
            this.txtLikeNumber = (TextView) view.findViewById(R.id.txtLikeNumber);
            this.txtCommentNumber = (TextView) view.findViewById(R.id.txtCommentNumber);
            this.txtTitle = (TextView) view.findViewById(R.id.txtTitle);
        }
    }

}
