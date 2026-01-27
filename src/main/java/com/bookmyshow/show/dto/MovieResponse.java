package com.bookmyshow.show.dto;

import java.time.LocalDate;

public record MovieResponse(Long id, String name, String language, String genre, Integer durationMinutes, LocalDate releaseDate) {
}
