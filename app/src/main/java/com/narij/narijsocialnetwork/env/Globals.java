package com.narij.narijsocialnetwork.env;

import com.narij.narijsocialnetwork.model.base.Post;

import java.io.File;

/**
 * Created by kami on 8/4/2017.
 */

public class Globals {

    public static final String BASE_URL = "http://192.168.1.200/NarijWebService/public/";

    public static final String LOG_TAG = "NARIJ_APP_LOG";
    public static final String PREF_FILE_NAME = "prefs.sav";
    public static final String PREF_TOKEN_KEY = "token";

    public static String token = "";


    public static Post currentPostToSend = new Post();


    public static final boolean DEBUG_MODE = true;

    public static File selectedFileToUpload;


}
