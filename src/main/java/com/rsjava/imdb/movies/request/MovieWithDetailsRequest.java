package com.rsjava.imdb.movies.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class MovieWithDetailsRequest {
    private String expression;
    private Set<MovieDetailsRequest> results;
}
