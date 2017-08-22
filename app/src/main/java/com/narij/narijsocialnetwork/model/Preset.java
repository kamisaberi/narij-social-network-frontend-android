package com.narij.narijsocialnetwork.model;

/**
 * Created by kami on 8/22/2017.
 */

public class Preset {

    private  long presetId;
    private  String title;
    private  String defaultValue;
    private  String description;
    private  int order;
    private  ObjectType objectType;
    private  int objectId;

    public Preset(long presetId, String title, String defaultValue, String description, int order, ObjectType objectType, int objectId) {
        this.presetId = presetId;
        this.title = title;
        this.defaultValue = defaultValue;
        this.description = description;
        this.order = order;
        this.objectType = objectType;
        this.objectId = objectId;
    }


    public long getPresetId() {
        return presetId;
    }

    public void setPresetId(long presetId) {
        this.presetId = presetId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public ObjectType getObjectType() {
        return objectType;
    }

    public void setObjectType(ObjectType objectType) {
        this.objectType = objectType;
    }

    public int getObjectId() {
        return objectId;
    }

    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }
}
