package com.migueljrm95.marvelservice.comic.infrastructure.adapters.output.persistence;

import com.migueljrm95.marvelservice.comic.application.ports.output.ComicPort;
import com.migueljrm95.marvelservice.comic.domain.model.Comic;
import com.migueljrm95.marvelservice.comic.infrastructure.adapters.output.persistence.entity.ComicEntity;
import com.migueljrm95.marvelservice.comic.infrastructure.adapters.output.persistence.repository.ComicJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ComicJpaAdapter implements ComicPort {
    private final ComicJpaRepository comicJpaRepository;
    @Override
    public List<Comic> getComics() {
        return comicJpaRepository.findAll().stream().map(ComicEntity::toDomain).toList();
    }

}
