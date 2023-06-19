package com.migueljrm95.marvelservice.character.infrastructure.adapters.output.persistence.entity;

import com.migueljrm95.marvelservice.character.domain.model.Character;
import com.migueljrm95.marvelservice.comic.infrastructure.adapters.output.persistence.entity.ComicEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "character")
@AllArgsConstructor
@NoArgsConstructor
public class CharacterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(name = "image_url")
    private String imageUrl;

    @ManyToMany(mappedBy = "characters")
    private Set<ComicEntity> comics;

    public Character toDomain(){
        return new Character(id, name, description, imageUrl);
    }

    public static CharacterEntity fromDomain(Character character){
        var entity = new CharacterEntity();
        entity.setName(character.getName());
        entity.setDescription(character.getDescription());
        entity.setImageUrl(character.getImageUrl());
        return  entity;
    }
}
