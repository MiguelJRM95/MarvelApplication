package com.migueljrm95.marvelservice.marvel.application.ports.output;

import com.migueljrm95.marvelservice.marvel.domain.model.MarvelComic;

public interface MarvelComicPort {
    void createComic(MarvelComic marvelComic);
}
