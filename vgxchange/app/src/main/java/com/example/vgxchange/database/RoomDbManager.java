package com.example.vgxchange.database;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.example.vgxchange.database.dao.GameDao;
import com.example.vgxchange.database.dao.ProductAnnounceDao;
import com.example.vgxchange.database.entity.GameEntity;
import com.example.vgxchange.database.entity.ProductEntity;

@Database(entities = {ProductEntity.class, GameEntity.class}, version = 1)
public abstract class RoomDbManager extends RoomDatabase{
    public abstract GameDao GameDao();
    public abstract ProductAnnounceDao ProductAnnounceDao();

}
