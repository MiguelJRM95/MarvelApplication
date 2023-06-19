package com.migueljrm95.marvelservice.character.infrastructure.adapters.input.rest.resource;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.migueljrm95.marvelservice.character.domain.model.Character;
import com.migueljrm95.marvelservice.comic.infrastructure.adapters.input.rest.resource.ComicResponse;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public record CharacterDetailResponse(Long id, String name, String description, String imageUrl, List<ComicResponse> comics) {
    public static CharacterDetailResponse fromDomain(Character character, List<ComicResponse> comics){
        return new CharacterDetailResponse(
                character.getId(),
                character.getName(),
                character.getDescription(),
                character.getImageUrl(),
                comics
        );
    }
}
