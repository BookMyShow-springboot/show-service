package com.bookmyshow.show.service.impl;

import com.bookmyshow.show.dto.ShowRequest;
import com.bookmyshow.show.dto.ShowResponse;
import com.bookmyshow.show.entity.Movie;
import com.bookmyshow.show.entity.Screen;
import com.bookmyshow.show.entity.Show;
import com.bookmyshow.show.exception.ResourceNotFoundException;
import com.bookmyshow.show.mapper.ShowMapper;
import com.bookmyshow.show.repository.MovieRepository;
import com.bookmyshow.show.repository.ScreenRepository;
import com.bookmyshow.show.repository.ShowRepository;
import com.bookmyshow.show.service.ShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ShowServiceImpl implements ShowService {

    private final ShowRepository showRepository;
    private final MovieRepository movieRepository;
    private final ScreenRepository screenRepository;

    @Override
    public ShowResponse createShow(ShowRequest request) {
        // Request is validated at controller layer via @Valid.
        Long movieId = Objects.requireNonNull(request.movieId());
        Long screenId = Objects.requireNonNull(request.screenId());

        Show show = new Show();
        Movie movie = movieRepository.findById(movieId).orElseThrow(()->
                new ResourceNotFoundException("movie not found with id " + movieId));
        show.setMovie(movie);
        Screen screen = screenRepository.findById(screenId).orElseThrow(()->
                new ResourceNotFoundException("screen not found with id " + screenId));
        show.setScreen(screen);
        show.setShowDate(request.showDate());
        show.setStartTime(request.startTime());
        show.setEndTime(request.endTime());
        show.setPrice(request.price());

        return ShowMapper.toDto(showRepository.save(show));
    }

    @Override
    public List<ShowResponse> getShowsByMovieCityAndDate(Long movieId, Long cityId, LocalDate showDate) {
        return showRepository.findShowsByMovieCityAndDate(movieId, cityId, showDate)
                .stream()
                .map(ShowMapper::toDto)
                .toList();
    }
}
