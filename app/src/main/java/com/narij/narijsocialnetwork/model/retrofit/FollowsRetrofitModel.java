package com.narij.narijsocialnetwork.model.retrofit;

import com.google.gson.annotations.SerializedName;
import com.narij.narijsocialnetwork.model.base.Follow;

import java.util.ArrayList;

/**
 * Created by kami on 9/21/2017.
 */

public class FollowsRetrofitModel {
    @SerializedName("message")
    public WebServiceMessage message = new WebServiceMessage();
    @SerializedName("follows")
    public ArrayList<Follow> follows = new ArrayList<>();
}
