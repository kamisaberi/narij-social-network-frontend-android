package com.narij.narijsocialnetwork.model.temp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kami on 5/7/2016.
 */
public class Product extends NObject {

    private long productId;
    private String title;
    private String description;
    private String excerpt;


    private List<Price> prices = new ArrayList<>();


    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }


    public Product() {
        super();
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
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

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }


    public String toString() {
        //NumberFormat nf = NumberFormat.getCurrencyInstance();
        return "ID : " + productId + "\n" + "TITLE : " +  title + "\n" + "EXCERPT : " + excerpt + "\n" + "CONTENT : " + description;
    }


}
