package com.migueljrm95.marvelservice.comic.infrastructure.adapters.input.rest.resource;

import com.migueljrm95.marvelservice.character.infrastructure.adapters.input.rest.resource.CharacterInfoResponse;
import com.migueljrm95.marvelservice.comic.domain.model.Comic;

import java.util.List;

public record ComicDetailResponse(Long id, String name, List<CharacterInfoResponse> characters, int charactersNumber) {
    public static ComicDetailResponse fromDomain(Comic comic){
        return new ComicDetailResponse(
                comic.id(),
                comic.name(),
                comic.characters().stream().map(CharacterInfoResponse::fromDomain).toList(),
                comic.characters().size());
    }

}
