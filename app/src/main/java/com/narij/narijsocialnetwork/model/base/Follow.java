package com.narij.narijsocialnetwork.model.base;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kami on 8/20/2017.
 */

public class Follow {

    @SerializedName("followId")
    private long followId;
    @SerializedName("member")
    private Member member = new Member();

    @SerializedName("situation")
    private String situation;
    @SerializedName("time")
    private String time;

    public Follow() {
    }

    public Follow(long followId, Member member, String situation, String time) {
        this.followId = followId;
        this.member = member;
        this.situation = situation;
        this.time = time;
    }

    public long getFollowId() {
        return followId;
    }

    public void setFollowId(long followId) {
        this.followId = followId;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
/*

    "followId": "304",
    "member": "415",
    "object": "410",
    "objectType": "Member",
    "situation": "Confirm",
    "time": "2017-09-21 00:40:56.897264"


     */


}
