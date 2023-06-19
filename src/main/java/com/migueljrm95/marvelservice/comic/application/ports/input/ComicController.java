package com.migueljrm95.marvelservice.comic.application.ports.input;

import com.migueljrm95.marvelservice.comic.domain.model.Comic;
import com.migueljrm95.marvelservice.comic.infrastructure.adapters.input.rest.resource.ComicDetailResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ComicController {
    ResponseEntity<List<ComicDetailResponse>> getComics(Optional<Long> comicsNumber);
}
