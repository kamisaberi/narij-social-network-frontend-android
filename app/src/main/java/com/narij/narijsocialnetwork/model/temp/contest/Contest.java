package com.narij.narijsocialnetwork.model.temp.contest;


import com.narij.narijsocialnetwork.model.temp.Member;
import com.narij.narijsocialnetwork.model.temp.NObject;
import com.narij.narijsocialnetwork.model.temp.media.NMedias;

/**
 * Created by kami on 5/7/2016.
 */
public class Contest extends NObject {

    private long contestId;
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

    private ContestAnswers answers = new ContestAnswers();

    public ContestAnswers getAnswers() {
        return answers;
    }

    public void setAnswers(ContestAnswers answers) {
        this.answers = answers;
    }

    public Contest() {
        super();
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public long getContestId() {
        return contestId;
    }

    public void setContestId(long contestId) {
        this.contestId = contestId;
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
