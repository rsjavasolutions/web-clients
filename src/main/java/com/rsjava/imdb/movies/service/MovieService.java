package com.rsjava.imdb.movies.service;

import com.rsjava.imdb.movies.exception.ImdbClientConnectionException;
import com.rsjava.imdb.movies.response.MovieWithDetailsResponse;
import com.rsjava.imdb.movies.webclient.ImdbFeignClient;
import com.rsjava.imdb.movies.webclient.ImdbRestTemplateWebClient;
import com.rsjava.imdb.movies.webclient.ImdbWebClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.rsjava.imdb.movies.mapper.MovieWithDetailsMapper.mapToResponse;

@Slf4j
@Service
@RequiredArgsConstructor
public class MovieService {

    private final ImdbRestTemplateWebClient imdbRestTemplateWebClient;
    private final ImdbWebClient imdbWebClient;
    private final ImdbFeignClient imdbFeignClient;

    public MovieWithDetailsResponse getMovieWithDetailsByRestTemplate(String title) {

        return mapToResponse(imdbRestTemplateWebClient.getMovieWithDetails(title));
    }

    public MovieWithDetailsResponse getMovieWithDetailsByWebClient(String title) {

        return mapToResponse(imdbWebClient.getMovieWithDetails(title));
    }

    public MovieWithDetailsResponse getMovieWithDetailsByFeign(String title) {
        MovieWithDetailsResponse movieWithDetailsResponse;

        try {
            movieWithDetailsResponse = mapToResponse(imdbFeignClient.getMovieWithDetails(title));
        } catch (Exception e) {
            throw new ImdbClientConnectionException();
        }
        return movieWithDetailsResponse;
    }
}
