package com.bookmyshow.show.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "theatre", indexes = {
    @Index(name = "idx_theatre_city_id", columnList = "city_id"),
    @Index(name = "idx_theatre_active", columnList = "active")
})
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Theatre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(length = 500)
    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @Column(nullable = false)
    private Boolean active = true;
}
