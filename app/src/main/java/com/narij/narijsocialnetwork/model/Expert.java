package com.narij.narijsocialnetwork.model;

/**
 * Created by kami on 6/27/2016.
 */
public class Expert {

    private long expertId;
    private String title;
    private long parent ;
    private String description;
    private String date;

    private Scores scores = new Scores();

    public Scores getScores() {
        return scores;
    }

    public void setScores(Scores scores) {
        this.scores = scores;
    }

    public long getExpertId() {
        return expertId;
    }

    public void setExpertId(long expertId) {
        this.expertId = expertId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Expert() {
    }

    public Expert(String description) {
        this.description = description;
    }

    public Expert(long expertId, String title) {
        this.expertId = expertId;
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
