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

@Service
@RequiredArgsConstructor
public class ShowServiceImpl implements ShowService {

    private final ShowRepository showRepository;
    private final MovieRepository movieRepository;
    private final ScreenRepository screenRepository;

    @Override
    public ShowResponse createShow(ShowRequest request) {
        Show show = new Show();
        Movie movie = movieRepository.findById(request.movieId()).orElseThrow(()->
                new ResourceNotFoundException("movie not found with id " + request.movieId()));
        show.setMovie(movie);
        Screen screen = screenRepository.findById(request.screenId()).orElseThrow(()->
                new ResourceNotFoundException("screen not found with id " + request.screenId()));
        show.setScreen(screen);
        show.setShowDate(request.showDate());
        show.setStartTime(request.startTime());
        show.setEndTime(request.endTime());
        show.setPrice(request.price());

        return ShowMapper.toDto(showRepository.save(show));
    }
}
