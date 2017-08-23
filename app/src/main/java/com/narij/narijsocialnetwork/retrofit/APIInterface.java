package com.narij.narijsocialnetwork.retrofit;

import com.narij.narijsocialnetwork.model.WebServiceMessage;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by kami on 8/4/2017.
 */

public interface APIInterface {


    @FormUrlEncoded
    @POST("register/enterphonenumber")
    Call<WebServiceMessage> enterPhoneNumber(@Field("phone") String phone);

    @FormUrlEncoded
    @POST("register/confirmverificationcode")
    Call<WebServiceMessage> confirmPhoneNumber(@Field("token") String token, @Field("verificationCode") String veficationCode);

    @FormUrlEncoded
    @POST("register/createpassword")
    Call<WebServiceMessage> createPassword(@Field("token") String token, @Field("password") String password);


    @FormUrlEncoded
    @POST("profile/change")
    Call<WebServiceMessage> changeProfile(@Field("token") String token, @Field("fullname") String fullname, @Field("email") String email, @Field("location") String location, @Field("photo") String photo);


    @FormUrlEncoded
    @POST("profile/changefullname")
    Call<WebServiceMessage> changeFullName(@Field("token") String token, @Field("fullname") String fullname);

    @FormUrlEncoded
    @POST("profile/changeemail")
    Call<WebServiceMessage> changeEmail(@Field("token") String token, @Field("email") String email);

    @FormUrlEncoded
    @POST("profile/changephoto")
    Call<WebServiceMessage> changePhoto(@Field("token") String token, @Field("photo") String photo);

    @FormUrlEncoded
    @POST("profile/changelocation")
    Call<WebServiceMessage> changeLocation(@Field("token") String token, @Field("location") String location);


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
    Call<WebServiceMessage> forgotPasswordViaPhoneNumber();


    @FormUrlEncoded
    @POST("changepassword")
    Call<WebServiceMessage> changePassword();


//    @FormUrlEncoded
//    @POST("confirmphonenumber")
//    Call<WebServiceMessage> confirmPhoneNumber();


    @FormUrlEncoded
    @POST("createpassword")
    Call<WebServiceMessage> createPassword();


    @FormUrlEncoded
    @POST("documents/create/audio")
    Call<WebServiceMessage> createAudioDocument();

    @FormUrlEncoded
    @POST("documents/create/photo")
    Call<WebServiceMessage> createPhotoDocument();

    @FormUrlEncoded
    @POST("documents/create/text")
    Call<WebServiceMessage> createTextDocument();

    @FormUrlEncoded
    @POST("documents/create/video")
    Call<WebServiceMessage> createVideoDocument();


}
