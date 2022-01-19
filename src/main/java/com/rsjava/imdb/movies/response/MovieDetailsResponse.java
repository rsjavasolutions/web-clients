package com.rsjava.imdb.movies.response;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class MovieDetailsResponse {
    @EqualsAndHashCode.Include
    private String id;
    private String image;
    private String title;
    private Integer year;
}
