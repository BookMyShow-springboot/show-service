package com.bookmyshow.show.controller;

import com.bookmyshow.show.dto.ScreenRequest;
import com.bookmyshow.show.dto.ScreenResponse;
import com.bookmyshow.show.service.ScreenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/screens")
@RequiredArgsConstructor
@Slf4j
public class ScreenController {

    private final ScreenService screenService;

    @PostMapping
    public ResponseEntity<ScreenResponse> createScreen(@RequestBody ScreenRequest screen) {
        log.info("Create screen request received theatreId={}, name={}, totalSeats={}",
                screen.theatreId(), screen.name(), screen.totalSeats());
        ScreenResponse created = screenService.createScreen(screen);
        log.info("Screen created successfully screenId={}", created.id());
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public ResponseEntity<List<ScreenResponse>> getAllScreensByTheatreId(@RequestParam Long theatreId) {
        log.info("Get screens by theatre request received theatreId={}", theatreId);
        List<ScreenResponse> screens = screenService.getScreensByTheatreId(theatreId);
        log.info("Get screens by theatre success theatreId={}, count={}", theatreId, screens.size());
        return ResponseEntity.ok(screens);
    }
}
