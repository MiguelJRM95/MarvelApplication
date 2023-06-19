package com.migueljrm95.marvelservice.character.infrastructure.adapters.input.rest.resource;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.migueljrm95.marvelservice.character.domain.model.Character;
@JsonInclude(JsonInclude.Include.NON_NULL)
public record CharacterResponse(Long id, String name, String description, String imageUrl) {
    public static CharacterResponse fromDomain(Character character){
        return new CharacterResponse(character.getId(), character.getName(), character.getDescription(), character.getImageUrl());
    }
}
