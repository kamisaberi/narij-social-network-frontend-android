package com.narij.narijsocialnetwork.adapter.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.narij.narijsocialnetwork.fragment.NewDocumentFragment;
import com.narij.narijsocialnetwork.fragment.SearchFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kami on 8/6/2017.
 */

public class SearchFragmentPageAdapter extends FragmentPagerAdapter {


    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    final int PAGE_COUNT = 2;
    private Context context;

    public SearchFragmentPageAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        mFragmentList.add(new SearchFragment());
        mFragmentList.add(new SearchFragment());
        mFragmentList.add(new SearchFragment());
        mFragmentList.add(new SearchFragment());
        mFragmentList.add(new SearchFragment());
        mFragmentTitleList.add("New");
        mFragmentTitleList.add("Video");
        mFragmentTitleList.add("Photo");
        mFragmentTitleList.add("Article");
        mFragmentTitleList.add("voice");

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
        return mFragmentTitleList.get(position) + "";
    }
}
