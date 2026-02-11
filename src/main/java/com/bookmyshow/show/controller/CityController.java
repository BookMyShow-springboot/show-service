package com.bookmyshow.show.controller;

import com.bookmyshow.show.dto.CityRequest;
import com.bookmyshow.show.dto.CityResponse;
import com.bookmyshow.show.service.CityService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/city")
@Slf4j
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping
    public ResponseEntity<CityResponse> createCity(@Valid @RequestBody CityRequest cityRequest) {
        log.info("Create city request received name={}, state={}", cityRequest.name(), cityRequest.state());
        CityResponse created = cityService.createCity(cityRequest);
        log.info("City created successfully cityId={}", created.id());
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public ResponseEntity<List<CityResponse>> getAllCities() {
        log.info("Get all cities request received");
        List<CityResponse> cities = cityService.getAllCities();
        log.info("Get all cities success count={}", cities.size());
        return ResponseEntity.ok(cities);
    }
}
