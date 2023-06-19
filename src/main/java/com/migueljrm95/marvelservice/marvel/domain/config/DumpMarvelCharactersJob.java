package com.migueljrm95.marvelservice.marvel.domain.config;

import com.migueljrm95.marvelservice.marvel.domain.service.MarvelCharactersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

public class DumpMarvelCharactersJob {
    @Autowired
    private MarvelCharactersService marvelCharactersService;
    @EventListener(ApplicationReadyEvent.class)
    public void dumpMarvelCharactersJob() {
        marvelCharactersService.dumpMarvelCharactersUseCase();
    }
}
