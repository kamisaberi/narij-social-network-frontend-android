package com.narij.narijsocialnetwork.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.narij.narijsocialnetwork.R;
import com.narij.narijsocialnetwork.adapter.fragmentadapter.SignupLoginFragmentPageAdapter;
import com.narij.narijsocialnetwork.env.Globals;

public class LoginSignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_signup);
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);


        //Member member = new Member();

        try {
            viewPager.setAdapter(new SignupLoginFragmentPageAdapter(getSupportFragmentManager(), LoginSignupActivity.this));
            //viewPager.setAdapter(new SignupLoginFragmentPageAdapter1(getSupportFragmentManager(), LoginSignupActivity.this));

            TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);



            tabLayout.setupWithViewPager(viewPager);

            ViewGroup vg = (ViewGroup) tabLayout.getChildAt(0);
            int tabsCount = vg.getChildCount();
            for (int j = 0; j < tabsCount; j++) {
                ViewGroup vgTab = (ViewGroup) vg.getChildAt(j);
                int tabChildsCount = vgTab.getChildCount();
                for (int i = 0; i < tabChildsCount; i++) {
                    View tabViewChild = vgTab.getChildAt(i);
                    if (tabViewChild instanceof TextView) {
                        ((TextView) tabViewChild).setTypeface(Globals.typeface, Typeface.NORMAL);
                    }
                }
            }



        } catch (Exception e) {
            Log.d(Globals.LOG_TAG, e.getMessage());
        }


    }
}
