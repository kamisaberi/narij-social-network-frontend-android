package com.narij.narijsocialnetwork.model.retrofit;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kami on 8/15/2017.
 */

public class WebServiceMessage {

    @SerializedName("id")
    private int id;

    @SerializedName("content")
    private String content;

    public WebServiceMessage(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
