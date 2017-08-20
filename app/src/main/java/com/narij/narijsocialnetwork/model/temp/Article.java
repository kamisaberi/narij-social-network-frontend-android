package com.narij.narijsocialnetwork.model.temp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kami on 5/7/2016.
 */
public class Article extends NObject {

    private long articleId;
    private String title;
    private String content;
    private String excerpt;
    private Member member = new Member();



    private List<Price> prices = new ArrayList<>();


    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }


    public Article() {
        super();
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
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
