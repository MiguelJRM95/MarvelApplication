package com.migueljrm95.marvelservice.marvel.infrastructure.adapters.output.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.migueljrm95.marvelservice.marvel.domain.model.MarvelComic;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "comic")
public class MarvelComicEntity {
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "comics", cascade = {CascadeType.MERGE})
    @JsonIgnore
    private List<MarvelCharacterEntity> characters;

    public MarvelComic toDomain(){
        return new MarvelComic(id, name, characters.stream().map(MarvelCharacterEntity::toDomain).toList());
    }

    public static MarvelComicEntity fromDomain(MarvelComic marvelComic){
        var entity = new MarvelComicEntity();
        entity.setId(marvelComic.getId());
        entity.setName(marvelComic.getName());
        entity.setCharacters(marvelComic.getCharacters().stream().map(MarvelCharacterEntity::fromDomain).toList());
        return  entity;
    }
}
