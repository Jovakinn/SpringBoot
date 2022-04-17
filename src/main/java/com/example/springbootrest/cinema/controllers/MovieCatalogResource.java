package com.example.springbootrest.cinema.controllers;

import com.example.springbootrest.cinema.model.CatalogItem;
import com.example.springbootrest.cinema.model.Movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable String userId) {

        RestTemplate restTemplate = new RestTemplate();

        List<Movie> movies = Arrays.asList(
                new Movie("123", 5),
                new Movie("124", 4)
        );

        return movies.stream()
                .map(movie -> {
                    Movie mainMovie =  restTemplate.getForObject("http://127.0.0.1:9001/catalog/foo", Movie.class);
                    assert mainMovie != null;
                    return new CatalogItem(mainMovie.getMovieId(), "Greate thriller", mainMovie.getRating()); })
                .collect(toList());
    }
}
