package com.narij.narijsocialnetwork.model.temp.exam;


import com.narij.narijsocialnetwork.model.temp.Member;
import com.narij.narijsocialnetwork.model.temp.media.NMedias;

/**
 * Created by kami on 7/31/2016.
 */
public class ExamQuestion {

    private long examQuestionId;
    private String title;
    private String content;

    private Member member = new Member();

    private NMedias medias = new NMedias();


    public ExamQuestion() {

    }


    public long getExamQuestionId() {
        return examQuestionId;
    }

    public void setExamQuestionId(long examQuestionId) {
        this.examQuestionId = examQuestionId;
    }

    public NMedias getMedias() {
        return medias;
    }

    public void setMedias(NMedias medias) {
        this.medias = medias;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
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


    public String toString() {
        //NumberFormat nf = NumberFormat.getCurrencyInstance();
        return title + "\t(" + ")\n " + content;
    }





}
