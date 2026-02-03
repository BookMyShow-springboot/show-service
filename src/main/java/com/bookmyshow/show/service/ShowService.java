package com.bookmyshow.show.service;

import com.bookmyshow.show.dto.ShowRequest;
import com.bookmyshow.show.dto.ShowResponse;

import java.time.LocalDate;
import java.util.List;

public interface ShowService {

    ShowResponse createShow(ShowRequest request);

    List<ShowResponse> getShowsByMovieCityAndDate(Long movieId, Long cityId, LocalDate showDate);
}
