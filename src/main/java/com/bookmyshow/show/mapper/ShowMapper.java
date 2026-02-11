package com.bookmyshow.show.mapper;

import com.bookmyshow.show.dto.ShowResponse;
import com.bookmyshow.show.entity.Show;

public class ShowMapper {

    public static ShowResponse toDto(Show show) {
        return new ShowResponse(
                show.getId(),
                show.getMovie().getId(),
                show.getScreen().getId(),
                show.getShowDate(),
                show.getStartTime(),
                show.getEndTime(),
                show.getPrice()
        );
    }
}
