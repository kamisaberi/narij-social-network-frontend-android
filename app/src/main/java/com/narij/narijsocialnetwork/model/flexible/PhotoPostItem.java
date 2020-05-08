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
import com.squareup.picasso.Picasso;

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

public class PhotoPostItem extends AbstractSectionableItem<PhotoPostItem.ViewHolder, TimelineHeaderItem> {

    public Post post = new Post();

    APIInterface apiInterface;

    public PhotoPostItem(Post post, TimelineHeaderItem header) {
        super(header);
        this.header = header;
        this.post = post;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof PhotoPostItem) {
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
    public void bindViewHolder(FlexibleAdapter adapter, final ViewHolder holder, int position, List payloads) {

        Context context = holder.itemView.getContext();

        if (post.getFiles().size() > 0) {
            String url = Globals.BASE_URL + "uploads/" + post.getMember().getMemberId() + "/" + post.getPostId() + "/" + post.getFiles().get(0);
            Picasso.with(context).load(url).into(holder.imgPhoto);
        }


        holder.txtTitle.setText(post.getTitle());

        if (post.isLiked() == true) {
            holder.imgLike.setImageResource(R.drawable.like);
        } else {
            holder.imgLike.setImageResource(R.drawable.like_hint);
        }


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

//            imgLike.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (post.isLiked()) {
//                        imgLike.setImageResource(R.drawable.like_hint);
//                        post.setLiked(false);
//                        Log.d(Globals.LOG_TAG, "POST "+post.getPostId() + " UNLIKED");
//                    } else {
//                        imgLike.setImageResource(R.drawable.like);
//                        post.setLiked(true);
//                        Log.d(Globals.LOG_TAG, "POST "+post.getPostId() + " LIKED");
//                    }
//                }
//            });


            this.txtLikeNumber = (TextView) view.findViewById(R.id.txtLikeNumber);
            txtLikeNumber.setTypeface(Globals.typeface, Typeface.NORMAL);
            this.txtCommentNumber = (TextView) view.findViewById(R.id.txtCommentNumber);
            txtCommentNumber.setTypeface(Globals.typeface, Typeface.NORMAL);
            this.txtTitle = (TextView) view.findViewById(R.id.txtTitle);
            txtTitle.setTypeface(Globals.typeface, Typeface.NORMAL);
        }
    }

}
