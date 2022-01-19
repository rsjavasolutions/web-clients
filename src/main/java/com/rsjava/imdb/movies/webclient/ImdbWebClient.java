package com.rsjava.imdb.movies.webclient;

import com.rsjava.imdb.movies.configuration.ImdbProperties;
import com.rsjava.imdb.movies.exception.ImdbClientConnectionException;
import com.rsjava.imdb.movies.request.MovieWithDetailsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class ImdbWebClient {

    private final ImdbProperties imdbProperties;
    private final WebClient.Builder webClientBuilder;

    public MovieWithDetailsRequest getMovieWithDetails(String title) {
        MovieWithDetailsRequest movie;

        try {
            movie = webClientBuilder.build()
                    .get()
                    .uri(imdbProperties.getUrl() + imdbProperties.getApiKey() + "/" + title)
                    .retrieve()
                    .bodyToMono(MovieWithDetailsRequest.class)
                    .block();
        } catch (Exception e) {
            throw new ImdbClientConnectionException();
        }
        return movie;
    }
}