package com.bookmyshow.show.service;

import com.bookmyshow.show.dto.CityRequest;
import com.bookmyshow.show.dto.CityResponse;

import java.util.List;

public interface CityService {

     CityResponse createCity (CityRequest cityRequest);

     List<CityResponse> getAllCities();
}
