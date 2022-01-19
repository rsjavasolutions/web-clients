package com.rsjava.imdb.movies.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ImdbClientConnectionException extends RuntimeException {

    private static final String MESSAGE = "Can't connect with imbd client";

    public ImdbClientConnectionException() {
        super(MESSAGE);
    }
}
