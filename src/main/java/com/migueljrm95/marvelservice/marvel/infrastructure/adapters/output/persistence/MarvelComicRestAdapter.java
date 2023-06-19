package com.migueljrm95.marvelservice.marvel.infrastructure.adapters.output.persistence;

import com.migueljrm95.marvelservice.marvel.application.ports.output.MarvelComicPort;
import com.migueljrm95.marvelservice.marvel.domain.model.MarvelComic;
import com.migueljrm95.marvelservice.marvel.infrastructure.adapters.output.persistence.entity.MarvelComicEntity;
import com.migueljrm95.marvelservice.marvel.infrastructure.adapters.output.persistence.repository.MarvelComicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MarvelComicRestAdapter implements MarvelComicPort {
    private final MarvelComicRepository marvelComicRepository;

    @Override
    public void createComic(MarvelComic marvelComic) {
        marvelComicRepository.save(MarvelComicEntity.fromDomain(marvelComic)).toDomain();
    }
}
