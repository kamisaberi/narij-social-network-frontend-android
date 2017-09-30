package com.narij.narijsocialnetwork.model.flexible;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.narij.narijsocialnetwork.R;
import com.narij.narijsocialnetwork.flexibleadapter.items.InstagramItem;
import com.narij.narijsocialnetwork.model.base.Post;

import java.util.List;

import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.AbstractSectionableItem;
import eu.davidea.flipview.FlipView;
import eu.davidea.viewholders.FlexibleViewHolder;

/**
 * Created by kami on 9/30/2017.
 */

public class VideoPostItem extends AbstractSectionableItem<VideoPostItem.ViewHolder, TimelineHeaderItem> {

    public Post post = new Post();


    public VideoPostItem(Post post, TimelineHeaderItem header) {
        super(header);
        this.header = header;
        this.post = post;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof InstagramItem) {
            VideoPostItem item = (VideoPostItem) o;
            return this.post.getPostId() == (item.post.getPostId());
        }
        return false;
    }

    @Override
    public int getLayoutRes() {

        return R.layout.recycler_timeline_video_item;
    }

    @Override
    public ViewHolder createViewHolder(View view, FlexibleAdapter adapter) {
        return null;
    }

    @Override
    public void bindViewHolder(FlexibleAdapter adapter, ViewHolder holder, int position, List payloads) {

    }

    static final class ViewHolder extends FlexibleViewHolder {

        ImageView mImage;
        FlipView mImageFavourite;
        ImageView mImageComment;
        ImageView mImageShare;
        TextView mQuantityLikes;

        public ViewHolder(View view, FlexibleAdapter adapter) {
            super(view, adapter);
            this.mImage = (ImageView) view.findViewById(R.id.instagram_image);
            this.mImageFavourite = (FlipView) view.findViewById(R.id.instagram_image_like);
            this.mImageComment = (ImageView) view.findViewById(R.id.instagram_image_comment);
            this.mImageShare = (ImageView) view.findViewById(R.id.instagram_image_share);
            this.mQuantityLikes = (TextView) view.findViewById(R.id.instagram_quantity_likes);
        }
    }

}
