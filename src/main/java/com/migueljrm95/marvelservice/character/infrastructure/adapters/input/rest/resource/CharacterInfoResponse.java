package com.migueljrm95.marvelservice.character.infrastructure.adapters.input.rest.resource;

import com.migueljrm95.marvelservice.character.domain.model.Character;

public record CharacterInfoResponse(Long id, String name) {
    public static CharacterInfoResponse fromDomain(Character character){
        return new CharacterInfoResponse(character.getId(), character.getName());
    }
}
