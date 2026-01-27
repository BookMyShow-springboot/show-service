package com.bookmyshow.show.service.impl;

import com.bookmyshow.show.dto.ScreenRequest;
import com.bookmyshow.show.dto.ScreenResponse;
import com.bookmyshow.show.entity.Screen;
import com.bookmyshow.show.entity.Theatre;
import com.bookmyshow.show.exception.ResourceNotFoundException;
import com.bookmyshow.show.mapper.ScreenMapper;
import com.bookmyshow.show.repository.ScreenRepository;
import com.bookmyshow.show.repository.TheatreRepository;
import com.bookmyshow.show.service.ScreenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScreenServiceImpl implements ScreenService {

    private final ScreenRepository screenRepository;
    private final TheatreRepository theatreRepository;

    @Override
    @Transactional
    public ScreenResponse createScreen(ScreenRequest request) {
        Screen screen = new Screen();
        screen.setName(request.name());
        screen.setTotalSeats(request.totalSeats());

        Theatre theatre = theatreRepository.findById(request.theatreId()).orElseThrow(()-> new ResourceNotFoundException("Theatre not found with id: " + request.theatreId()));
        screen.setTheatre(theatre);

        return ScreenMapper.toDto(screenRepository.save(screen));

    }

    @Override
    public List<ScreenResponse> getScreensByTheatreId(Long theatreId) {
        return screenRepository.findAllByTheatreId(theatreId)
                .stream().map(ScreenMapper::toDto).collect(Collectors.toList());
    }
}
