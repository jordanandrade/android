package com.example.vgxchange.api.dto;

import java.util.List;

public class Category
{
    private String id ;
    private String label ;
    private List<Game> games;

    public String getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public List<Game> getGames() {
        return games;
    }
}
