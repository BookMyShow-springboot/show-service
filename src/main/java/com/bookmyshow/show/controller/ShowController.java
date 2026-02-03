package com.bookmyshow.show.controller;

import com.bookmyshow.show.dto.ShowRequest;
import com.bookmyshow.show.dto.ShowResponse;
import com.bookmyshow.show.service.ShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/show")
@RequiredArgsConstructor
public class ShowController {


    private final ShowService showService;


    @PostMapping
    public ResponseEntity<ShowResponse> createShow(@RequestBody ShowRequest showRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(showService.createShow(showRequest));
    }

}
