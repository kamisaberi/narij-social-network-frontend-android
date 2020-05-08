package com.narij.narijsocialnetwork.model.base;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kami on 8/22/2017.
 */

public class PostCategory {


    @SerializedName("postCategoryId")
    private long postCategoryId;
    @SerializedName("title")
    private String title;


    public PostCategory(long postCategoryId, String title) {
        this.postCategoryId = postCategoryId;
        this.title = title;
    }

    public long getPostCategoryId() {
        return postCategoryId;
    }

    public void setPostCategoryId(long postCategoryId) {
        this.postCategoryId = postCategoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}



