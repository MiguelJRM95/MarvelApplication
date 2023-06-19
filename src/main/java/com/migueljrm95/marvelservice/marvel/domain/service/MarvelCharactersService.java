package com.migueljrm95.marvelservice.marvel.domain.service;

import com.migueljrm95.marvelservice.marvel.application.ports.output.MarvelCharactersPort;
import com.migueljrm95.marvelservice.marvel.application.ports.output.MarvelComicPort;
import com.migueljrm95.marvelservice.marvel.application.ports.output.useCase.DumpMarvelCharactersUseCase;
import com.migueljrm95.marvelservice.marvel.application.ports.output.useCase.GetMarvelCharactersUseCase;
import com.migueljrm95.marvelservice.marvel.domain.model.MarvelApiAuthentication;
import com.migueljrm95.marvelservice.marvel.infrastructure.adapters.output.rest.MarvelCharactersClientAdapter;
import com.migueljrm95.marvelservice.marvel.infrastructure.adapters.output.rest.resource.MarvelCharacterResponse;
import com.migueljrm95.marvelservice.marvel.infrastructure.adapters.output.rest.resource.RootResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class MarvelCharactersService implements GetMarvelCharactersUseCase, DumpMarvelCharactersUseCase {

    private MarvelCharactersClientAdapter marvelCharactersClientAdapter;
    private MarvelApiAuthentication marvelApiAuthentication;
    private final MarvelCharactersPort marvelCharactersPort;
    private final MarvelComicPort marvelComicPort;

    @Override
    public List<MarvelCharacterResponse> getMarvelCharacters() {
        int totalMarvelCharacters;
        int offset = 0;
        List<MarvelCharacterResponse> allMarvelCharactersResponse = new ArrayList<>();
        final int LIMIT = 100;
        final int HALF_OF_TOTAL_MARVEL_CHARACTERS = 2;

        do {
            RootResponse rootResponse = marvelCharactersClientAdapter.getCharacters(
                    marvelApiAuthentication.getTs(),
                    marvelApiAuthentication.getPublicKey(),
                    marvelApiAuthentication.generateHash(),
                    offset,
                    LIMIT
            );
            totalMarvelCharacters = (int) Math.floor((double) rootResponse.getData().getTotal() / HALF_OF_TOTAL_MARVEL_CHARACTERS);
            allMarvelCharactersResponse.addAll(rootResponse.getData().getResults());
            offset += LIMIT;
        }while (allMarvelCharactersResponse.size() < totalMarvelCharacters);

        return allMarvelCharactersResponse;
    }

    @Override
    @Transactional
    public void dumpMarvelCharactersUseCase() {
        List<MarvelCharacterResponse> marvelCharacterResponseList = this.getMarvelCharacters();
        marvelCharacterResponseList.forEach(marvelCharacterResponse -> {
            marvelCharacterResponse.comics.items.forEach(item -> {
                marvelComicPort.createComic(item.toDomain());
            });

            marvelCharactersPort.createCharacter(marvelCharacterResponse.toDomain());
        });
    }
}
