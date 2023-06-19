package com.migueljrm95.marvelservice.marvel.domain.model;

import lombok.Data;

import java.util.List;

@Data
public class MarvelComic {
    private Long id;
    private String name;
    private List<MarvelCharacter> characters;
    public MarvelComic(Long id, String name,List<MarvelCharacter> characters){
        this.id = id;
        this.name = name;
        this.characters = characters;
    }
}
