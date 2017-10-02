package com.narij.narijsocialnetwork.env;

import android.graphics.Typeface;
import android.support.v4.app.Fragment;

import com.narij.narijsocialnetwork.model.base.Post;
import com.narij.narijsocialnetwork.model.retrofit.MemberRetrofitModel;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by kami on 8/4/2017.
 */

public class Globals {

    public static final String BASE_URL = "http://192.168.1.200/NarijWebService/public/";

    public static final String LOG_TAG = "NARIJ_APP_LOG";
    public static final String PREF_FILE_NAME = "prefs.sav";
    public static final String PREF_TOKEN_KEY = "token";

    public static String token = "";


    public static  Typeface typeface;
    public final static String LATO_MEDIUM_FONT = "fonts/Lato-Medium.ttf";


    public static Post currentPostToSend = new Post();


    public static final boolean DEBUG_MODE = true;

    public static File selectedFileToUpload;

    public static ArrayList<Fragment> stackedFragments = new ArrayList<>();

    public static MemberRetrofitModel loggedInData = new MemberRetrofitModel();

}
