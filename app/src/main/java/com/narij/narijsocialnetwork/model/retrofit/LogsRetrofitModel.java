package com.narij.narijsocialnetwork.model.retrofit;


import com.google.gson.annotations.SerializedName;
import com.narij.narijsocialnetwork.model.base.Log;

import java.util.ArrayList;

/**
 * Created by kami on 9/21/2017.
 */

public class LogsRetrofitModel {
    @SerializedName("message")
    public WebServiceMessage message = new WebServiceMessage();
    @SerializedName("logs")
    public ArrayList<Log> logs = new ArrayList<>();
}
