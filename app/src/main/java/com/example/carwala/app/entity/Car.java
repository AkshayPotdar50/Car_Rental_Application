package com.example.carwala.app.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="cars")
public class Car{



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private BigDecimal pricePerDay;

    @Column(nullable = false)
    private boolean available;

    @OneToMany(mappedBy = "car",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Booking> bookings;

}
