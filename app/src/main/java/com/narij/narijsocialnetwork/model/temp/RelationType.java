package com.narij.narijsocialnetwork.model.temp;

/**
 * Created by kami on 5/7/2016.
 */
public class RelationType extends NObject {

    private long relationTypeId;
    private String title;

    public RelationType() {
    }

    public RelationType(long relationTypeId, String title, String excerpt) {
        this.relationTypeId = relationTypeId;
        this.title = title;
    }

    public long getRelationTypeId() {
        return relationTypeId;
    }

    public void setRelationTypeId(long relationTypeId) {
        this.relationTypeId = relationTypeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String toString() {
        //NumberFormat nf = NumberFormat.getCurrencyInstance();
        return "ID : " + relationTypeId + "\n" + "TITLE : " + title;
    }


}
