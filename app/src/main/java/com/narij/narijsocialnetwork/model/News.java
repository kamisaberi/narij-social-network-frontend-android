package com.narij.narijsocialnetwork.model;

/**
 * Created by kami on 5/7/2016.
 */
public class News extends NObject {

    private long newsId;
    private String title;
    private String content;
    private String excerpt;
    private Member member = new Member();

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public News() {
        super();
    }

    public News(long newsId, String title, String excerpt) {
        this.newsId = newsId;
        this.title = title;
        this.excerpt = excerpt;
    }

    public long getNewsId() {
        return newsId;
    }

    public void setNewsId(long newsId) {
        this.newsId = newsId;
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
        return "ID : " + newsId + "\n" + "TITLE : " + title + "\n" + "EXCERPT : " + excerpt + "\n" + "CONTENT : " + content;
    }


}
