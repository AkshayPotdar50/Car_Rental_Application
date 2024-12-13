package com.example.carwala.app.repository;

import com.example.carwala.app.entity.Car;
import com.example.carwala.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.carwala.app.entity.Booking;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    // Find bookings by user
    List<Booking> findByUser(User user);

    // Find bookings by car
    List<Booking> findByCar(Car car);

    // Find bookings by date range
    List<Booking> findByStartDateBetweenAndEndDateBetween(LocalDate startDate, LocalDate endDate);

    // Check if a car is booked in a date range
    boolean existsByCarAndStartDateLessThanEqualAndEndDateGreaterThanEqual(Car car, LocalDate startDate, LocalDate endDate);
}

