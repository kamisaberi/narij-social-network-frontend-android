package com.narij.narijsocialnetwork.model.temp;


import com.narij.narijsocialnetwork.model.temp.media.NMedias;
import com.narij.narijsocialnetwork.model.temp.media.NVideo;

/**
 * Created by kami on 5/7/2016.
 */
public class VideoPost extends NVideo {

    private long videoPostId;
    private String title;
    private String description;
    private NMedias medias = new NMedias();

    public VideoPost() {
        super();
    }

    public NMedias getMedias() {
        return medias;
    }

    public void setMedias(NMedias medias) {
        this.medias = medias;
    }

    public long getVideoPostId() {
        return videoPostId;
    }

    public void setVideoPostId(long videoPostId) {
        this.videoPostId = videoPostId;
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
        return "ID : " + videoPostId + "\n" + "TITLE : " + title + "\n" + "EXCERPT : " + "\n" + "CONTENT : " + description;
    }


}
