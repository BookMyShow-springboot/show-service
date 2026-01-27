package com.bookmyshow.show.controller;

import com.bookmyshow.show.dto.ScreenRequest;
import com.bookmyshow.show.dto.ScreenResponse;
import com.bookmyshow.show.service.ScreenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/screens")
@RequiredArgsConstructor
public class ScreenController {

    private final ScreenService screenService;

    @PostMapping
    public ResponseEntity<ScreenResponse> createScreen(@RequestBody ScreenRequest screen) {
        return ResponseEntity.status(HttpStatus.CREATED).body(screenService.createScreen(screen));
    }

    @GetMapping
    public ResponseEntity<List<ScreenResponse>> getAllScreensByTheatreId(@RequestParam Long theatreId) {
        return ResponseEntity.ok(screenService.getScreensByTheatreId(theatreId));
    }
}
