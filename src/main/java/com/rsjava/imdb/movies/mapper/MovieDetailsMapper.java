package com.rsjava.imdb.movies.mapper;

import com.rsjava.imdb.movies.request.MovieDetailsRequest;
import com.rsjava.imdb.movies.response.MovieDetailsResponse;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MovieDetailsMapper {

    public static MovieDetailsResponse mapToResponse(MovieDetailsRequest request) {
        return MovieDetailsResponse.builder()
                .id(request.getId())
                .image(request.getImage())
                .title(request.getTitle())
                .year(extractDate(request.getDescription()))
                .build();
    }

    private static Integer extractDate(String text) {
        String date;
        Pattern pattern = Pattern.compile("\\d{4}");
        Matcher matcher = pattern.matcher(text);

        date = findMatchingOccurrence(matcher);

        try {
            return Integer.parseInt(date);
        } catch (RuntimeException e) {
            return null;
        }
    }

    private static String findMatchingOccurrence(Matcher matcher) {
        String date;
        while (true) {
            if (matcher.find()) {
                date = matcher.group();
                break;
            }
        }
        return date;
    }
}
