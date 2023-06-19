package com.migueljrm95.marvelservice.comic.application.ports.output;

import com.migueljrm95.marvelservice.comic.domain.model.Comic;

import java.util.List;

public interface ComicPort {
    List<Comic> getComics();
}
