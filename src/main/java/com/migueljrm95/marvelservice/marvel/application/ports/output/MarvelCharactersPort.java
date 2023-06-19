package com.migueljrm95.marvelservice.marvel.application.ports.output;

import com.migueljrm95.marvelservice.marvel.domain.model.MarvelCharacter;

public interface MarvelCharactersPort {
    void createCharacter(MarvelCharacter marvelCharacter);
}
