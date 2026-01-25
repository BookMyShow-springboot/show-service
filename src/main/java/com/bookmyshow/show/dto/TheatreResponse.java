package com.bookmyshow.show.dto;

import com.bookmyshow.show.entity.City;

public record TheatreResponse(Long id, String name, String address, Long cityId) {
}
