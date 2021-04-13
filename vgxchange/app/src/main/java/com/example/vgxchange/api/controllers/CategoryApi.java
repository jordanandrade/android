package com.example.vgxchange.api.controllers;

import com.example.vgxchange.api.dto.Category;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CategoryApi {

    @GET("/api/test")
    Call<List<Category>> getCategories();
}
