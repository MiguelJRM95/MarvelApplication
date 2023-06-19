package com.migueljrm95.marvelservice.character.infrastructure.adapters.output.persistence.repository;

import com.migueljrm95.marvelservice.character.infrastructure.adapters.output.persistence.entity.CharacterEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CharacterJpaRepositoryIT {
    @Autowired
    private CharacterJpaRepository characterJpaRepository;

    @Test
    void findCharacterByExistingId(){
        Long characterId = 1L;
        CharacterEntity character = new CharacterEntity(characterId, "Foo", "Character", "/tmp/character1.jpg", Collections.emptySet());
        characterJpaRepository.save(character);
        Optional<CharacterEntity> fetchedCharacter = characterJpaRepository.findById(characterId);
        assertThat(fetchedCharacter).isNotEmpty();
    }

    @Test
    void findCharacterByNonExistingId() {
        Long characterId = 2L;
        Optional<CharacterEntity> fetchedCharacter = characterJpaRepository.findById(characterId);
        assertThat(fetchedCharacter).isEmpty();
    }

}