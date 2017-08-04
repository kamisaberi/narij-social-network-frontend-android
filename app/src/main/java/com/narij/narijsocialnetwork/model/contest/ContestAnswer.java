package com.narij.narijsocialnetwork.model.contest;

import com.narij.narijsocialnetwork.model.Member;
import com.narij.narijsocialnetwork.model.NObject;
import com.narij.narijsocialnetwork.model.media.NMedias;

/**
 * Created by kami on 5/7/2016.
 */
public class ContestAnswer extends NObject {

    private long contestAnswerId;
    private String title;
    private String content;
    private String excerpt;
    private Member member = new Member();

    private NMedias medias = new NMedias();


    public NMedias getMedias() {
        return medias;
    }

    public void setMedias(NMedias medias) {
        this.medias = medias;
    }

    public ContestAnswer() {
        super();
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public long getContestAnswerId() {
        return contestAnswerId;
    }

    public void setContestAnswerId(long contestAnswerId) {
        this.contestAnswerId = contestAnswerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }


    public String toString() {
        //NumberFormat nf = NumberFormat.getCurrencyInstance();
        return title + "\t(" + excerpt + ")\n " + content;
    }


}
