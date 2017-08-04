package com.narij.narijsocialnetwork.model.ticket;


import com.narij.narijsocialnetwork.model.Member;
import com.narij.narijsocialnetwork.model.media.NMedias;

/**
 * Created by kami on 7/31/2016.
 */
public class Ticket {


    private long ticketId;
    private String title;
    private String content;

    private Member member = new Member();

    private NMedias medias = new NMedias();

    private TicketAnswers answers = new TicketAnswers();

    public Ticket() {

    }


    public TicketAnswers getAnswers() {
        return answers;
    }

    public void setAnswers(TicketAnswers answers) {
        this.answers = answers;
    }

    public long getTicketId() {
        return ticketId;
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
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
