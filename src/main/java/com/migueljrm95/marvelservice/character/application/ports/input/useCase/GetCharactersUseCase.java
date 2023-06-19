package com.migueljrm95.marvelservice.character.application.ports.input.useCase;

import com.migueljrm95.marvelservice.character.domain.model.Character;

import java.util.List;

public interface GetCharactersUseCase {
    List<Character> getCharacters();
}
