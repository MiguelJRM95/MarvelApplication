package com.migueljrm95.marvelservice.marvel.infrastructure.adapters.output.rest.resource;

import java.util.List;

@lombok.Data
public class Data {
    public int offset;
    public int limit;
    public int total;
    public int count;
    public List<MarvelCharacterResponse> results;
}
