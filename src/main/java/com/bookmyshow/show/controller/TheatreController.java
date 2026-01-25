package com.bookmyshow.show.controller;

import com.bookmyshow.show.dto.TheatreRequest;
import com.bookmyshow.show.dto.TheatreResponse;
import com.bookmyshow.show.service.TheatreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/theatres")
@RequiredArgsConstructor
public class TheatreController {

    private final TheatreService theatreService;

    @PostMapping
    public TheatreResponse createTheatre(@RequestBody @Valid TheatreRequest theatreRequest) {
        return theatreService.createTheatre(theatreRequest);
    }


}
