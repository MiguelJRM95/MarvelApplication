package com.migueljrm95.marvelservice.marvel.infrastructure.adapters.output.persistence.entity;

import com.migueljrm95.marvelservice.marvel.domain.model.MarvelCharacter;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@Table(name = "character")
public class MarvelCharacterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(name = "image_url")
    private String imageUrl;

    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(name = "comic_character",
            joinColumns = @JoinColumn(name = "character_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "comic_id", referencedColumnName = "id")
    )
    private Set<MarvelComicEntity> comics = new HashSet<>();

    public MarvelCharacter toDomain(){
        return new MarvelCharacter(
                id,
                name,
                description,
                imageUrl,
                comics.stream().map(MarvelComicEntity::toDomain).collect(Collectors.toSet())
        );
    }

    public static MarvelCharacterEntity fromDomain(MarvelCharacter marvelCharacter){
        var entity = new MarvelCharacterEntity();
        entity.setName(marvelCharacter.getName());
        entity.setDescription(marvelCharacter.getDescription());
        entity.setImageUrl(marvelCharacter.getImageUrl());
        entity.setComics(marvelCharacter.getComics().stream().map(MarvelComicEntity::fromDomain).collect(Collectors.toSet()));
        return  entity;
    }

}
