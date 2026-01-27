package com.bookmyshow.show.mapper;

import com.bookmyshow.show.dto.ScreenResponse;
import com.bookmyshow.show.dto.TheatreResponse;
import com.bookmyshow.show.entity.Screen;
import com.bookmyshow.show.entity.Theatre;

public class ScreenMapper {

    public static ScreenResponse toDto(Screen screen) {
        return new ScreenResponse(
                screen.getId(),
                screen.getName(),
                screen.getTheatre().getId(),
                screen.getTotalSeats()
        );
    }
}
