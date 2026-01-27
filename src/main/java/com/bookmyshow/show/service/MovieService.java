package com.bookmyshow.show.service;

import com.bookmyshow.show.dto.MovieRequest;
import com.bookmyshow.show.dto.MovieResponse;
import com.bookmyshow.show.entity.Movie;

import java.util.List;

public interface MovieService {

    MovieResponse createMovie(MovieRequest movieRequest);

    List<MovieResponse> getMoviesByCity(Long cityId);
}
