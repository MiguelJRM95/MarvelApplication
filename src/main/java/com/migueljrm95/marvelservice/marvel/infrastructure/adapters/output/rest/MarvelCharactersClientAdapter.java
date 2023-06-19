package com.migueljrm95.marvelservice.marvel.infrastructure.adapters.output.rest;

import com.migueljrm95.marvelservice.marvel.infrastructure.adapters.output.rest.resource.RootResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="marvelCharacters", url="${marvelService.marvelExternalApi.url}", path = "${marvelService.marvelExternalApi.path}")
public interface MarvelCharactersClientAdapter {
    @RequestMapping(method = RequestMethod.GET, value = "/characters")
    RootResponse getCharacters(
            @RequestParam String ts,
            @RequestParam String apikey,
            @RequestParam String hash,
            @RequestParam(required = false) Integer offset,
            @RequestParam(required = false) Integer limit
    );
}
