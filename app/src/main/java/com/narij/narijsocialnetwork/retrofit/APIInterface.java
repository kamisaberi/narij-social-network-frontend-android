package com.narij.narijsocialnetwork.retrofit;

import com.narij.narijsocialnetwork.model.retrofit.FollowsRetrofitModel;
import com.narij.narijsocialnetwork.model.retrofit.FriendsRetrofitModel;
import com.narij.narijsocialnetwork.model.retrofit.LogsRetrofitModel;
import com.narij.narijsocialnetwork.model.retrofit.MemberRetrofitModel;
import com.narij.narijsocialnetwork.model.retrofit.MessagesRetrofitModel;
import com.narij.narijsocialnetwork.model.retrofit.PostsRetrofitModel;
import com.narij.narijsocialnetwork.model.retrofit.WebServiceMessage;

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
            @Field("token") String phone,
            @Field("seconds") long second
    );


    @FormUrlEncoded
    @POST("register/enterPhoneNumber")
    Call<WebServiceMessage> enterPhoneNumber(
            @Field("phone") String phone,
            @Field("seconds") long second
    );

    @FormUrlEncoded
    @POST("register/confirmVerificationCode")
    Call<WebServiceMessage> enterVerificationCode(
            @Field("phone") String phone,
            @Field("verificationCode") String verificationCode,
            @Field("seconds") long second
    );

    @FormUrlEncoded
    @POST("register/createPassword")
    Call<WebServiceMessage> createPassword(
            @Field("phone") String token,
            @Field("password") String password,
            @Field("seconds") long second
    );


    @FormUrlEncoded
    @POST("profile/get")
    Call<WebServiceMessage> getProfile(
            @Field("token") String token,
            @Field("memberId") long memberId,
            @Field("seconds") long second
    );

    @FormUrlEncoded
    @POST("profile/set")
    Call<WebServiceMessage> setProfileDetail(
            @Field("token") String token,
            @Field("fullName") String fullName,
            @Field("email") String email,
            @Field("location") String location,
            @Field("photo") String photo,
            @Field("seconds") long second
    );

    @FormUrlEncoded
    @POST("profile/set/email")
    Call<WebServiceMessage> setProfileEmail(
            @Field("phone") String token,
            @Field("email") String email,
            @Field("seconds") long second
    );

    @FormUrlEncoded
    @POST("profile/confirm/email")
    Call<WebServiceMessage> confirmEmail(
            @Field("token") String token,
            @Field("verificationCode") String verificationCode,
            @Field("seconds") long second
    );


    @FormUrlEncoded
    @POST("profile/set/fullName")
    Call<WebServiceMessage> setProfileFullName(
            @Field("phone") String phone,
            @Field("fullName") String fullName,
            @Field("seconds") long second
    );

    @FormUrlEncoded
    @POST("profile/set/location")
    Call<WebServiceMessage> setProfileLocation(
            @Field("token") String token,
            @Field("location") String location,
            @Field("seconds") long second
    );

    @Multipart
    @POST("profile/set/photo")
    Call<WebServiceMessage> setProfilePhoto(
            @Part("phone") String phone,
            @Part MultipartBody.Part file,
            @Part("seconds") long second
    );


    @FormUrlEncoded
    @POST("password/forgot/enterPhoneNumber")
    Call<WebServiceMessage> enterPhoneNumberToRecoverPassword(
            @Field("phone") String phone,
            @Field("seconds") long second
    );

    @FormUrlEncoded
    @POST("password/forgot/enterEmail")
    Call<WebServiceMessage> enterEmailToRecoverPassword(
            @Field("email") String email,
            @Field("seconds") long second
    );

    @FormUrlEncoded
    @POST("password/check")
    Call<WebServiceMessage> checkPassword(
            @Field("token") String token,
            @Field("password") String password,
            @Field("seconds") long second
    );

    @FormUrlEncoded
    @POST("password/change")
    Call<WebServiceMessage> changePassword(
            @Field("token") String token,
            @Field("old") String oldPassword,
            @Field("new") String newPassword,
            @Field("seconds") long second
    );

    @FormUrlEncoded
    @POST("login")
    Call<MemberRetrofitModel> login(
            @Field("phone") String phoneNumber,
            @Field("password") String password,
            @Field("seconds") long second
    );

    @FormUrlEncoded
    @POST("password/create")
    Call<WebServiceMessage> createPassword(
            @Field("password") String password,
            @Field("seconds") long second
    );

    @Multipart
    @POST("post/create/audio")
    Call<WebServiceMessage> createAudioPost(
            @Part MultipartBody.Part file,
            @Part("token") String token,
            @Part("title") String title,
            @Part("description") String description,
            @Part("tags") String tags,
            @Part("seconds") long second
    );

    @Multipart
    @POST("post/create/image")
    Call<WebServiceMessage> createPhotoPost(
            @Part MultipartBody.Part file,
            @Part("token") String token,
            @Part("title") String title,
            @Part("description") String description,
            @Part("tags") String tags,
            @Part("seconds") long second
    );

    @FormUrlEncoded
    @POST("post/create/text")
    Call<WebServiceMessage> createTextPost(
            @Field("token") String token,
            @Field("title") String title,
            @Field("description") String description,
            @Field("tags") String tags,
            @Field("seconds") long second
    );

    @Multipart
    @POST("post/create/video")
    Call<WebServiceMessage> createVideoPost(
            @Part MultipartBody.Part file,
            @Part("token") String token,
            @Part("title") String title,
            @Part("description") String description,
            @Part("tags") String tags,
            @Part("seconds") long second
    );


    @FormUrlEncoded
    @POST("post/get")
    Call<WebServiceMessage> getPostDetails(
            @Field("token") String token,
            @Field("postId") long postId,
            @Field("seconds") long second
    );

    @FormUrlEncoded
    @POST("post/like")
    Call<WebServiceMessage> like(
            @Field("token") String token,
            @Field("postId") long postId,
            @Field("value") int value,
            @Field("seconds") long second

    );


    @FormUrlEncoded
    @POST("post/search")
    Call<PostsRetrofitModel> searchPosts(
            @Field("token") String token,
            @Field("text") String text,
            @Field("seconds") long second
    );


    @FormUrlEncoded
    @POST("posts/viral")
    Call<PostsRetrofitModel> getViral(
            @Field("token") String token,
            @Field("type") String type,
            @Field("seconds") long second
    );

    @FormUrlEncoded
    @POST("posts/get/all")
    Call<PostsRetrofitModel> getPosts(
            @Field("token") String token,
            @Field("seconds") long second
    );


    @FormUrlEncoded
    @POST("post/share")
    Call<WebServiceMessage> share(
            @Field("token") String token,
            @Field("receiver") long receiver,
            @Field("post") long post,
            @Field("seconds") long second
    );


    @FormUrlEncoded
    @POST("member/get")
    Call<MemberRetrofitModel> getMemberDetails(
            @Field("token") String token,
            @Field("memberId") long memberId,
            @Field("seconds") long second
    );


    @FormUrlEncoded
    @POST("logs/get/all")
    Call<LogsRetrofitModel> getLogs(
            @Field("token") String token,
            @Field("memberId") long memberId,
            @Field("seconds") long second
    );


    @FormUrlEncoded
    @POST("messages/get/all")
    Call<MessagesRetrofitModel> getMessages(
            @Field("token") String token,
            @Field("memberId") long memberId,
            @Field("seconds") long second
    );


    @FormUrlEncoded
    @POST("messages/get/conversation")
    Call<MessagesRetrofitModel> getConversation(
            @Field("token") String token,
            @Field("memberId") long memberId,
            @Field("seconds") long second
    );


    @FormUrlEncoded
    @POST("followers/get/requests")
    Call<WebServiceMessage> getFollowRequests(
            @Field("token") String token,
            @Field("seconds") long second
    );

    @FormUrlEncoded
    @POST("followers/confirm")
    Call<WebServiceMessage> getConfirmRequest(
            @Field("token") String token,
            @Field("memberId") long memberId,
            @Field("seconds") long second
    );

    @FormUrlEncoded
    @POST("followers/reject")
    Call<WebServiceMessage> getRejectRequest(
            @Field("token") String token,
            @Field("memberId") long memberId,
            @Field("seconds") long second
    );

    @FormUrlEncoded
    @POST("followers/get/list")
    Call<FollowsRetrofitModel> getFollowersList(
            @Field("token") String token,
            @Field("memberId") long memberId,
            @Field("seconds") long second
    );


    @FormUrlEncoded
    @POST("followings/get/list")
    Call<FollowsRetrofitModel> getFollowingsList(
            @Field("token") String token,
            @Field("memberId") long memberId,
            @Field("seconds") long second
    );

    @FormUrlEncoded
    @POST("followings/unfollow")
    Call<WebServiceMessage> unFollow(
            @Field("token") String token,
            @Field("memberId") long memberId,
            @Field("seconds") long second
    );

    @FormUrlEncoded
    @POST("followings/follow")
    Call<WebServiceMessage> follow(
            @Field("token") String token,
            @Field("memberId") long memberId,
            @Field("seconds") long second
    );


    @FormUrlEncoded
    @POST("followings/send/request")
    Call<WebServiceMessage> requestFollow(
            @Field("token") String token,
            @Field("memberId") long memberId,
            @Field("seconds") long second
    );


    @FormUrlEncoded
    @POST("comment/send/file")
    Call<WebServiceMessage> sendFileComment(
            @Field("token") String token,
            @Field("file") String file,
            @Field("seconds") long second
    );

    @FormUrlEncoded
    @POST("comment/send/text")
    Call<WebServiceMessage> comment(
            @Field("token") String token,
            @Field("content") String content,
            @Field("parent") long parent,
            @Field("object") long object,
            @Field("seconds") long second
    );


    @FormUrlEncoded
    @POST("members/suggestion")
    Call<FriendsRetrofitModel> getSuggestions(
            @Field("token") String token,
            @Field("seconds") long second
    );


    @FormUrlEncoded
    @POST("friends/search")
    Call<FriendsRetrofitModel> searchFriends(
            @Field("token") String token,
            @Field("text") String text,
            @Field("seconds") long second
    );

}
