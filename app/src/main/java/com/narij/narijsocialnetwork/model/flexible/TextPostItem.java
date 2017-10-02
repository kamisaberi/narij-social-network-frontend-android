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
import eu.davidea.flipview.FlipView;
import eu.davidea.viewholders.FlexibleViewHolder;

/**
 * Created by kami on 9/30/2017.
 */

public class TextPostItem extends AbstractSectionableItem<TextPostItem.ViewHolder, TimelineHeaderItem> {

    public Post post = new Post();


    public TextPostItem(Post post, TimelineHeaderItem header) {
        super(header);
        this.header = header;
        this.post = post;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof InstagramItem) {
            TextPostItem item = (TextPostItem) o;
            return this.post.getPostId() == (item.post.getPostId());
        }
        return false;
    }

    @Override
    public int getLayoutRes() {

        return R.layout.recycler_timeline_text_item;
    }

    @Override
    public ViewHolder createViewHolder(View view, FlexibleAdapter adapter) {
        return new TextPostItem.ViewHolder(view, adapter);

    }

    @Override
    public void bindViewHolder(FlexibleAdapter adapter, ViewHolder holder, int position, List payloads) {
        Context context = holder.itemView.getContext();


    }

    static final class ViewHolder extends FlexibleViewHolder {

        ImageView imgLike;
        TextView txtLikeNumber;
        TextView txtCommentNumber;
        TextView txtTitle;

        public ViewHolder(View view, FlexibleAdapter adapter) {
            super(view, adapter);
            this.imgLike = (ImageView) view.findViewById(R.id.imgLike);
            this.txtLikeNumber = (TextView) view.findViewById(R.id.txtLikeNumber);
            this.txtCommentNumber = (TextView) view.findViewById(R.id.txtCommentNumber);
            this.txtTitle = (TextView) view.findViewById(R.id.txtTitle);
        }
    }

}
