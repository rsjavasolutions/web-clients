package com.rsjava.imdb.movies.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "imdb")
public class ImdbProperties {

    private String url;
    private String apiKey;
}
