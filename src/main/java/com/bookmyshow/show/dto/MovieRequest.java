package com.bookmyshow.show.dto;

import java.time.LocalDate;

public record MovieRequest(String name, String language, String genre, Integer durationMinutes, LocalDate releaseDate) {
}
