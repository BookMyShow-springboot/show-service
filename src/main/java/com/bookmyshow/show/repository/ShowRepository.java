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
            select s
            from Show s
            join s.screen sc
            join sc.theatre t
            join t.city c
            where s.movie.id = :movieId
              and c.id = :cityId
              and s.showDate = :showDate
              and t.active = true
              and c.active = true
            order by s.startTime asc
            """)
    List<Show> findShowsByMovieCityAndDate(
            @Param("movieId") Long movieId,
            @Param("cityId") Long cityId,
            @Param("showDate") LocalDate showDate
    );
}
