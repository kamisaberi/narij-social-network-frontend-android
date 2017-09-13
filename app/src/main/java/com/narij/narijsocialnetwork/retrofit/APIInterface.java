package com.narij.narijsocialnetwork.retrofit;

import com.narij.narijsocialnetwork.model.WebServiceMessage;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by kami on 8/4/2017.
 */

public interface APIInterface {


    @FormUrlEncoded
    @POST("authenticate")
    Call<WebServiceMessage> authenticate(
            @Field("token") String phone
    );


    @FormUrlEncoded
    @POST("register/enterPhoneNumber")
    Call<WebServiceMessage> enterPhoneNumber(
            @Field("phone") String phone
    );

    @FormUrlEncoded
    @POST("register/confirmVerificationCode")
    Call<WebServiceMessage> enterVerificationCode(
            @Field("phone") String phone,
            @Field("verificationCode") String verificationCode
    );

    @FormUrlEncoded
    @POST("register/createPassword")
    Call<WebServiceMessage> createPassword(
            @Field("token") String token,
            @Field("password") String password
    );


    @FormUrlEncoded
    @POST("profile/get")
    Call<WebServiceMessage> getProfile(@Field("token") String token, @Field("memberId") long memberId);

    @FormUrlEncoded
    @POST("profile/set")
    Call<WebServiceMessage> setProfileDetail(@Field("token") String token, @Field("fullName") String fullName, @Field("email") String email, @Field("location") String location, @Field("photo") String photo);

    @FormUrlEncoded
    @POST("profile/set/email")
    Call<WebServiceMessage> setProfileEmail(@Field("token") String token, @Field("email") String email);

    @FormUrlEncoded
    @POST("profile/confirm/email")
    Call<WebServiceMessage> confirmEmail(@Field("token") String token, @Field("verificationCode") String verificationCode);


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
    @POST("password/check")
    Call<WebServiceMessage> checkPassword(@Field("token") String token, @Field("password") String password);

    @FormUrlEncoded
    @POST("password/change")
    Call<WebServiceMessage> changePassword(@Field("token") String token, @Field("old") String oldPassword, @Field("new") String newPassword);

    @FormUrlEncoded
    @POST("login")
    Call<WebServiceMessage> login(@Field("phone") String phoneNumber, @Field("password") String password);

    @FormUrlEncoded
    @POST("password/create")
    Call<WebServiceMessage> createPassword(@Field("password") String password);

    @FormUrlEncoded
    @POST("post/create/audio")
    Call<WebServiceMessage> createAudioPost(
            @Part MultipartBody.Part file,
            @Part("token") String token,
            @Part("title") String title,
            @Part("description") String description,
            @Part("tags") String tags
    );

    @FormUrlEncoded
    @POST("post/create/photo")
    Call<WebServiceMessage> createPhotoPost(
            @Part MultipartBody.Part file,
            @Part("token") String token,
            @Part("title") String title,
            @Part("description") String description,
            @Part("tags") String tags
    );

    @FormUrlEncoded
    @POST("post/create/text")
    Call<WebServiceMessage> createTextPost(
            @Field("token") String token,
            @Field("title") String title,
            @Field("description") String description,
            @Field("tags") String tags
    );

    @Multipart
    @FormUrlEncoded
    @POST("post/create/video")
    Call<WebServiceMessage> createVideoPost(
            @Part MultipartBody.Part file,
            @Part("token") String token,
            @Part("title") String title,
            @Part("description") String description,
            @Part("tags") String tags
    );


    @FormUrlEncoded
    @POST("post/get")
    Call<WebServiceMessage> getPostDetails(@Field("token") String token, @Field("postId") long postId);

    @FormUrlEncoded
    @POST("post/like")
    Call<WebServiceMessage> like(@Field("token") String token, @Field("postId") long postId);


    @FormUrlEncoded
    @POST("post/search")
    Call<WebServiceMessage> search(@Field("token") String token, @Field("text") String text);


    @FormUrlEncoded
    @POST("posts/viral")
    Call<WebServiceMessage> getViral(@Field("token") String token);

    @FormUrlEncoded
    @POST("post/share")
    Call<WebServiceMessage> share(@Field("token") String token, @Field("receiver") long receiver, @Field("post") long post);


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
    Call<WebServiceMessage> getFollowersList(@Field("token") String token, @Field("memberId") long memberId);


    @FormUrlEncoded
    @POST("followings/get/list")
    Call<WebServiceMessage> getFollowingsList(@Field("token") String token, @Field("memberId") long memberId);

    @FormUrlEncoded
    @POST("followings/unfollow")
    Call<WebServiceMessage> unFollow(@Field("token") String token, @Field("memberId") long memberId);

    @FormUrlEncoded
    @POST("followings/follow")
    Call<WebServiceMessage> follow(@Field("token") String token, @Field("memberId") long memberId);


    @FormUrlEncoded
    @POST("followings/send/request")
    Call<WebServiceMessage> requestFollow(@Field("token") String token, @Field("memberId") long memberId);


    @FormUrlEncoded
    @POST("comment/send/file")
    Call<WebServiceMessage> sendFileComment(@Field("token") String token, @Field("file") String file);

    @FormUrlEncoded
    @POST("comment/send/text")
    Call<WebServiceMessage> comment(@Field("token") String token, @Field("content") String content, @Field("parent") long parent, @Field("object") long object);

    @FormUrlEncoded
    @POST("friends/search")
    Call<WebServiceMessage> searchFriends(@Field("token") String token, @Field("text") String text);

}
