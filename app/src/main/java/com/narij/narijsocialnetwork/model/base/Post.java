package com.narij.narijsocialnetwork.model.base;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by kami on 8/20/2017.
 */

public class Post {
    @SerializedName("postId")
    private long postId;

    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String description;
    @SerializedName("mediaType")
    private String mediaType;
    @SerializedName("createTime")
    private Locale createTime;
    @SerializedName("editTime")
    private Locale editTime;
    @SerializedName("deleteTime")
    private Locale deleteTime;
    @SerializedName("deleted")
    private boolean deleted;
    @SerializedName("postCategory")
    private PostCategory postCategory;
    @SerializedName("properties ")
    private ArrayList<Property> properties = new ArrayList<>();
    @SerializedName("member")
    private  Member member = new Member();



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Post() {
        this.properties = new ArrayList<>();
    }

    public Post(long postId, com.narij.narijsocialnetwork.model.enumeration.MediaType media, MediaType mediaType, Locale createTime, Locale editTime, Locale deleteTime, boolean deleted, PostCategory postCategory, ArrayList<Property> properties, Member member) {
        this.postId = postId;
        this.mediaType = "";
        this.createTime = createTime;
        this.editTime = editTime;
        this.deleteTime = deleteTime;
        this.deleted = deleted;
        this.postCategory = postCategory;
        this.properties = properties;
        this.member = member;
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
