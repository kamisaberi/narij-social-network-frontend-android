package com.narij.narijsocialnetwork.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.narij.narijsocialnetwork.R;
import com.narij.narijsocialnetwork.adapter.fragmentadapter.MainFragmentPageAdapter;
import com.narij.narijsocialnetwork.env.Globals;
import com.narij.narijsocialnetwork.flexibleadapter.fragments.FragmentInstagramHeaders;
import com.narij.narijsocialnetwork.fragment.FindFriendsFragment;
import com.narij.narijsocialnetwork.fragment.FollowersFragment;
import com.narij.narijsocialnetwork.fragment.FollowingFragment;
import com.narij.narijsocialnetwork.fragment.LogsFragment;
import com.narij.narijsocialnetwork.fragment.MessagesFragment;
import com.narij.narijsocialnetwork.fragment.NewDocumentFragment;
import com.narij.narijsocialnetwork.fragment.ProfileFragment;
import com.narij.narijsocialnetwork.fragment.ViralAllFragment;
import com.narij.narijsocialnetwork.fragment.ViralArticlesFragment;
import com.narij.narijsocialnetwork.fragment.ViralAudiosFragment;
import com.narij.narijsocialnetwork.fragment.ViralPhotosFragment;
import com.narij.narijsocialnetwork.fragment.ViralVideosFragment;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {


    // TESTSTSTSTSTSTTST

    TabLayout bottombar;

    HashMap<String, Fragment> fragmentHashMap;

    TabLayout tabLayout;
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        pager = (ViewPager) findViewById(R.id.pager);
        //pager.setOffscreenPageLimit(0);


        fragmentHashMap = new HashMap<>();
        fragmentHashMap.put("Timeline", FragmentInstagramHeaders.newInstance());
        pager.setAdapter(new MainFragmentPageAdapter(getSupportFragmentManager(), MainActivity.this, fragmentHashMap));
        //pager.getAdapter().notifyDataSetChanged();


        tabLayout.setupWithViewPager(pager);

        if (fragmentHashMap.size() > 1)
            tabLayout.setVisibility(View.VISIBLE);
        else
            tabLayout.setVisibility(View.GONE);


        bottombar = (TabLayout) findViewById(R.id.bottombar);

        bottombar.addTab(bottombar.newTab().setIcon(R.drawable.clock_circular_outline_hint));
        bottombar.addTab(bottombar.newTab().setIcon(R.drawable.viral_hint));
        bottombar.addTab(bottombar.newTab().setIcon(R.drawable.create_new_hint));
        bottombar.addTab(bottombar.newTab().setIcon(R.drawable.two_men_hint));
        bottombar.addTab(bottombar.newTab().setIcon(R.drawable.user_shape_hint));


        bottombar.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

//                HashMap<String, Fragment> fragmentHashMap;
                switch (tab.getPosition()) {

                    case 0:

                        //pager.setCurrentItem(0);
                        fragmentHashMap = new HashMap<>();
                        fragmentHashMap.put("Timeline", FragmentInstagramHeaders.newInstance());
                        pager.setAdapter(new MainFragmentPageAdapter(getSupportFragmentManager(), MainActivity.this, fragmentHashMap));
                        //pager.getAdapter().notifyDataSetChanged();


                        tabLayout.setupWithViewPager(pager);

                        if (fragmentHashMap.size() > 1)
                            tabLayout.setVisibility(View.VISIBLE);
                        else
                            tabLayout.setVisibility(View.GONE);



                        tab.setIcon(R.drawable.clock_circular_outline);
                        bottombar.getTabAt(1).setIcon(R.drawable.viral_hint);
                        bottombar.getTabAt(2).setIcon(R.drawable.create_new_hint);
                        bottombar.getTabAt(3).setIcon(R.drawable.two_men_hint);
                        bottombar.getTabAt(4).setIcon(R.drawable.user_shape_hint);
                        break;
                    case 1:
                        //pager.setCurrentItem(0);

//                        fragmentHashMap = new HashMap<>();
//                        fragmentHashMap.put("FRIENDS", new FindFriendsFragment(pager, getSupportFragmentManager()));
//                        pager.setAdapter(new MainFragmentPageAdapter(getSupportFragmentManager(), MainActivity.this, fragmentHashMap));
//                        tabLayout.setupWithViewPager(pager);

                        fragmentHashMap = new HashMap<>();
                        fragmentHashMap.put("All", new ViralAllFragment());
                        fragmentHashMap.put("Video", new ViralVideosFragment());
                        fragmentHashMap.put("Photo", new ViralPhotosFragment());
                        fragmentHashMap.put("Article", new ViralArticlesFragment());
                        fragmentHashMap.put("Voice", new ViralAudiosFragment());
                        pager.setAdapter(new MainFragmentPageAdapter(getSupportFragmentManager(), MainActivity.this, fragmentHashMap));
                        tabLayout.setupWithViewPager(pager);
                        if (fragmentHashMap.size() > 1)
                            tabLayout.setVisibility(View.VISIBLE);
                        else
                            tabLayout.setVisibility(View.GONE);


                        bottombar.getTabAt(0).setIcon(R.drawable.clock_circular_outline_hint);
                        tab.setIcon(R.drawable.viral);
                        bottombar.getTabAt(2).setIcon(R.drawable.create_new_hint);
                        bottombar.getTabAt(3).setIcon(R.drawable.two_men_hint);
                        bottombar.getTabAt(4).setIcon(R.drawable.user_shape_hint);
                        break;
                    case 2:
                        //pager.setCurrentItem(0);

                        fragmentHashMap = new HashMap<>();
                        fragmentHashMap.put("New", new NewDocumentFragment());
                        pager.setAdapter(new MainFragmentPageAdapter(getSupportFragmentManager(), MainActivity.this, fragmentHashMap));
                        tabLayout.setupWithViewPager(pager);
                        if (fragmentHashMap.size() > 1)
                            tabLayout.setVisibility(View.VISIBLE);
                        else
                            tabLayout.setVisibility(View.GONE);

                        //pager.getAdapter().notifyDataSetChanged();
                        bottombar.getTabAt(0).setIcon(R.drawable.clock_circular_outline_hint);
                        bottombar.getTabAt(1).setIcon(R.drawable.viral_hint);
                        tab.setIcon(R.drawable.create_new);
                        bottombar.getTabAt(3).setIcon(R.drawable.two_men_hint);
                        bottombar.getTabAt(4).setIcon(R.drawable.user_shape_hint);
                        break;
                    case 3:
                        //pager.setCurrentItem(0);

                        fragmentHashMap = new HashMap<>();
//                        fragmentHashMap.put("Logs", new LogsFragment(0, pager, getSupportFragmentManager()));
//                        fragmentHashMap.put("Messages", new MessagesFragment(0, pager, getSupportFragmentManager()));


                        fragmentHashMap.put("Followers", new FollowersFragment(0,pager,getSupportFragmentManager()));

                        pager.setAdapter(new MainFragmentPageAdapter(getSupportFragmentManager(), MainActivity.this, fragmentHashMap));
                        //pager.getAdapter().notifyDataSetChanged();
                        tabLayout.setupWithViewPager(pager);
                        if (fragmentHashMap.size() > 1)
                            tabLayout.setVisibility(View.VISIBLE);
                        else
                            tabLayout.setVisibility(View.GONE);

                        bottombar.getTabAt(0).setIcon(R.drawable.clock_circular_outline_hint);
                        bottombar.getTabAt(1).setIcon(R.drawable.viral_hint);
                        bottombar.getTabAt(2).setIcon(R.drawable.create_new_hint);
                        tab.setIcon(R.drawable.two_men);
                        bottombar.getTabAt(4).setIcon(R.drawable.user_shape_hint);
                        break;
                    case 4:
                        //pager.setCurrentItem(0);

                        //pager = null;
                        //pager = (ViewPager) findViewById(R.id.pager);
//                        NewFragmentPageAdapter adap = (NewFragmentPageAdapter) pager.getAdapter();
//                        adap.mFragmentList.remove(0);
                        fragmentHashMap = new HashMap<>();
                        fragmentHashMap.put("Profile", new ProfileFragment(0, pager, getSupportFragmentManager()));
                        pager.setAdapter(new MainFragmentPageAdapter(getSupportFragmentManager(), MainActivity.this, fragmentHashMap));
                        //pager.getAdapter().notifyDataSetChanged();
                        tabLayout.setupWithViewPager(pager);
                        if (fragmentHashMap.size() > 1)
                            tabLayout.setVisibility(View.VISIBLE);
                        else
                            tabLayout.setVisibility(View.GONE);

                        Log.d(Globals.LOG_TAG, "44444");
                        bottombar.getTabAt(0).setIcon(R.drawable.clock_circular_outline_hint);
                        bottombar.getTabAt(1).setIcon(R.drawable.viral_hint);
                        bottombar.getTabAt(2).setIcon(R.drawable.create_new_hint);
                        bottombar.getTabAt(3).setIcon(R.drawable.two_men_hint);
                        tab.setIcon(R.drawable.user_shape);
                        break;

                }


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onBackPressed() {

        if (Globals.stackedFragments.size() > 0) {

            if (Globals.stackedFragments.get(Globals.stackedFragments.size() - 1) instanceof FollowersFragment) {
                HashMap<String, Fragment> fragmentHashMap = new HashMap<>();
                fragmentHashMap.put("FOLLOWERS", new FollowersFragment(0, pager, getSupportFragmentManager()));
                pager.setAdapter(new MainFragmentPageAdapter(getSupportFragmentManager(), MainActivity.this, fragmentHashMap));

                //pager.getAdapter().notifyDataSetChanged();
                tabLayout.setupWithViewPager(pager);
                Globals.stackedFragments.remove(Globals.stackedFragments.size() - 1);
            } else if (Globals.stackedFragments.get(Globals.stackedFragments.size() - 1) instanceof FollowingFragment) {

                HashMap<String, Fragment> fragmentHashMap = new HashMap<>();
                fragmentHashMap.put("FOLLOWINGS", new FollowingFragment(0, pager, getSupportFragmentManager()));
                pager.setAdapter(new MainFragmentPageAdapter(getSupportFragmentManager(), MainActivity.this, fragmentHashMap));
                //pager.getAdapter().notifyDataSetChanged();
                tabLayout.setupWithViewPager(pager);
                Globals.stackedFragments.remove(Globals.stackedFragments.size() - 1);
            } else if (Globals.stackedFragments.get(Globals.stackedFragments.size() - 1) instanceof FindFriendsFragment) {

                HashMap<String, Fragment> fragmentHashMap = new HashMap<>();
                fragmentHashMap.put("FRIENDS", new FindFriendsFragment(pager, getSupportFragmentManager()));
                pager.setAdapter(new MainFragmentPageAdapter(getSupportFragmentManager(), MainActivity.this, fragmentHashMap));
                //pager.getAdapter().notifyDataSetChanged();
                tabLayout.setupWithViewPager(pager);

            } else if (Globals.stackedFragments.get(Globals.stackedFragments.size() - 1) instanceof LogsFragment) {

                HashMap<String, Fragment> fragmentHashMap = new HashMap<>();
                fragmentHashMap.put("LOGS", new LogsFragment(0, pager, getSupportFragmentManager()));
                pager.setAdapter(new MainFragmentPageAdapter(getSupportFragmentManager(), MainActivity.this, fragmentHashMap));
                //pager.getAdapter().notifyDataSetChanged();
                tabLayout.setupWithViewPager(pager);
            } else if (Globals.stackedFragments.get(Globals.stackedFragments.size() - 1) instanceof MessagesFragment) {

                HashMap<String, Fragment> fragmentHashMap = new HashMap<>();
                fragmentHashMap.put("MESSAGES", new MessagesFragment(0, pager, getSupportFragmentManager()));
                pager.setAdapter(new MainFragmentPageAdapter(getSupportFragmentManager(), MainActivity.this, fragmentHashMap));
                //pager.getAdapter().notifyDataSetChanged();
                tabLayout.setupWithViewPager(pager);
            }


        } else

        {
            super.onBackPressed();
        }

    }
}
