package com.narij.narijsocialnetwork.model;

/**
 * Created by kami on 5/7/2016.
 */
public class Comment extends NObject {

    private long commentId;
    private String content;
    private Member member = new Member();


    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public Comment() {
        super();
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }



    public String toString() {
        //NumberFormat nf = NumberFormat.getCurrencyInstance();
        return  content;
    }


}
