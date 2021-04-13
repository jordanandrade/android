package com.example.vgxchange.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.vgxchange.database.entity.GameEntity;

import java.util.List;

@Dao
public interface GameDao {
    @Query("SELECT * FROM game")
    List<GameEntity> getAll();
    @Query("SELECT * FROM game WHERE id IN (:gameEntitiesIds)")
    List<GameEntity> loadAllByIds(String[] gameEntitiesIds);

    @Query("SELECT * FROM game WHERE id LIKE :gameEntityId")
    List<GameEntity> loadAllById(String gameEntityId);

    @Query("SELECT count(*) FROM game WHERE id LIKE :gameEntityId")
    int countAllById(String gameEntityId);

    @Query("SELECT * FROM game WHERE id LIKE :gameEntitiesId LIMIT 1")
    GameEntity loadById(String gameEntitiesId);

    @Query("SELECT * FROM game WHERE name LIKE :name LIMIT 1")
    GameEntity findByName(String name);
    @Insert
    void insertAll(GameEntity... gameEntities);

    @Update
    void updateAll(GameEntity... gameEntities);

    @Delete
    void delete(GameEntity gameEntity);
}
