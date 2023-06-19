package com.migueljrm95.marvelservice.shared.config;

import com.migueljrm95.marvelservice.character.application.ports.output.CharacterPort;
import com.migueljrm95.marvelservice.character.domain.service.CharacterService;
import com.migueljrm95.marvelservice.comic.application.ports.output.ComicPort;
import com.migueljrm95.marvelservice.comic.domain.service.ComicService;
import com.migueljrm95.marvelservice.marvel.domain.config.DumpMarvelCharactersJob;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public CharacterService characterService(CharacterPort characterPort){return new CharacterService(characterPort);}

    @Bean
    public ComicService comicService(ComicPort comicPort){
        return new ComicService(comicPort);
    }

    @Bean
    public DumpMarvelCharactersJob dumpMarvelCharactersJob(){return new DumpMarvelCharactersJob();}
}
