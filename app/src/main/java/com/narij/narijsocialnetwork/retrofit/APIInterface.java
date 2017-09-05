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
    @POST("register/enterPhoneNumber")
    Call<WebServiceMessage> enterPhoneNumber(@Field("phone") String phone);

    @FormUrlEncoded
    @POST("register/confirmVerificationCode")
    Call<WebServiceMessage> confirmPhoneNumber(@Field("token") String token, @Field("verificationCode") String verificationCode);

    @FormUrlEncoded
    @POST("register/createPassword")
    Call<WebServiceMessage> createPassword(@Field("token") String token, @Field("password") String password);


    @FormUrlEncoded
    @POST("profile/get")
    Call<WebServiceMessage> getProfileDetail(@Field("token") String token);

    @FormUrlEncoded
    @POST("profile/set")
    Call<WebServiceMessage> setProfileDetail(@Field("token") String token, @Field("fullName") String fullName, @Field("email") String email, @Field("location") String location, @Field("photo") String photo);

    @FormUrlEncoded
    @POST("profile/set/email")
    Call<WebServiceMessage> setProfileEmail(@Field("token") String token, @Field("email") String email);

    @FormUrlEncoded
    @POST("profile/set/fullName")
    Call<WebServiceMessage> setProfileFullName(@Field("token") String token, @Field("fullName") String fullName);

    @FormUrlEncoded
    @POST("profile/set/location")
    Call<WebServiceMessage> setProfileLocation(@Field("token") String token, @Field("location") String location);

    @FormUrlEncoded
    @POST("profile/set/photo")
    Call<WebServiceMessage> setProfilePhoto(@Field("token") String token, @Field("photo") String photo);


    @FormUrlEncoded
    @POST("password/forgot/enterPhoneNumber")
    Call<WebServiceMessage> enterPhoneNumberToRecoverPassword(@Field("phone") String phone);

    @FormUrlEncoded
    @POST("password/forgot/enterEmail")
    Call<WebServiceMessage> enterEmailToRecoverPassword(@Field("email") String email);

    @FormUrlEncoded
    @POST("password/change")
    Call<WebServiceMessage> changePassword(@Field("old") String oldPassword, @Field("new") String newPassword);

    @FormUrlEncoded
    @POST("login")
    Call<WebServiceMessage> login(@Field("phone") String phoneNumber, @Field("password") String password);

    @FormUrlEncoded
    @POST("password/create")
    Call<WebServiceMessage> createPassword(@Field("password") String password);

    @FormUrlEncoded
    @POST("post/create/audio")
    Call<WebServiceMessage> createAudioPost(@Field("token") String token);

    @FormUrlEncoded
    @POST("post/create/photo")
    Call<WebServiceMessage> createPhotoPost(@Field("token") String token);

    @FormUrlEncoded
    @POST("post/create/text")
    Call<WebServiceMessage> createTextPost(@Field("token") String token);

    @FormUrlEncoded
    @POST("post/create/video")
    Call<WebServiceMessage> createVideoPost(@Field("token") String token);

    @FormUrlEncoded
    @POST("post/get")
    Call<WebServiceMessage> getPostDetails(@Field("token") String token, @Field("postId") long postId);

    @FormUrlEncoded
    @POST("post/like")
    Call<WebServiceMessage> like(@Field("token") String token,@Field("postId") long postId);


    @FormUrlEncoded
    @POST("post/search")
    Call<WebServiceMessage> search(@Field("token") String token);


    @FormUrlEncoded
    @POST("posts/viral")
    Call<WebServiceMessage> getViral(@Field("token") String token);

    @FormUrlEncoded
    @POST("post/share")
    Call<WebServiceMessage> share(@Field("token") String token);


    @FormUrlEncoded
    @POST("member/get")
    Call<WebServiceMessage> getMemberDetails(@Field("token") String token, @Field("memberId") long memberId);

    @FormUrlEncoded
    @POST("members/suggestion")
    Call<WebServiceMessage> getSuggestions(@Field("token") String token);

    @FormUrlEncoded
    @POST("logs/get/all")
    Call<WebServiceMessage> getEventLogs(@Field("token") String token);

    @FormUrlEncoded
    @POST("followers/get/requests")
    Call<WebServiceMessage> getFollowRequests(@Field("token") String token);

    @FormUrlEncoded
    @POST("followers/confirm")
    Call<WebServiceMessage> getConfirmRequest(@Field("token") String token, @Field("memberId") long memberId);

    @FormUrlEncoded
    @POST("followers/reject")
    Call<WebServiceMessage> getRejectRequest(@Field("token") String token, @Field("memberId") long memberId);

    @FormUrlEncoded
    @POST("followers/get/list")
    Call<WebServiceMessage> getFollowersList(@Field("token") String token);



    @FormUrlEncoded
    @POST("followings/get/list")
    Call<WebServiceMessage> getFollowingsList(@Field("token") String token);

    @FormUrlEncoded
    @POST("followings/unfollow")
    Call<WebServiceMessage> unFollow(@Field("token") String token, @Field("memberId") long memberId);

    @FormUrlEncoded
    @POST("followings/send/request")
    Call<WebServiceMessage> requestFollow(@Field("token") String token, @Field("memberId") long memberId);



    @FormUrlEncoded
    @POST("comment/send/file")
    Call<WebServiceMessage> sendFileComment(@Field("token") String token, @Field("file") String file);

    @FormUrlEncoded
    @POST("comment/send/text")
    Call<WebServiceMessage> sendTextComment(@Field("token") String token, @Field("text") String text);

    @FormUrlEncoded
    @POST("comment/reply/file")
    Call<WebServiceMessage> replyFileComment(@Field("token") String token, @Field("file") String file, @Field("commentId") long commentId);

    @FormUrlEncoded
    @POST("comment/reply/text")
    Call<WebServiceMessage> replyTextComment(@Field("token") String token, @Field("text") String text, @Field("commentId") long commentId);


    @FormUrlEncoded
    @POST("friends/search")
    Call<WebServiceMessage> searchFriends(@Field("token") String token);

}
