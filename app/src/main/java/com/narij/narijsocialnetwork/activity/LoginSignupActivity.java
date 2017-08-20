package com.narij.narijsocialnetwork.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.narij.narijsocialnetwork.R;
import com.narij.narijsocialnetwork.adapter.fragment.SignupLoginFragmentPageAdapter;
import com.narij.narijsocialnetwork.env.Globals;

public class LoginSignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_signup);
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);


        try {
            viewPager.setAdapter(new SignupLoginFragmentPageAdapter(getSupportFragmentManager(), LoginSignupActivity.this));
            //viewPager.setAdapter(new SignupLoginFragmentPageAdapter1(getSupportFragmentManager(), LoginSignupActivity.this));

            TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);

            tabLayout.setupWithViewPager(viewPager);
        } catch (Exception e) {
            Log.d(Globals.LOG_TAG, e.getMessage());
        }


    }
}
