package com.migueljrm95.marvelservice.character.infrastructure.adapters.input.rest.resource;

import com.migueljrm95.marvelservice.character.domain.model.Character;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotNull;

@Schema
public record CharacterRequest(
        @NotNull(message = "name is mandatory") @Parameter(required = true) String name,
        String description,
        String imageUrl
) {
    public Character toDomain(){
        return new Character(name, description, imageUrl);
    }
}
