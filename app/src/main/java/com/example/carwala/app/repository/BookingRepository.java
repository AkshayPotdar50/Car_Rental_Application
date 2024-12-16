package com.example.carwala.app.repository;

import com.example.carwala.app.entity.Car;
import com.example.carwala.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    // Find bookings where startDate and endDate fall within separate ranges
    List<Booking> findByStartDateBetweenAndEndDateBetween(
            LocalDate startDateStart, LocalDate startDateEnd,
            LocalDate endDateStart, LocalDate endDateEnd);

    // Custom query to find bookings overlapping a date range
    @Query("SELECT b FROM Booking b WHERE " +
            "(b.startDate <= :endDate AND b.endDate >= :startDate)")
    List<Booking> findBookingsWithinDateRange(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate);
}

