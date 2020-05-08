package com.narij.narijsocialnetwork.model.flexible;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.narij.narijsocialnetwork.R;
import com.narij.narijsocialnetwork.env.Globals;
import com.narij.narijsocialnetwork.model.base.Post;
import com.narij.narijsocialnetwork.model.retrofit.WebServiceMessage;
import com.narij.narijsocialnetwork.retrofit.APIClient;
import com.narij.narijsocialnetwork.retrofit.APIInterface;

import java.util.List;

import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.AbstractSectionableItem;
import eu.davidea.viewholders.FlexibleViewHolder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by kami on 9/30/2017.
 */

public class TextPostItem extends AbstractSectionableItem<TextPostItem.ViewHolder, TimelineHeaderItem> {

    public Post post = new Post();
    APIInterface apiInterface;

    public TextPostItem(Post post, TimelineHeaderItem header) {
        super(header);
        this.header = header;
        this.post = post;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof TextPostItem) {
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
    public void bindViewHolder(FlexibleAdapter adapter, final ViewHolder holder, int position, List payloads) {
        Context context = holder.itemView.getContext();

        if (post.isLiked() == true) {
            holder.imgLike.setImageResource(R.drawable.like);
        } else {
            holder.imgLike.setImageResource(R.drawable.like_hint);
        }

        holder.txtTitle.setText(post.getTitle());

        apiInterface = APIClient.getClient().create(APIInterface.class);
        holder.imgLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int value;
                value = post.isLiked() == false ? 1 : 0;




                Call<WebServiceMessage> call = apiInterface.like(
                        Globals.token,
                        post.getPostId(),
                        value,
                        System.currentTimeMillis()
                );
                call.enqueue(new Callback<WebServiceMessage>() {
                    @Override
                    public void onResponse(Call<WebServiceMessage> call, Response<WebServiceMessage> response) {
                        WebServiceMessage webServiceMessage = response.body();
                        if (webServiceMessage.isError() == false) {
                            if (post.isLiked()) {
                                holder.imgLike.setImageResource(R.drawable.like_hint);
                                post.setLiked(false);
//                                Log.d(Globals.LOG_TAG, "POST " + post.getPostId() + " UNLIKED");
                                Log.d(Globals.LOG_TAG, webServiceMessage.getMessage());
                            } else {
                                holder.imgLike.setImageResource(R.drawable.like);
                                post.setLiked(true);
//                                Log.d(Globals.LOG_TAG, "POST " + post.getPostId() + " LIKED");
                                Log.d(Globals.LOG_TAG, webServiceMessage.getMessage());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<WebServiceMessage> call, Throwable t) {

                    }
                });
            }
        });


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
            txtLikeNumber.setTypeface(Globals.typeface, Typeface.NORMAL);
            this.txtCommentNumber = (TextView) view.findViewById(R.id.txtCommentNumber);
            txtCommentNumber.setTypeface(Globals.typeface, Typeface.NORMAL);
            this.txtTitle = (TextView) view.findViewById(R.id.txtTitle);
            txtTitle.setTypeface(Globals.typeface, Typeface.NORMAL);
        }
    }

}
