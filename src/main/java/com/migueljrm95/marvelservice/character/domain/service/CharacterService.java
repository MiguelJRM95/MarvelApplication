package com.migueljrm95.marvelservice.character.domain.service;

import com.migueljrm95.marvelservice.character.application.ports.input.useCase.*;
import com.migueljrm95.marvelservice.character.application.ports.output.CharacterPort;
import com.migueljrm95.marvelservice.character.domain.model.Character;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CharacterService implements CreateCharacterUseCase, GetCharactersUseCase, GetCharacterUseCase, UpdateCharacterUseCase, DeleteCharacterUseCase {
    private final CharacterPort characterPort;

    @Override
    public Character createCharacter(Character character) {
        return characterPort.createCharacter(character);
    }

    @Override
    public void deleteCharacter(Long id) {
        characterPort.deleteCharacter(id);
    }

    @Override
    public Character getCharacterById(Long id) {
        return characterPort.getCharacterById(id);
    }

    @Override
    public List<Character> getCharacters() {
        return characterPort.getCharacters();
    }

    @Override
    public Character updateCharacter(Long id, Character character) {
        Character characterToUpdate = characterPort.getCharacterById(id);
        if(character.getName() == null) {
            character.setName(characterToUpdate.getName());
        }
        return characterPort.updateCharacter(id, character);
    }
}
