package com.narij.narijsocialnetwork.model;

/**
 * Created by kami on 8/22/2017.
 */

public class MediaType {

    private  int mediaTypeId;
    private  String title;

    public MediaType(int mediaTypeId, String title) {
        this.mediaTypeId = mediaTypeId;
        this.title = title;
    }

    public int getMediaTypeId() {
        return mediaTypeId;
    }

    public void setMediaTypeId(int mediaTypeId) {
        this.mediaTypeId = mediaTypeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
