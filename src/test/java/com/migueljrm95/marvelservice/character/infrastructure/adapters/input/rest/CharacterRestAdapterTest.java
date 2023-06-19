package com.migueljrm95.marvelservice.character.infrastructure.adapters.input.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.migueljrm95.marvelservice.character.domain.model.Character;
import com.migueljrm95.marvelservice.character.domain.service.CharacterService;
import com.migueljrm95.marvelservice.character.infrastructure.adapters.input.rest.resource.CharacterRequest;
import com.migueljrm95.marvelservice.comic.domain.service.ComicService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CharacterRestAdapter.class)
class CharacterRestAdapterTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CharacterService characterService;

    @MockBean
    private ComicService comicService;

    @Test
    void getCharacters() throws Exception {
        when(characterService.getCharacters()).
                thenReturn(Collections.emptyList());

        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/characters"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void getCharacter() throws Exception {
        final Long characterId = 1L;

        final Character character = new Character(
                characterId,
                "Foo",
                null,
                null
        );

        when(characterService.getCharacterById(characterId)).
                thenReturn(character);

        when(comicService.getComics())
                .thenReturn(Collections.emptyList());

        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/characters/{id}", characterId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.comics").isEmpty());
    }

    @Test
    void createCharacter() throws Exception {
        final Long characterId = 1L;

        final Character character = new Character(
                characterId,
                "Foo",
                "new character",
                null
        );

        final CharacterRequest characterRequest = new CharacterRequest(
                "Foo",
                "new character",
                null
        );

        final String requestBody = new ObjectMapper().writeValueAsString(characterRequest);


        when(characterService.createCharacter(any(Character.class)))
                .thenReturn(character);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/api/v1/characters")
                .content(requestBody).contentType(MediaType.APPLICATION_JSON);

        this.mockMvc.perform(request)
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").isNotEmpty());
    }

    @Test
    void updateCharacter() throws Exception {
        final Long characterId = 1L;

        final Character character = new Character(
                characterId,
                "Foo",
                "Updated Character",
                null
        );

        final CharacterRequest characterRequest = new CharacterRequest(
                "Foo",
                "Updated Character",
                null
        );

        final String requestBody = new ObjectMapper().writeValueAsString(characterRequest);


        when(characterService.updateCharacter(any(Long.class), any(Character.class)))
                .thenReturn(character);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.put("/api/v1/characters/{id}", characterId)
                .content(requestBody).contentType(MediaType.APPLICATION_JSON);

        this.mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").isNotEmpty());
    }

    @Test
    void deleteCharacter() throws Exception {
        final Long characterId = 1L;

        doNothing().when(characterService).deleteCharacter(characterId);

        this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/characters/{id}", characterId))
                .andExpect(status().isOk());
    }
}