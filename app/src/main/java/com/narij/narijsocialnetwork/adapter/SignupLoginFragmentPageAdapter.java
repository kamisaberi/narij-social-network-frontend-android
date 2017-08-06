package com.narij.narijsocialnetwork.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.narij.narijsocialnetwork.fragment.LoginFragment;
import com.narij.narijsocialnetwork.fragment.SignupFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kami on 8/6/2017.
 */

public class SignupLoginFragmentPageAdapter extends FragmentPagerAdapter {


    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    final int PAGE_COUNT = 2;
    private String tabTitles[] = new String[]{"Sign up", "Login"};
    private Context context;

    public SignupLoginFragmentPageAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        mFragmentList.add(new LoginFragment());
        mFragmentList.add(new SignupFragment());
        mFragmentTitleList.add("Login");
        mFragmentTitleList.add("signUp");

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
