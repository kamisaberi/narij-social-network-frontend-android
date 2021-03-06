package com.narij.narijsocialnetwork.adapter.fragmentadapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.narij.narijsocialnetwork.fragment.NewDocumentFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kami on 8/6/2017.
 */

public class NewFragmentPageAdapter extends FragmentPagerAdapter {


    public  final List<Fragment> mFragmentList = new ArrayList<>();
    public  final List<String> mFragmentTitleList = new ArrayList<>();



    final int PAGE_COUNT = 0;
    private Context context;

    public NewFragmentPageAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        mFragmentList.add(new NewDocumentFragment());
        mFragmentTitleList.add("New");

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
