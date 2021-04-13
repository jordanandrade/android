package com.example.vgxchange.api.dto;
public class Game {

    private String id;
    private String name;
    private String description;
    private int rating;
    private Category category;

    public Game(String id, String name, String description, int rating) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.rating = rating;
    }

    public Game(String id, String name, String description, int rating, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.category = category;
    }
    //public virtual List<ProductAnnounce> ProductAnnounces;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getRating() {
        return rating;
    }

    public Category getCategory() {
        return category;
    }


    @Override
    public String toString() {
        return "Game{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", category=" + category +
                '}';
    }
}