package com.example.vgxchange.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.vgxchange.api.dto.User;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

@Entity(tableName = "product")
public class ProductEntity {
    @PrimaryKey
    @NotNull
    public String idProduct ;
    @ColumnInfo
    public String parution ;
    @ColumnInfo
    public String announceType ;
    @ColumnInfo
    public String announceState ;
    @ColumnInfo
    public double price ;
    @ColumnInfo
    public String photoLink ;
    @Embedded
    public GameEntity gameEntity;


    public ProductEntity(@NotNull String idProduct, String parution, String announceType, String announceState, double price, String photoLink, GameEntity gameEntity) {
        this.idProduct = idProduct;
        this.parution = parution;
        this.announceType = announceType;
        this.announceState = announceState;
        this.price = price;
        this.photoLink = photoLink;
        this.gameEntity = gameEntity;
    }

//    public ProductEntity(@NotNull String idProduct, String parution, String announceType, String announceState, double price, String photoLink) {
//        this.idProduct = idProduct;
//        this.parution = parution;
//        this.announceType = announceType;
//        this.announceState = announceState;
//        this.price = price;
//        this.photoLink = photoLink;
//    }


    @Override
    public String toString() {
        return "ProductEntity{" +
                "id='" + idProduct + '\'' +
                ", parution='" + parution + '\'' +
                ", announceType='" + announceType + '\'' +
                ", announceState='" + announceState + '\'' +
                ", price=" + price +
                ", photoLink='" + photoLink + '\'' +
                ", gameEntity=" + gameEntity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return Double.compare(that.price, price) == 0 &&
                idProduct.equals(that.idProduct) &&
                Objects.equals(parution, that.parution) &&
                Objects.equals(announceType, that.announceType) &&
                Objects.equals(announceState, that.announceState) &&
                Objects.equals(photoLink, that.photoLink) &&
                Objects.equals(gameEntity, that.gameEntity);
    }

}

