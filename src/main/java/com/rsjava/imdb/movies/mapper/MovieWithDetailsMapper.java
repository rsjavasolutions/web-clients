package com.rsjava.imdb.movies.mapper;

import com.rsjava.imdb.movies.request.MovieWithDetailsRequest;
import com.rsjava.imdb.movies.response.MovieWithDetailsResponse;

import java.util.stream.Collectors;

public class MovieWithDetailsMapper {

    public static MovieWithDetailsResponse mapToResponse(MovieWithDetailsRequest request) {
        return MovieWithDetailsResponse.builder()
                .title(request.getExpression())
                .movies(request.getResults().stream()
                        .map(MovieDetailsMapper::mapToResponse)
                        .collect(Collectors.toSet()))
                .build();
    }
}
