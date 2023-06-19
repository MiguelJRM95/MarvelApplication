package com.migueljrm95.marvelservice.marvel.infrastructure.adapters.output.rest.resource;

import lombok.Data;

import java.util.List;

@Data
public class MarvelComicWrapperResponse {
    public List<MarvelComicResponse> items;
}
