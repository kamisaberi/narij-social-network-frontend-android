package com.narij.narijsocialnetwork.model.base;

/**
 * Created by kami on 8/22/2017.
 */

public class Property {

    private  long propertyId;
    private  String name;
    private  String value;
    private  ObjectType objectType;
    private  long objectId;


    public Property(long propertyId, String name, String value, ObjectType objectType, long objectId) {
        this.propertyId = propertyId;
        this.name = name;
        this.value = value;
        this.objectType = objectType;
        this.objectId = objectId;
    }


    public long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(long propertyId) {
        this.propertyId = propertyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ObjectType getObjectType() {
        return objectType;
    }

    public void setObjectType(ObjectType objectType) {
        this.objectType = objectType;
    }

    public long getObjectId() {
        return objectId;
    }

    public void setObjectId(long objectId) {
        this.objectId = objectId;
    }
}
