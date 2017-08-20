package com.narij.narijsocialnetwork.model.temp.exam;


import com.narij.narijsocialnetwork.model.temp.Member;
import com.narij.narijsocialnetwork.model.temp.NObject;

/**
 * Created by kami on 5/7/2016.
 */
public class Exam extends NObject {

    private long examId;
    private String title;
    private String content;
    private String excerpt;
    private Member member = new Member();


    private ExamQuestions questions = new ExamQuestions();

    public ExamQuestions getQuestions() {
        return questions;
    }

    public void setQuestions(ExamQuestions questions) {
        this.questions = questions;
    }

    public Exam() {
        super();
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }


    public long getExamId() {
        return examId;
    }

    public void setExamId(long examId) {
        this.examId = examId;
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
