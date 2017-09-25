package com.narij.narijsocialnetwork.model.retrofit;


import com.google.gson.annotations.SerializedName;
import com.narij.narijsocialnetwork.model.base.Message;

import java.util.ArrayList;

/**
 * Created by kami on 9/21/2017.
 */

public class MessagesRetrofitModel {
    @SerializedName("message")
    public WebServiceMessage message = new WebServiceMessage();
    @SerializedName("messages")
    public ArrayList<Message> messages = new ArrayList<>();
}
