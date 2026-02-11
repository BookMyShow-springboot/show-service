package com.bookmyshow.show.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public record ShowResponse(Long id, Long movieId, Long screenId, LocalDate showDate, LocalTime startTime, LocalTime endTime, BigDecimal price) {
}
