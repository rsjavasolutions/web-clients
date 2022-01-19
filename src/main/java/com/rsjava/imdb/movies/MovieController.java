package com.rsjava.imdb.movies;

import com.rsjava.imdb.movies.response.MovieWithDetailsResponse;
import com.rsjava.imdb.movies.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("rest-template")
    @ResponseStatus(HttpStatus.OK)
    public MovieWithDetailsResponse getMoviesByRestTemplate(@RequestParam(value = "title") String title) {
        return movieService.getMovieWithDetailsByRestTemplate(title);
    }

    @GetMapping("web-client")
    @ResponseStatus(HttpStatus.OK)
    public MovieWithDetailsResponse getMoviesByWebClient(@RequestParam(value = "title") String title) {
        return movieService.getMovieWithDetailsByWebClient(title);
    }

    @GetMapping("feign")
    @ResponseStatus(HttpStatus.OK)
    public MovieWithDetailsResponse getMoviesByFeign(@RequestParam(value = "title") String title) {
        return movieService.getMovieWithDetailsByFeign(title);
    }
}
