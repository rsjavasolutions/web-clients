package com.rsjava.imdb.movies.response;

import lombok.Builder;
import lombok.Getter;

import java.util.Set;

@Getter
@Builder
public class MovieWithDetailsResponse {

    private final String title;
    private final Set<MovieDetailsResponse> movies;
}
