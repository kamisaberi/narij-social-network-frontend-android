package com.narij.narijsocialnetwork.adapter.fragmentadapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.narij.narijsocialnetwork.fragment.ViralAllFragment;
import com.narij.narijsocialnetwork.fragment.ViralArticlesFragment;
import com.narij.narijsocialnetwork.fragment.ViralAudiosFragment;
import com.narij.narijsocialnetwork.fragment.ViralPhotosFragment;
import com.narij.narijsocialnetwork.fragment.ViralVideosFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kami on 8/10/2017.
 */

public class ViralFragmentPageAdapter extends FragmentPagerAdapter {

    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();


    private Context context;


    public ViralFragmentPageAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        mFragmentList.add(new ViralAllFragment());
        mFragmentList.add(new ViralVideosFragment());
        mFragmentList.add(new ViralPhotosFragment());
        mFragmentList.add(new ViralArticlesFragment());
        mFragmentList.add(new ViralAudiosFragment());

        mFragmentTitleList.add("All");
        mFragmentTitleList.add("video");
        mFragmentTitleList.add("Photo");
        mFragmentTitleList.add("Article");
        mFragmentTitleList.add("Voice");

    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }
}
