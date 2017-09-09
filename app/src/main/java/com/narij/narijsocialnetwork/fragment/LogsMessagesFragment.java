package com.narij.narijsocialnetwork.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.narij.narijsocialnetwork.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LogsMessagesFragment extends Fragment {


    TabLayout tabLayout;
    ViewPager pager;

    public LogsMessagesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_logs_messages, container, false);

        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        pager = (ViewPager) view.findViewById(R.id.pager);


        return view;
    }

}
