package com.narij.narijsocialnetwork.model;

/**
 * Created by kami on 6/27/2016.
 */
public class Category {

    private long categoryId;
    private String title;
    private long parent ;
    private String description;
    private String date;


    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        //Log.d(Globals.LOG_TAG, "CAT IN ONE ID : " +  categoryId);
        this.categoryId = categoryId;
        //Log.d(Globals.LOG_TAG, "CAT IN TWO ID : " +  categoryId);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Category() {
    }

    public Category(String description) {
        this.description = description;
    }

    public Category(long categoryId, String title) {
        this.categoryId = categoryId;
        this.title= title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getParent() {
        return parent;
    }

    public void setParent(long parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
