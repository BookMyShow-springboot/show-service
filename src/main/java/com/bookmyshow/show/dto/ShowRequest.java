package com.bookmyshow.show.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public record ShowRequest(
        @NotNull(message = "movieId is required")
        @Positive(message = "movieId must be > 0")
        Long movieId,

        @NotNull(message = "screenId is required")
        @Positive(message = "screenId must be > 0")
        Long screenId,

        @NotNull(message = "showDate is required")
        LocalDate showDate,

        @NotNull(message = "startTime is required")
        LocalTime startTime,

        @NotNull(message = "endTime is required")
        LocalTime endTime,

        @NotNull(message = "price is required")
        @Positive(message = "price must be > 0")
        BigDecimal price
) {
}
