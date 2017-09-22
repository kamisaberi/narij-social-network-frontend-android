package com.narij.narijsocialnetwork.model.retrofit;

import com.google.gson.annotations.SerializedName;
import com.narij.narijsocialnetwork.model.base.Member;

/**
 * Created by kami on 9/21/2017.
 */

public class MemberRetrofitModel {
    @SerializedName("message")
    public WebServiceMessage message = new WebServiceMessage();
    @SerializedName("member")
    public Member member = new Member();
}
