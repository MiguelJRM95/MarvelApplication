package com.migueljrm95.marvelservice.character.infrastructure.adapters.output.persistence.repository;

import com.migueljrm95.marvelservice.character.infrastructure.adapters.output.persistence.entity.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterJpaRepository extends JpaRepository<CharacterEntity, Long> {
}
