package com.rsjava.imdb.movies.webclient;


import com.rsjava.imdb.movies.request.MovieWithDetailsRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "imdb", url = "${imdb.url}" + "${imdb.api-key}")
public interface ImdbFeignClient {

    @GetMapping("/{expression}")
    MovieWithDetailsRequest getMovieWithDetails(@PathVariable("expression") String expression);
}
