package com.bookmyshow.show.service.impl;

import com.bookmyshow.show.dto.TheatreRequest;
import com.bookmyshow.show.dto.TheatreResponse;
import com.bookmyshow.show.entity.City;
import com.bookmyshow.show.entity.Theatre;
import com.bookmyshow.show.mapper.TheatreMapper;
import com.bookmyshow.show.repository.CityRepository;
import com.bookmyshow.show.repository.TheatreRepository;
import com.bookmyshow.show.service.TheatreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TheatreServiceImpl implements TheatreService {

    private final TheatreRepository theatreRepository;
    private final CityRepository cityRepository;

    @Override
    @Transactional
    public TheatreResponse createTheatre(TheatreRequest theatreRequest) {
        Long cityId = theatreRequest.cityId();
        if (cityId == null) {
            throw new IllegalArgumentException("City ID is required");
        }
        
        City city = cityRepository.findById(cityId)
                .orElseThrow(() -> new IllegalArgumentException("City not found with id: " + cityId));

        Theatre theatre = new Theatre();
        theatre.setName(theatreRequest.name());
        theatre.setAddress(theatreRequest.address());
        theatre.setCity(city);
        theatre.setActive(true);

        return TheatreMapper.toDto(theatreRepository.save(theatre));
    }
}
