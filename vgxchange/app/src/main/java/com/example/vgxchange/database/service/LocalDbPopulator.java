package com.example.vgxchange.database.service;

import android.util.Log;

import com.example.vgxchange.api.controllers.GameApiController;
import com.example.vgxchange.api.controllers.ProductAnnounceApiController;
import com.example.vgxchange.api.dto.Game;
import com.example.vgxchange.api.dto.ProductAnnounce;
import com.example.vgxchange.database.RoomDbManager;
import com.example.vgxchange.database.entity.GameEntity;
import com.example.vgxchange.database.entity.ProductEntity;

public class LocalDbPopulator {

    private RoomDbManager db;

    public LocalDbPopulator(RoomDbManager db) {
        this.db = db;
    }

    public void populateProductsAnnounces(ProductAnnounceApiController productAnnouncesApiController) {
        Thread thread = new Thread(() -> {
            try {
                for (ProductAnnounce p : productAnnouncesApiController.getAllSynchronous()) {

                    ProductEntity productEntityFromApi = new ProductEntity(p.getId(), p.getParution(), p.getAnnounceType(), p.getAnnounceState(), p.getPrice(), p.getPhotoLink(), new GameEntity(p.getGame().getId(), p.getGame().getName(), p.getGame().getDescription(), p.getGame().getRating()));
                    if (db.ProductAnnounceDao().countAllById(p.getId()) <= 0) {
                        db.ProductAnnounceDao().insertAll(productEntityFromApi);
                    } else {
                        db.ProductAnnounceDao().updateAll(productEntityFromApi);
                    }
                }

                for (ProductEntity p : db.ProductAnnounceDao().getAll()) {
                    Log.d("ROOM PRODUCT", p.toString());
                }

            } catch (
                    Exception e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }

    public void populateGames(GameApiController gameApiController) {
        Thread thread = new Thread(() -> {
            try {
                for (Game g : gameApiController.getAllSynchronous()) {

                    GameEntity gameEntityFromApi = new GameEntity(g.getId(), g.getName(), g.getDescription(), g.getRating());
                    if (db.GameDao().countAllById(g.getId()) <= 0) {
                        db.GameDao().insertAll(gameEntityFromApi);
                    } else {
                        db.GameDao().updateAll(gameEntityFromApi);
                        Log.d("ROOM UPDATE ", "OUFNREUINFEIJNFJIEN");
                    }
                }
                for (GameEntity g : db.GameDao().getAll()) {
                    Log.d("ROOM GAME", g.toString());
                }


            } catch (
                    Exception e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }

}


