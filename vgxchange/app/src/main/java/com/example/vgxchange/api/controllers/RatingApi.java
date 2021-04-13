package com.example.vgxchange.api.controllers;

import com.example.vgxchange.api.dto.Rating;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RatingApi {

    @GET("/api/evaluation/{id}")
    Call<Rating> getRating();

    @POST("/api/evaluation")
    Call<Rating> postRating(@Body Rating rating);
}
