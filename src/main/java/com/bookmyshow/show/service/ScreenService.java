package com.bookmyshow.show.service;

import com.bookmyshow.show.dto.ScreenRequest;
import com.bookmyshow.show.dto.ScreenResponse;
import com.bookmyshow.show.entity.Theatre;

import java.util.List;

public interface ScreenService {

    ScreenResponse createScreen(ScreenRequest request);

    List<ScreenResponse> getScreensByTheatreId(Long theatreId);
}
