package com.migueljrm95.marvelservice.comic.domain.service;

import com.migueljrm95.marvelservice.comic.application.ports.input.useCase.GetComicsUseCase;
import com.migueljrm95.marvelservice.comic.application.ports.output.ComicPort;
import com.migueljrm95.marvelservice.comic.domain.model.Comic;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ComicService implements GetComicsUseCase {
    private final ComicPort comicPort;
    @Override
    public List<Comic> getComics() {
        return comicPort.getComics();
    }
}
