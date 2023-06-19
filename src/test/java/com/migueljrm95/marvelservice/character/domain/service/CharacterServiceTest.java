package com.migueljrm95.marvelservice.character.domain.service;

import com.migueljrm95.marvelservice.character.application.ports.output.CharacterPort;
import com.migueljrm95.marvelservice.character.domain.model.Character;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CharacterServiceTest {

    @Mock
    private CharacterPort characterPort;

    @InjectMocks
    private CharacterService characterService;

    private Character character;
    @BeforeEach
    void setup(){
        character = new Character("Foo", "New Character", null);
    }

    @Test
    void createCharacter() {
        when(characterPort.createCharacter(character)).thenReturn(character);

        Character createdCharacter = characterService.createCharacter(character);

        assertThat(createdCharacter).isNotNull();
    }

    @Test
    void deleteCharacter() {
        Long characterId = 1L;

        doNothing().when(characterPort).deleteCharacter(characterId);

        characterService.deleteCharacter(characterId);

        verify(characterPort, times(1)).deleteCharacter(characterId);
    }

    @Test
    void getCharacterById() {
        Long characterId = 1L;

        when(characterPort.getCharacterById(characterId)).thenReturn(character);

        Character fetchedCharacter = characterService.getCharacterById(characterId);

        assertThat(fetchedCharacter).isNotNull();
    }

    @Test
    void getCharacters() {
        when(characterPort.getCharacters()).thenReturn(List.of(character));

        List<Character> characters = characterService.getCharacters();

        assertThat(characters.size()).isEqualTo(1);
    }

    @Test
    void updateCharacter() {
        Long characterId = 1L;

        character.setDescription("Updated Character");
        when(characterPort.updateCharacter(characterId, character)).thenReturn(character);

        Character updatedCharacter = characterService.updateCharacter(characterId, character);

        assertThat(updatedCharacter.getDescription()).isEqualTo("Updated Character");
        assertThat(updatedCharacter.getName()).isEqualTo("Foo");
    }
}