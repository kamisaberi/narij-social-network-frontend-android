package com.narij.narijsocialnetwork.model;

/**
 * Created by kami on 8/22/2017.
 */

public class ObjectType {

    private long objectTypeId;
    private String title;


    public ObjectType(long objectTypeId, String title) {
        this.objectTypeId = objectTypeId;
        this.title = title;
    }


    public long getObjectTypeId() {
        return objectTypeId;
    }

    public void setObjectTypeId(long objectTypeId) {
        this.objectTypeId = objectTypeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
