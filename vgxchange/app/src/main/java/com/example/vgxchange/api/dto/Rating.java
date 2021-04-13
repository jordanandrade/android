package com.example.vgxchange.api.dto;

public class Rating {
    public String idRatingUser ;
    public String idRatingProduct ;
    public int rating;
    public String comment;

    public Rating(String idRatingUser, String idRatingProduct, int rating, String comment) {
        this.idRatingUser = idRatingUser;
        this.idRatingProduct = idRatingProduct;
        this.rating = rating;
        this.comment = comment;
    }

    public String getIdRatingUser() {
        return idRatingUser;
    }

    public String getIdRatingProduct() {
        return idRatingProduct;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public void setIdRatingUser(String idRatingUser) {
        this.idRatingUser = idRatingUser;
    }

    public void setIdRatingProduct(String idRatingProduct) {
        this.idRatingProduct = idRatingProduct;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
