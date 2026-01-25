package com.bookmyshow.show.mapper;

import com.bookmyshow.show.dto.CityResponse;
import com.bookmyshow.show.entity.City;

public class CityMapper {

    public static CityResponse toDto(City city) {
        return new CityResponse(city.getId(), city.getName(), city.getState());
    }
}
