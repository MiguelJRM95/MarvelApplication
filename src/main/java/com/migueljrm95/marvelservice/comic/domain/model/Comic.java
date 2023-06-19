package com.migueljrm95.marvelservice.comic.domain.model;

import com.migueljrm95.marvelservice.character.domain.model.Character;

import java.util.List;

public record Comic(Long id, String name, List<Character> characters) {
}
