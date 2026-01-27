package com.bookmyshow.show.mapper;

import com.bookmyshow.show.dto.MovieResponse;
import com.bookmyshow.show.entity.Movie;

public class MovieMapper {

    public static MovieResponse toDto(Movie movie) {
        return new MovieResponse(
                movie.getId(),
                movie.getName(),
                movie.getLanguage(),
                movie.getGenre(),
                movie.getDurationMinutes(),
                movie.getReleaseDate()
        );
    }
}
