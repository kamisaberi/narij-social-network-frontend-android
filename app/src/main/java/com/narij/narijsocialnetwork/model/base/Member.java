package com.narij.narijsocialnetwork.model.base;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by kami on 8/20/2017.
 */

public class Member {

    @SerializedName("memberId")
    private long memberId;
    @SerializedName("fullName")
    private String fullName;
    @SerializedName("phone")
    private String phone;
    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;
    @SerializedName("active")
    private boolean active;
    @SerializedName("verificationCode")
    private String verificationCode;

    @SerializedName("followers")
    private ArrayList<Follow> followers = new ArrayList<>();
    @SerializedName("followings")
    private ArrayList<Follow> followings = new ArrayList<>();
    @SerializedName("posts")
    private ArrayList<Post> posts = new ArrayList<>();


    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public ArrayList<Follow> getFollowers() {
        return followers;
    }

    public void setFollowers(ArrayList<Follow> followers) {
        this.followers = followers;
    }

    public ArrayList<Follow> getFollowings() {
        return followings;
    }

    public void setFollowings(ArrayList<Follow> followings) {
        this.followings = followings;
    }

    public Member() {
    }

    public Member(long memberId, String fullName, String phone, String email, String password, boolean active, String verificationCode) {
        this.memberId = memberId;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.active = active;
        this.verificationCode = verificationCode;
    }


    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }
}
