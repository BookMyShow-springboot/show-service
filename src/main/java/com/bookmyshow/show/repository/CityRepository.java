package com.bookmyshow.show.repository;

import com.bookmyshow.show.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    
    List<City> findByActiveTrue();
}
