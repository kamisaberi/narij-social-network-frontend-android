package com.narij.narijsocialnetwork.application;

import android.app.Application;
import android.graphics.Typeface;

import com.narij.narijsocialnetwork.R;
import com.narij.narijsocialnetwork.env.Globals;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by kami on 8/4/2017.
 */

public class NarijApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();


        Globals.typeface= Typeface.createFromAsset(getBaseContext().getAssets(), "fonts/Lato-Medium.ttf");


//        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
//                .setDefaultFontPath("fonts/Lato-Medium.ttf")
//                .setFontAttrId(R.attr.fontPath)
//                .build()
//        );
        //....

    }
}
