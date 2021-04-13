package com.example.vgxchange.api.dto;

import java.util.Date;

public class ProductToCreate {
    public Date Parution ;
    public double Price;
    public String PhotoLink;

    public String idUser;
    public String idGame;
    public String AnnounceType;
    public String AnnounceState;

    public ProductToCreate(Date parution, double price, String photoLink, String idUser, String idGame, String announceType, String announceState) {
        Parution = parution;
        Price = price;
        PhotoLink = photoLink;
        this.idUser = idUser;
        this.idGame = idGame;
        AnnounceType = announceType;
        AnnounceState = announceState;
    }

    public Date getParution() {
        return Parution;
    }

    public double getPrice() {
        return Price;
    }

    public String getPhotoLink() {
        return PhotoLink;
    }

    public String getIdUser() {
        return idUser;
    }

    public String getIdGame() {
        return idGame;
    }

    public String getAnnounceType() {
        return AnnounceType;
    }

    public String getAnnounceState() {
        return AnnounceState;
    }

    public void setParution(Date parution) {
        Parution = parution;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public void setPhotoLink(String photoLink) {
        PhotoLink = photoLink;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public void setIdGame(String idGame) {
        this.idGame = idGame;
    }

    public void setAnnounceType(String announceType) {
        AnnounceType = announceType;
    }

    public void setAnnounceState(String announceState) {
        AnnounceState = announceState;
    }
}
