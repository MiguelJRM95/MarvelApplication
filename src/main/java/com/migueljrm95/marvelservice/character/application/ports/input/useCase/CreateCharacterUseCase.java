package com.migueljrm95.marvelservice.character.application.ports.input.useCase;

import com.migueljrm95.marvelservice.character.domain.model.Character;

public interface CreateCharacterUseCase {
    Character createCharacter(Character character);
}
