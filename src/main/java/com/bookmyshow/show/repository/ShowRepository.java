package com.bookmyshow.show.repository;

import com.bookmyshow.show.entity.Show;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {

    @Query("""
    SELECT s
    FROM Show s
    JOIN s.movie m
    JOIN s.screen sc
    JOIN sc.theatre t
    JOIN t.city c
    WHERE m.id = :movieId
      AND c.id = :cityId
      AND s.showDate = :date
""")
    List<Show> findShowsByMovieCityAndDate(
            @Param("movieId") Long movieId,
            @Param("cityId") Long cityId,
            @Param("date") LocalDate date
    );

}
