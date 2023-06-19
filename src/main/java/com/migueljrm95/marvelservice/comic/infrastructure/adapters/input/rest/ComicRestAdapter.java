package com.migueljrm95.marvelservice.comic.infrastructure.adapters.input.rest;

import com.migueljrm95.marvelservice.comic.application.ports.input.ComicController;
import com.migueljrm95.marvelservice.comic.domain.service.ComicService;
import com.migueljrm95.marvelservice.comic.infrastructure.adapters.input.rest.resource.ComicDetailResponse;
import com.migueljrm95.marvelservice.shared.infrastructure.adapters.out.rest.exception.QueryParamMissing;
import com.migueljrm95.marvelservice.shared.infrastructure.adapters.out.rest.exception.response.ExceptionResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RestController
@Tag(name = "Comics Controller", description = "You can request info about comics.")
@RequiredArgsConstructor
@RequestMapping("${spring.data.rest.base-path}/comics")
public class ComicRestAdapter implements ComicController {
    private final ComicService comicService;
    @Operation(summary = "Search comics with the most number of characters in descending order.")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Fetched the number of comics with most characters correctly.",
                    content = {
                            @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = ComicDetailResponse.class)))
                    }
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "The 'comic-quantity' have not been set.",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ExceptionResponse.class)
                            )
                    }
            )
    })
    @GetMapping
    public ResponseEntity<List<ComicDetailResponse>> getComics(@RequestParam(value = "comic-quantity") @Parameter(required = true) Optional<Long> comicsNumber){
        var comics = comicService.getComics();
        var comicsDetailResponse = comics.stream().map(ComicDetailResponse::fromDomain)
                .sorted(Comparator.comparingInt(ComicDetailResponse::charactersNumber).reversed())
                .limit(comicsNumber.orElseThrow(() -> new QueryParamMissing("The param 'comic-quantity' is missing in the url with the number of comics.")))
                .toList();
        return ResponseEntity.ok(comicsDetailResponse);
    }

}
