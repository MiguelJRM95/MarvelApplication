package com.migueljrm95.marvelservice.marvel.infrastructure.adapters.output.persistence;

import com.migueljrm95.marvelservice.marvel.application.ports.output.MarvelCharactersPort;
import com.migueljrm95.marvelservice.marvel.domain.model.MarvelCharacter;
import com.migueljrm95.marvelservice.marvel.infrastructure.adapters.output.persistence.entity.MarvelCharacterEntity;
import com.migueljrm95.marvelservice.marvel.infrastructure.adapters.output.persistence.repository.MarvelCharacterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MarvelCharacterRestAdapter implements MarvelCharactersPort {
    private final MarvelCharacterRepository marvelCharacterRepository;
    @Override
    public void createCharacter(MarvelCharacter marvelCharacter) {
        marvelCharacterRepository.save(MarvelCharacterEntity.fromDomain(marvelCharacter)).toDomain();
    }
}
