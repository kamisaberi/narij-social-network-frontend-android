package com.narij.narijsocialnetwork.model.temp;

/**
 * Created by kami on 8/7/2016.
 */
public class Score {

    private long scoreId;
    private String date;
    private int value;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getScoreId() {
        return scoreId;
    }

    public void setScoreId(long scoreId) {
        this.scoreId = scoreId;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
