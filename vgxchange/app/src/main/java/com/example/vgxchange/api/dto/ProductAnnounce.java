package com.example.vgxchange.api.dto;

public class ProductAnnounce
{
    private String id ;
    private String parution ;
    public User announcer ;
    private String announceType ;
    private String announceState ;
    private double price ;
    private String photoLink ;
    private Game game;

    public String getId() {
        return id;
    }
    public String getAnnounceType() {
        return announceType;
    }
    public String getAnnounceState() {
        return announceState;
    }
    public double getPrice() {
        return price;
    }
    public String getPhotoLink() {
        return photoLink;
    }
    public Game getGame() {
        return game;
    }
    public User getAnnouncer() {
        return announcer;
    }
    public String getParution() {
        return parution;
    }


    @Override
    public String toString() {
        return "ProductAnnounce{" +
                "id='" + id + '\'' +
                ", parution='" + parution + '\'' +
                ", announcer=" + announcer +
                ", announceType='" + announceType + '\'' +
                ", announceState='" + announceState + '\'' +
                ", price=" + price +
                ", photoLink='" + photoLink + '\'' +
                ", game=" + game +
                '}';
    }
}
