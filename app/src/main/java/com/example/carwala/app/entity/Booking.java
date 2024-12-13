package com.example.carwala.app.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name="bookings")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional=false)
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name="car_id",nullable = false)
    private Car car;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BookingStatus status;

    @Column(nullable = false)
    private Double totalPrice;
}
