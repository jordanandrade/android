package com.example.vgxchange.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

@Entity(tableName = "game")
public class GameEntity {
    @PrimaryKey
    @NotNull
    public String id ;
    @ColumnInfo
    public String name ;
    @ColumnInfo
    public String description ;
    @ColumnInfo
    public int rating ;



    public GameEntity(@NotNull String id, String name, String description, int rating) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "GameEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameEntity that = (GameEntity) o;
        return rating == that.rating &&
                id.equals(that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description);
    }
}

