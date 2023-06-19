package com.migueljrm95.marvelservice.marvel.infrastructure.adapters.output.rest.resource;

import com.migueljrm95.marvelservice.marvel.domain.model.MarvelCharacter;
import lombok.Data;

import java.util.stream.Collectors;

@Data
public class MarvelCharacterResponse {
    public int id;
    public String name;
    public String description;
    public Thumbnail thumbnail;
    public MarvelComicWrapperResponse comics;

    public MarvelCharacter toDomain(){
        return new MarvelCharacter(
                name,
                description,
                thumbnail.getURL(),
                comics.items.stream().map(MarvelComicResponse::toDomain).collect(Collectors.toSet())
        );
    }
}
