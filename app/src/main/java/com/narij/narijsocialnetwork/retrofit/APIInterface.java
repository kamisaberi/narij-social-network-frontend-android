package com.narij.narijsocialnetwork.retrofit;

import com.narij.narijsocialnetwork.model.retrofit.WebServiceMessage;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by kami on 8/4/2017.
 */

public interface APIInterface {


    @FormUrlEncoded
    @POST("register")
    Call<WebServiceMessage> register();


    @FormUrlEncoded
    @POST("login")
    Call<WebServiceMessage> login();


    @FormUrlEncoded
    @POST("forgotpassword/enteremail")
    Call<WebServiceMessage> forgotPasswordViaEmail();



    @FormUrlEncoded
    @POST("forgotpassword/enterphonenumber")
    Call<WebServiceMessage>  forgotPasswordViaPhoneNumber();


    @FormUrlEncoded
    @POST("changepassword")
    Call<WebServiceMessage>  changePassword();


    @FormUrlEncoded
    @POST("confirmphonenumber")
    Call<WebServiceMessage>  confirmPhoneNumber();


    @FormUrlEncoded
    @POST("createpassword")
    Call<WebServiceMessage>  createPassword();


    @FormUrlEncoded
    @POST("documents/create/audio")
    Call<WebServiceMessage>  createAudioDocument();

    @FormUrlEncoded
    @POST("documents/create/photo")
    Call<WebServiceMessage>  createPhotoDocument();

    @FormUrlEncoded
    @POST("documents/create/text")
    Call<WebServiceMessage>  createTextDocument();

    @FormUrlEncoded
    @POST("documents/create/video")
    Call<WebServiceMessage>  createVideoDocument();






}
