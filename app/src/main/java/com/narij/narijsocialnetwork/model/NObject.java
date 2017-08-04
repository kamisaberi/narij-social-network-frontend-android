package com.narij.narijsocialnetwork.model;

/**
 * Created by kami on 6/6/2016.
 */
public class NObject {

    private String date = "";
    private int grade;


    private  Comments comments = new Comments();

    public Comments getComments() {
        return comments;
    }

    public void setComments(Comments comments) {
        this.comments = comments;
    }


    public int getGrade() {
        return grade;
    }

    private boolean like;

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }


    public void setGrade(int grade) {
        this.grade = grade;
    }

    public NObject() {
        date = "";
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
