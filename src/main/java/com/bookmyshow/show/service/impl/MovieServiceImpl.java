package com.bookmyshow.show.service.impl;

import com.bookmyshow.show.dto.MovieRequest;
import com.bookmyshow.show.dto.MovieResponse;
import com.bookmyshow.show.entity.Movie;
import com.bookmyshow.show.mapper.MovieMapper;
import com.bookmyshow.show.repository.MovieRepository;
import com.bookmyshow.show.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public MovieResponse createMovie(MovieRequest movieRequest) {
        Movie movie = new Movie();
        movie.setName(movieRequest.name());
        movie.setReleaseDate(movieRequest.releaseDate());
        movie.setLanguage(movieRequest.language());
        movie.setGenre(movieRequest.genre());
        movie.setDurationMinutes(movieRequest.durationMinutes());

        return MovieMapper.toDto(movieRepository.save(movie));
    }

    @Override
    public List<MovieResponse> getMoviesByCity(Long cityId) {
        return movieRepository.findMoviesByCity(cityId).stream().map(MovieMapper::toDto).toList();
    }
}
