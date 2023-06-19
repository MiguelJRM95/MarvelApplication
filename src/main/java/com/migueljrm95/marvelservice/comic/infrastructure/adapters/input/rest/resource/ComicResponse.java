package com.migueljrm95.marvelservice.comic.infrastructure.adapters.input.rest.resource;

import com.migueljrm95.marvelservice.comic.domain.model.Comic;

public record ComicResponse(Long id, String name) {
    public static ComicResponse fromDomain(Comic comic){
        return new ComicResponse(
                comic.id(),
                comic.name()
        );
    }
}
