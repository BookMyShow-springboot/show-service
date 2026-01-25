package com.bookmyshow.show.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "show", indexes = {
    @Index(name = "idx_show_movie_id", columnList = "movie_id"),
    @Index(name = "idx_show_screen_id", columnList = "screen_id"),
    @Index(name = "idx_show_date", columnList = "showDate"),
    @Index(name = "idx_show_movie_date", columnList = "movie_id,showDate")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "screen_id", nullable = false)
    private Screen screen;

    @Column(nullable = false)
    private LocalDate showDate;
    
    @Column(nullable = false)
    private LocalTime startTime;
    
    @Column(nullable = false)
    private LocalTime endTime;
    
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;
}

