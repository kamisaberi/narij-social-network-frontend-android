package com.narij.narijsocialnetwork.model.retrofit;


import com.google.gson.annotations.SerializedName;
import com.narij.narijsocialnetwork.model.base.Post;

import java.util.ArrayList;

/**
 * Created by kami on 9/21/2017.
 */

public class PostsRetrofitModel {
    @SerializedName("message")
    public WebServiceMessage message = new WebServiceMessage();
    @SerializedName("posts")
    public ArrayList<Post> posts = new ArrayList<>();
}
