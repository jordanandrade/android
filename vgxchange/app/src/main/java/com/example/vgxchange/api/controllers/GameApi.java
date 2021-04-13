package com.example.vgxchange.api.controllers;

import com.example.vgxchange.api.dto.Game;
import com.example.vgxchange.api.dto.ProductAnnounce;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GameApi {
    @GET("/api/game/{id}")
    Call<Game> getGame();

    @GET("/api/game/all")
    Call<List<Game>> getAll();

}
