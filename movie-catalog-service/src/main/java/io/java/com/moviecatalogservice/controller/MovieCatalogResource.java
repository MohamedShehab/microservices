package io.java.com.moviecatalogservice.controller;

import io.java.com.moviecatalogservice.model.CatalogItem;
import io.java.com.moviecatalogservice.model.Rating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable String userId) {

        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.getForObject("http://localhost:8082/movies", Movie.class);
        List<Rating> ratings = Arrays.asList(
                new Rating("123", 10),
                new Rating("456", 20),
                new Rating("789", 30)
        );
        return ratings.stream().map(
                rating -> {
                    return new CatalogItem("Transformers", "desc", 5);
                }
        ).collect(Collectors.toList());
    }
}
