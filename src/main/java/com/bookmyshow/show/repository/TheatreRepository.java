package com.bookmyshow.show.repository;

import com.bookmyshow.show.entity.Theatre;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreRepository extends JpaRepository<Theatre, Long> {

    Optional<Theatre> findByCityId(Long cityId);
    List<Theatre> findAllByCityId(Long cityId);
}
