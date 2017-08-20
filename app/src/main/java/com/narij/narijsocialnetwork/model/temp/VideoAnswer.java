package com.narij.narijsocialnetwork.model.temp;


import com.narij.narijsocialnetwork.model.temp.interfaces.IAnswer;
import com.narij.narijsocialnetwork.model.temp.media.NVideo;

/**
 * Created by kami on 5/7/2016.
 */
public class VideoAnswer extends NVideo implements IAnswer {

    private long videoAnswerId;
    private String title;
    private String description;

    public VideoAnswer() {
        super();
    }

    public long getVideoAnswerId() {
        return videoAnswerId;
    }

    public void setVideoAnswerId(long videoAnswerId) {
        this.videoAnswerId = videoAnswerId;
    }

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


    public String toString() {
        //NumberFormat nf = NumberFormat.getCurrencyInstance();
        return "ID : " + videoAnswerId + "\n" + "TITLE : " + title + "\n" + "EXCERPT : " + "\n" + "CONTENT : " + description;
    }


}
