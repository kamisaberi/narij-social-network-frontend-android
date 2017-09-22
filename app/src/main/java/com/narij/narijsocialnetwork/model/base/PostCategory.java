package com.narij.narijsocialnetwork.model.base;

/**
 * Created by kami on 8/22/2017.
 */

public class PostCategory {


    private long postCategory;
    private String title;


    public PostCategory(long postCategory, String title) {
        this.postCategory = postCategory;
        this.title = title;
    }

    public long getPostCategory() {
        return postCategory;
    }

    public void setPostCategory(long postCategory) {
        this.postCategory = postCategory;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}



