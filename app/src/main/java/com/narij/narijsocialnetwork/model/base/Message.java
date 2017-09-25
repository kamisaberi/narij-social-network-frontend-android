package com.narij.narijsocialnetwork.model.base;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kami on 8/20/2017.
 */

public class Message {

    @SerializedName("messageId")
    private long messageId;
    @SerializedName("content")
    private  String content;
    @SerializedName("member")
    private  Member member = new Member();
    @SerializedName("time")
    private  String time;
    @SerializedName("parent")
    private  long parent;

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public long getParent() {
        return parent;
    }

    public void setParent(long parent) {
        this.parent = parent;
    }


}
