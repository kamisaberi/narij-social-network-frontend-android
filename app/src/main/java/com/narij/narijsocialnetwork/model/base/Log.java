package com.narij.narijsocialnetwork.model.base;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kami on 8/20/2017.
 */

public class Log {

    @SerializedName("logId")
    private long logId;
    @SerializedName("content")
    private  String content;
    @SerializedName("member")
    private  Member member = new Member();
    @SerializedName("time")
    private  String time;
    @SerializedName("parent")
    private  long parent;

    public long getLogId() {
        return logId;
    }

    public void setLogId(long logId) {
        this.logId = logId;
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

    public Log(long logId, String content, Member member, String time, long parent) {
        this.logId = logId;
        this.content = content;
        this.member = member;
        this.time = time;
        this.parent = parent;
    }

    public Log() {
    }
}
