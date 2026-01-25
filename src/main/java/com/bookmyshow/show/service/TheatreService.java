package com.bookmyshow.show.service;

import java.util.List;

import com.bookmyshow.show.dto.TheatreRequest;
import com.bookmyshow.show.dto.TheatreResponse;

public interface TheatreService {

    TheatreResponse createTheatre(TheatreRequest theatreRequest);

    List<TheatreResponse> getTheatreByCityId(Long cityId);
}
