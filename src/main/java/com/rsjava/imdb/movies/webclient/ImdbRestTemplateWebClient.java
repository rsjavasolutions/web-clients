package com.rsjava.imdb.movies.webclient;

import com.rsjava.imdb.movies.configuration.ImdbProperties;
import com.rsjava.imdb.movies.exception.ImdbClientConnectionException;
import com.rsjava.imdb.movies.request.MovieWithDetailsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ImdbRestTemplateWebClient {

    private final ImdbProperties imdbProperties;
    private final RestTemplate restTemplate = new RestTemplate();

    public MovieWithDetailsRequest getMovieWithDetails(String title) {
        ResponseEntity<MovieWithDetailsRequest> result = null;

        try {
            result = restTemplate.getForEntity(
                    imdbProperties.getUrl() + imdbProperties.getApiKey() + "/" + title,
                    MovieWithDetailsRequest.class
            );
        } catch (Exception e) {
            throw new ImdbClientConnectionException();
        }
        return result.getBody();
    }
}