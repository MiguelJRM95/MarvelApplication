package com.migueljrm95.marvelservice.character.infrastructure.adapters.input.rest;

import com.migueljrm95.marvelservice.character.application.ports.input.CharacterController;
import com.migueljrm95.marvelservice.character.domain.service.CharacterService;
import com.migueljrm95.marvelservice.character.infrastructure.adapters.input.rest.resource.CharacterDetailResponse;
import com.migueljrm95.marvelservice.character.infrastructure.adapters.input.rest.resource.CharacterRequest;
import com.migueljrm95.marvelservice.character.infrastructure.adapters.input.rest.resource.CharacterResponse;
import com.migueljrm95.marvelservice.comic.domain.service.ComicService;
import com.migueljrm95.marvelservice.comic.infrastructure.adapters.input.rest.resource.ComicResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@Tag(name = "Characters Controller", description = "You can manage and request info about characters.")
@RequiredArgsConstructor
@RequestMapping("${spring.data.rest.base-path}/characters")
public class CharacterRestAdapter implements CharacterController {
    private final CharacterService characterService;
    private final ComicService comicService;
    @GetMapping
    public ResponseEntity<List<CharacterResponse>> getCharacters(){
        var characters = characterService.getCharacters();
        var charactersResponse = characters.stream().map(CharacterResponse::fromDomain).toList();
        return ResponseEntity.ok(charactersResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CharacterDetailResponse> getCharacter(@PathVariable(name = "id") Long characterId){
        var character = characterService.getCharacterById(characterId);
        var comicsAppearances = comicService.getComics().stream()
                .filter(comic ->
                        comic.characters().stream().anyMatch(character1 -> Objects.equals(character1.getId(), character.getId()))
                ).map(ComicResponse::fromDomain).toList();
        var characterDetailResponse = CharacterDetailResponse.fromDomain(character, comicsAppearances);
        return ResponseEntity.ok(characterDetailResponse);
    }

    @PostMapping
    public ResponseEntity<CharacterResponse> createCharacter(@Valid @RequestBody CharacterRequest characterRequest){
        var createdCharacter = characterService.createCharacter(characterRequest.toDomain());
        var characterDetailResponse = CharacterResponse.fromDomain(createdCharacter);
        return ResponseEntity.status(HttpStatus.CREATED).body(characterDetailResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CharacterResponse> updateCharacter(@PathVariable(name = "id") Long characterId, @RequestBody CharacterRequest characterRequest){
        var updatedCharacter = characterService.updateCharacter(characterId, characterRequest.toDomain());
        var characterDetailResponse = CharacterResponse.fromDomain(updatedCharacter);
        return ResponseEntity.status(HttpStatus.OK).body(characterDetailResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCharacter(@PathVariable(name = "id") Long characterId){
        characterService.deleteCharacter(characterId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

