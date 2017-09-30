package com.narij.narijsocialnetwork.model.flexible;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.narij.narijsocialnetwork.R;

import java.util.List;

import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.AbstractHeaderItem;
import eu.davidea.flipview.FlipView;
import eu.davidea.viewholders.FlexibleViewHolder;

/**
 * Created by kami on 9/30/2017.
 */

public class TimelineHeaderItem extends AbstractHeaderItem<TimelineHeaderItem.HeaderViewHolder> {


    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int getLayoutRes() {
        return 0;
    }

    @Override
    public HeaderViewHolder createViewHolder(View view, FlexibleAdapter adapter) {
        return null;
    }

    @Override
    public void bindViewHolder(FlexibleAdapter adapter, HeaderViewHolder holder, int position, List payloads) {

    }




    static class HeaderViewHolder extends FlexibleViewHolder {

        FlipView mAccountImage;
        TextView mTitle;
        TextView mSubtitle;

        public HeaderViewHolder(View view, FlexibleAdapter adapter) {
            super(view, adapter, true);//True for sticky
            mAccountImage = (FlipView) view.findViewById(R.id.instagram_account_image);
            mAccountImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("InstagramHeaderItem", "Registered internal click on Header AccountImageView!" + " position=" + getFlexibleAdapterPosition());
                }
            });
            mTitle = (TextView) view.findViewById(R.id.instagram_account_title);
            mSubtitle = (TextView) view.findViewById(R.id.instagram_place_subtitle);
            mSubtitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("InstagramHeaderItem", "Registered internal click on Header SubTitleTextView! " + mSubtitle.getText() + " position=" + getFlexibleAdapterPosition());
                }
            });
        }
    }

}
