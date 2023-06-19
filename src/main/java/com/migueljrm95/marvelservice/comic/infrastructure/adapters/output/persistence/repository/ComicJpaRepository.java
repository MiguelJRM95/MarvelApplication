package com.migueljrm95.marvelservice.comic.infrastructure.adapters.output.persistence.repository;

import com.migueljrm95.marvelservice.comic.infrastructure.adapters.output.persistence.entity.ComicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComicJpaRepository extends JpaRepository<ComicEntity, Long> {
}
