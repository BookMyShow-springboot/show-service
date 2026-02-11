package com.bookmyshow.show.controller;


import com.bookmyshow.show.dto.MovieRequest;
import com.bookmyshow.show.dto.MovieResponse;
import com.bookmyshow.show.service.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
@Slf4j
public class MovieController {

    private final MovieService movieService;

    @PostMapping
    public ResponseEntity<MovieResponse> createMovie(@RequestBody MovieRequest movieRequest) {
        log.info("Create movie request received name={}", movieRequest.name());
        MovieResponse created = movieService.createMovie(movieRequest);
        log.info("Movie created successfully movieId={}", created.id());
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public List<MovieResponse> getMoviesByCity(@RequestParam Long cityId) {
        log.info("Get movies by city request received cityId={}", cityId);
        List<MovieResponse> movies = movieService.getMoviesByCity(cityId);
        log.info("Get movies by city success cityId={}, count={}", cityId, movies.size());
        return movies;
    }
}
