package com.migueljrm95.marvelservice.marvel.infrastructure.adapters.output.rest.resource;

import com.migueljrm95.marvelservice.marvel.domain.model.MarvelCharacter;
import com.migueljrm95.marvelservice.marvel.domain.model.MarvelComic;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class MarvelComicResponse {
    public String resourceURI;
    public String name;
    public List<MarvelCharacter> characters = new ArrayList<>();

    public Long getMarvelApiComicId(){
        return Long.parseLong(Arrays.stream(resourceURI.split("/")).reduce((first, second) -> second).orElse(""));
    }

    public MarvelComic toDomain(){
        return new MarvelComic(getMarvelApiComicId(), name ,characters);
    }
}
