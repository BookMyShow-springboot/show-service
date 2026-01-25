package com.bookmyshow.show.service;

import com.bookmyshow.show.dto.TheatreRequest;
import com.bookmyshow.show.dto.TheatreResponse;

public interface TheatreService {

    TheatreResponse createTheatre(TheatreRequest theatreRequest);
}
