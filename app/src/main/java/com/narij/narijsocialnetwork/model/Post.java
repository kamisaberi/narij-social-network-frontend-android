package com.narij.narijsocialnetwork.model;

import java.util.Locale;

/**
 * Created by kami on 8/20/2017.
 */

public class Post {
    private  long postId;
    private  MediaType mediaType;
    private Locale createTime;
    private Locale editTime;
    private Locale deleteTime;
    private  boolean deleted;
    private  PostCategory postCategory;

    public Post(long postId, MediaType mediaType, Locale createTime, Locale editTime, Locale deleteTime, boolean deleted, PostCategory postCategory) {
        this.postId = postId;
        this.mediaType = mediaType;
        this.createTime = createTime;
        this.editTime = editTime;
        this.deleteTime = deleteTime;
        this.deleted = deleted;
        this.postCategory = postCategory;
    }


    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
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
