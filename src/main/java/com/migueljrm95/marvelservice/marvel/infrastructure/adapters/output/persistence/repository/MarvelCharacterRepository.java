package com.migueljrm95.marvelservice.marvel.infrastructure.adapters.output.persistence.repository;

import com.migueljrm95.marvelservice.marvel.infrastructure.adapters.output.persistence.entity.MarvelCharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarvelCharacterRepository extends JpaRepository<MarvelCharacterEntity, Long> {
}
