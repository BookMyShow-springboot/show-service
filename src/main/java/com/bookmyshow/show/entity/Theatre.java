package com.bookmyshow.show.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Theatre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private  String address;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    private Boolean active;
}
