package com.bookmyshow.show.controller;

import com.bookmyshow.show.dto.ShowRequest;
import com.bookmyshow.show.dto.ShowResponse;
import com.bookmyshow.show.service.ShowService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
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
public class ShowController {


    private final ShowService showService;


    @PostMapping
    public ResponseEntity<ShowResponse> createShow(@Valid @RequestBody ShowRequest showRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(showService.createShow(showRequest));
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
        return ResponseEntity.ok(showService.getShowsByMovieCityAndDate(movieId, cityId, date));
    }

}
