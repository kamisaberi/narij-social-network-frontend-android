package com.narij.narijsocialnetwork.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.narij.narijsocialnetwork.R;

public class MainActivity extends AppCompatActivity {


    TabLayout bottombar;


    TabLayout tabLayout;
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        pager = (ViewPager) findViewById(R.id.pager);


        bottombar = (TabLayout) findViewById(R.id.bottombar);

        bottombar.addTab(bottombar.newTab().setIcon(R.drawable.clock_circular_outline_hint));
        bottombar.addTab(bottombar.newTab().setIcon(R.drawable.viral_hint));
        bottombar.addTab(bottombar.newTab().setIcon(R.drawable.create_new_hint));
        bottombar.addTab(bottombar.newTab().setIcon(R.drawable.two_men_hint));
        bottombar.addTab(bottombar.newTab().setIcon(R.drawable.user_shape));


        bottombar.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                switch (tab.getPosition()) {

                    case 0:

                        break;
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

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
}
