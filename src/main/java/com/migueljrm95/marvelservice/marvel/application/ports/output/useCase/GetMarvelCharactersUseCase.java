package com.migueljrm95.marvelservice.marvel.application.ports.output.useCase;

import com.migueljrm95.marvelservice.marvel.infrastructure.adapters.output.rest.resource.Data;
import com.migueljrm95.marvelservice.marvel.infrastructure.adapters.output.rest.resource.MarvelCharacterResponse;

import java.util.List;

public interface GetMarvelCharactersUseCase {
    List<MarvelCharacterResponse> getMarvelCharacters();
}
