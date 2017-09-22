package com.narij.narijsocialnetwork.model.retrofit;

import com.google.gson.annotations.SerializedName;
import com.narij.narijsocialnetwork.model.base.Follow;
import com.narij.narijsocialnetwork.model.base.Member;

import java.util.ArrayList;

/**
 * Created by kami on 9/21/2017.
 */

public class FriendsRetrofitModel {
    @SerializedName("message")
    public WebServiceMessage message = new WebServiceMessage();
    @SerializedName("members")
    public ArrayList<Member> members= new ArrayList<>();
}
