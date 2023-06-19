package com.migueljrm95.marvelservice.character.infrastructure.adapters.output.persistence;

import com.migueljrm95.marvelservice.character.application.ports.output.CharacterPort;
import com.migueljrm95.marvelservice.shared.infrastructure.adapters.out.rest.exception.ResourceNotFound;
import com.migueljrm95.marvelservice.character.domain.model.Character;
import com.migueljrm95.marvelservice.character.infrastructure.adapters.output.persistence.entity.CharacterEntity;
import com.migueljrm95.marvelservice.character.infrastructure.adapters.output.persistence.repository.CharacterJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CharacterJpaAdapter implements CharacterPort {
    private final CharacterJpaRepository characterJpaRepository;

    @Override
    public List<Character> getCharacters() {
        return characterJpaRepository.findAll().stream().map(CharacterEntity::toDomain).toList();
    }

    @Override
    public Character getCharacterById(Long id) {
        return characterJpaRepository.findById(id)
                .map(CharacterEntity::toDomain)
                .orElseThrow(() -> new ResourceNotFound("Character Not Found"));
    }

    @Override
    public Character createCharacter(Character character) {
        return characterJpaRepository.save(CharacterEntity.fromDomain(character)).toDomain();
    }

    @Override
    public void deleteCharacter(Long id) {
        characterJpaRepository.deleteById(id);
    }

    @Override
    public Character updateCharacter(Long id, Character character) {
        CharacterEntity characterEntity = characterJpaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Character Not Found"));
        characterEntity.setName(character.getName());
        characterEntity.setDescription(character.getDescription());
        return characterJpaRepository.save(characterEntity).toDomain();
    }
}
