package com.bookmyshow.show.controller;

import com.bookmyshow.show.dto.CityRequest;
import com.bookmyshow.show.dto.CityResponse;
import com.bookmyshow.show.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping
    public ResponseEntity<CityResponse> createCity(@RequestBody CityRequest cityRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cityService.createCity(cityRequest));
    }

    @GetMapping
    public ResponseEntity<List<CityResponse>> getAllCities() {
        return ResponseEntity.status(HttpStatus.OK).body(cityService.getAllCities());
    }
}
