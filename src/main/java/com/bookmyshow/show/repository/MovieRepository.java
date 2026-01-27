package com.bookmyshow.show.repository;

import com.bookmyshow.show.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("""
        SELECT DISTINCT m
        FROM Show s
        JOIN s.movie m
        JOIN s.screen sc
        JOIN sc.theatre t
        JOIN t.city c
        WHERE c.id = :cityId
    """)
    List<Movie> findMoviesByCity(@Param("cityId") Long cityId);
}
