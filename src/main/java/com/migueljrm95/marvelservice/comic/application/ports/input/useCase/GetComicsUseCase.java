package com.migueljrm95.marvelservice.comic.application.ports.input.useCase;

import com.migueljrm95.marvelservice.comic.domain.model.Comic;

import java.util.List;

public interface GetComicsUseCase {
    List<Comic> getComics();
}
