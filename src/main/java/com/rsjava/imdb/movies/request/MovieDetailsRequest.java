package com.rsjava.imdb.movies.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class MovieDetailsRequest {
    @EqualsAndHashCode.Include
    private String id;
    private String image;
    private String title;
    private String description;
}
