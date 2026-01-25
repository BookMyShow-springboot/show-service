package com.bookmyshow.show.service.impl;

import com.bookmyshow.show.dto.CityRequest;
import com.bookmyshow.show.dto.CityResponse;
import com.bookmyshow.show.entity.City;
import com.bookmyshow.show.mapper.CityMapper;
import com.bookmyshow.show.repository.CityRepository;
import com.bookmyshow.show.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public CityResponse createCity(CityRequest cityRequest) {

        City city = new City();
        city.setName(cityRequest.name());
        city.setState(cityRequest.state());
        return CityMapper.toDto(cityRepository.save(city));
    }

    @Override
    public List<CityResponse> getAllCities() {
        List<City> cities = cityRepository.findAll();
        List<CityResponse> citiesResponse = new ArrayList<>();
        for (City city : cities) {
            citiesResponse.add(CityMapper.toDto(city));
        }
        return citiesResponse;
    }
}
