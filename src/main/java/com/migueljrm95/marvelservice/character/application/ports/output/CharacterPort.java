package com.migueljrm95.marvelservice.character.application.ports.output;

import com.migueljrm95.marvelservice.character.domain.model.Character;

import java.util.List;

public interface CharacterPort {
    List<Character> getCharacters();
    Character getCharacterById(Long id);
    Character createCharacter(Character character);
    void deleteCharacter(Long id);
    Character updateCharacter(Long id, Character character);
}
