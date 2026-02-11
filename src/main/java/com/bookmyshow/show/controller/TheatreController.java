package com.bookmyshow.show.controller;

import com.bookmyshow.show.dto.TheatreRequest;
import com.bookmyshow.show.dto.TheatreResponse;
import com.bookmyshow.show.service.TheatreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/theatres")
@RequiredArgsConstructor
@Slf4j
public class TheatreController {

    private final TheatreService theatreService;

    @PostMapping
    public TheatreResponse createTheatre(@RequestBody @Valid TheatreRequest theatreRequest) {
        log.info("Create theatre request received cityId={}, name={}", theatreRequest.cityId(), theatreRequest.name());
        TheatreResponse created = theatreService.createTheatre(theatreRequest);
        log.info("Theatre created successfully theatreId={}", created.id());
        return created;
    }

    @GetMapping
    public List<TheatreResponse> getTheatreByCityId(@RequestParam Long cityId) {
        log.info("Get theatres by city request received cityId={}", cityId);
        List<TheatreResponse> theatres = theatreService.getTheatreByCityId(cityId);
        log.info("Get theatres by city success cityId={}, count={}", cityId, theatres.size());
        return theatres;
    }
}
