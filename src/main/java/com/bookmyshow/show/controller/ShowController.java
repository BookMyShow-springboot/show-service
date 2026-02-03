package com.bookmyshow.show.controller;

import com.bookmyshow.show.dto.ShowRequest;
import com.bookmyshow.show.dto.ShowResponse;
import com.bookmyshow.show.service.ShowService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/shows")
@RequiredArgsConstructor
@Validated
@Slf4j
public class ShowController {


    private final ShowService showService;


    @PostMapping
    public ResponseEntity<ShowResponse> createShow(@Valid @RequestBody ShowRequest showRequest) {
        log.info("Create show request received movieId={}, screenId={}, showDate={}, startTime={}, endTime={}",
                showRequest.movieId(), showRequest.screenId(), showRequest.showDate(), showRequest.startTime(), showRequest.endTime());
        ShowResponse created = showService.createShow(showRequest);
        log.info("Show created successfully showId={}", created.id());
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    /**
     * For USER / BOOKING service:
     * Fetch all shows for a given movie in a city on a date.
     */
    @GetMapping
    public ResponseEntity<List<ShowResponse>> getShowsByMovieCityAndDate(
            @RequestParam
            @NotNull(message = "movieId is required")
            @Positive(message = "movieId must be > 0")
            Long movieId,

            @RequestParam
            @NotNull(message = "cityId is required")
            @Positive(message = "cityId must be > 0")
            Long cityId,

            @RequestParam
            @NotNull(message = "date is required")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate date
    ) {
        log.info("Get shows request received movieId={}, cityId={}, date={}", movieId, cityId, date);
        List<ShowResponse> shows = showService.getShowsByMovieCityAndDate(movieId, cityId, date);
        log.info("Get shows success movieId={}, cityId={}, date={}, count={}", movieId, cityId, date, shows.size());
        return ResponseEntity.ok(shows);
    }

}
