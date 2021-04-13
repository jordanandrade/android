package com.example.vgxchange.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.vgxchange.database.entity.ProductEntity;

import java.util.List;

@Dao
public interface ProductAnnounceDao {
    @Query("SELECT * FROM product")
    List<ProductEntity> getAll();
    @Query("SELECT * FROM product WHERE idProduct IN (:productEntitiesIds)")
    List<ProductEntity> loadAllByIds(String[] productEntitiesIds);
    @Query("SELECT * FROM product WHERE idProduct LIKE :productEntitiesId LIMIT 1")
    ProductEntity loadById(String productEntitiesId);
    @Query("SELECT count(*) FROM product WHERE idProduct LIKE :productEntityId")
    int countAllById(String productEntityId);
    @Query("SELECT * FROM product WHERE name LIKE :name LIMIT 1")
    ProductEntity findByName(String name);
    @Insert
    void insertAll(ProductEntity... productEntities);

    @Update
    void updateAll(ProductEntity... productEntities);

    @Delete
    void delete(ProductEntity productEntity);


}
