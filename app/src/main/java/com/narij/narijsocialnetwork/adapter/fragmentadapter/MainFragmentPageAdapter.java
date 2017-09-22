package com.narij.narijsocialnetwork.adapter.fragmentadapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Created by kami on 8/10/2017.
 */

public class MainFragmentPageAdapter extends FragmentPagerAdapter {


    public List<Fragment> mFragmentList = new ArrayList<>();
    public List<String> mFragmentTitleList = new ArrayList<>();


    final int PAGE_COUNT = 0;
    private Context context;

    public MainFragmentPageAdapter(FragmentManager fm, Context context, HashMap<String, Fragment> fragments) {
        super(fm);
//        if (fm.getFragments() != null) {
//            fm.getFragments().clear();
//        }
        this.context = context;

        List<Fragment> tfragments = fm.getFragments();
        if (tfragments  != null) {
            FragmentTransaction ft = fm.beginTransaction();
            for (Fragment f : tfragments) {
                ft.remove(f);
            }
//            ft.commitAllowingStateLoss();
            ft.commitNowAllowingStateLoss();
        }

        mFragmentList.clear();
        mFragmentTitleList.clear();
        Set<String> sets = fragments.keySet();
        for (String s : sets) {
            mFragmentTitleList.add(s);
            mFragmentList.add(fragments.get(s));
        }

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
