package com.example.vgxchange.api.controllers;

import com.example.vgxchange.api.dto.User;
import com.example.vgxchange.api.dto.UserAuthentification;
import com.example.vgxchange.api.dto.UserSubscription;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserApi {

    @GET("/api/user/3eec32ca-8b0f-496e-b63b-ca2f7819630e")
    Call<User> getUser();

    @POST("/api/register")
    Call<UserSubscription> postUserSubscription(@Body UserSubscription userSubscription);

    @POST("/api/connection")
    Call<UserAuthentification> postUserConnection(@Body UserAuthentification userAuthentification);


}
