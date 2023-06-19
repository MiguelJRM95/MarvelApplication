package com.migueljrm95.marvelservice.character.application.ports.input;

import com.migueljrm95.marvelservice.character.infrastructure.adapters.input.rest.resource.CharacterDetailResponse;
import com.migueljrm95.marvelservice.character.infrastructure.adapters.input.rest.resource.CharacterRequest;
import com.migueljrm95.marvelservice.character.infrastructure.adapters.input.rest.resource.CharacterResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CharacterController {
    ResponseEntity<List<CharacterResponse>> getCharacters();
    ResponseEntity<CharacterDetailResponse> getCharacter(Long characterId);
    ResponseEntity<CharacterResponse> createCharacter(CharacterRequest characterRequest);
    ResponseEntity<CharacterResponse> updateCharacter(Long id, CharacterRequest characterRequest);
    ResponseEntity<Void> deleteCharacter(Long id);
}
