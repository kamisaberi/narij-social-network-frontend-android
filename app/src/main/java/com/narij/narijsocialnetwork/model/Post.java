package com.narij.narijsocialnetwork.model;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by kami on 8/20/2017.
 */

public class Post {
    private long postId;
    private com.narij.narijsocialnetwork.model.enumeration.MediaType mediaType;
    private Locale createTime;
    private Locale editTime;
    private Locale deleteTime;
    private boolean deleted;
    private PostCategory postCategory;
    private ArrayList<Property> properties = new ArrayList<>();

    public Post() {
        this.properties = new ArrayList<>();
    }

    public Post(long postId, com.narij.narijsocialnetwork.model.enumeration.MediaType mediaType, Locale createTime, Locale editTime, Locale deleteTime, boolean deleted, PostCategory postCategory, ArrayList<Property> properties) {
        this.postId = postId;
        this.mediaType = mediaType;
        this.createTime = createTime;
        this.editTime = editTime;
        this.deleteTime = deleteTime;
        this.deleted = deleted;
        this.postCategory = postCategory;
        this.properties = properties;
    }

    public ArrayList<Property> getProperties() {
        return properties;
    }

    public void setProperties(ArrayList<Property> properties) {
        this.properties = properties;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public com.narij.narijsocialnetwork.model.enumeration.MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(com.narij.narijsocialnetwork.model.enumeration.MediaType mediaType) {
        this.mediaType = mediaType;
    }

    public Locale getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Locale createTime) {
        this.createTime = createTime;
    }

    public Locale getEditTime() {
        return editTime;
    }

    public void setEditTime(Locale editTime) {
        this.editTime = editTime;
    }

    public Locale getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Locale deleteTime) {
        this.deleteTime = deleteTime;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public PostCategory getPostCategory() {
        return postCategory;
    }

    public void setPostCategory(PostCategory postCategory) {
        this.postCategory = postCategory;
    }
}
