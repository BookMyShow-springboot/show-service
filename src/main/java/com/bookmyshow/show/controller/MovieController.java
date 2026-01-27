package com.bookmyshow.show.controller;


import com.bookmyshow.show.dto.MovieRequest;
import com.bookmyshow.show.dto.MovieResponse;
import com.bookmyshow.show.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping
    public ResponseEntity<MovieResponse> createMovie(@RequestBody MovieRequest movieRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.createMovie(movieRequest));
    }

    @GetMapping
    public List<MovieResponse> getMoviesByCity(@RequestParam Long cityId) {
        return movieService.getMoviesByCity(cityId);
    }
}
