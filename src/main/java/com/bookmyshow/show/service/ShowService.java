package com.bookmyshow.show.service;

import com.bookmyshow.show.dto.ShowRequest;
import com.bookmyshow.show.dto.ShowResponse;
import com.bookmyshow.show.entity.Show;

public interface ShowService {

    public ShowResponse createShow(ShowRequest request);
}
