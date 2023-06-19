package com.migueljrm95.marvelservice.comic.infrastructure.adapters.output.persistence.entity;

import com.migueljrm95.marvelservice.character.infrastructure.adapters.output.persistence.entity.CharacterEntity;
import com.migueljrm95.marvelservice.comic.domain.model.Comic;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "comic")
public class ComicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(name = "comic_character",
            joinColumns = @JoinColumn(name = "comic_id"),
            inverseJoinColumns = @JoinColumn(name = "character_id")
    )
    private List<CharacterEntity> characters;

    public Comic toDomain(){
        return new Comic(id, name, characters.stream().map(CharacterEntity::toDomain).toList());
    }

    public static ComicEntity fromDomain(Comic comic){
        var entity = new ComicEntity();
        entity.setId(comic.id());
        entity.setName(comic.name());
        entity.setCharacters(comic.characters().stream().map(CharacterEntity::fromDomain).toList());
        return entity;
    }
}
