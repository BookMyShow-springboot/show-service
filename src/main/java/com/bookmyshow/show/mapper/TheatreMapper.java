package com.bookmyshow.show.mapper;

import com.bookmyshow.show.dto.TheatreResponse;
import com.bookmyshow.show.entity.Theatre;

public class TheatreMapper {

    public static TheatreResponse toDto(Theatre theatre) {
        return new TheatreResponse(
            theatre.getId(),
            theatre.getName(),
            theatre.getAddress(),
            theatre.getCity().getId()
        );
    }
}

