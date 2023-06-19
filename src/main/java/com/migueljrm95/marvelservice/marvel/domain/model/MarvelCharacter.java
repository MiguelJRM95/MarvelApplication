package com.migueljrm95.marvelservice.marvel.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MarvelCharacter {
    Long id;
    String name;
    String description;
    String imageUrl;
    Set<MarvelComic> comics;

    public MarvelCharacter(String name, String description, String imageUrl, Set<MarvelComic> comics) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.comics = comics;
    }
}
