package com.bookmyshow.show.service.impl;

import com.bookmyshow.show.dto.CityRequest;
import com.bookmyshow.show.dto.CityResponse;
import com.bookmyshow.show.entity.City;
import com.bookmyshow.show.mapper.CityMapper;
import com.bookmyshow.show.repository.CityRepository;
import com.bookmyshow.show.service.CityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    @Transactional
    public CityResponse createCity(CityRequest cityRequest) {
        City city = new City();
        city.setName(cityRequest.name());
        city.setState(cityRequest.state());
        city.setActive(true);
        return CityMapper.toDto(cityRepository.save(city));
    }

    @Override
    @Transactional(readOnly = true)
    public List<CityResponse> getAllCities() {
        return cityRepository.findAll().stream()
                .map(CityMapper::toDto)
                .collect(Collectors.toList());
    }
}
