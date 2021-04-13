package com.example.vgxchange.api.controllers;

import com.example.vgxchange.api.dto.ProductAnnounce;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BrowsingProductAnnouncesApi {

    @GET("/api/browsing/all")
    Call<List<ProductAnnounce>> getAllProducts();
}
