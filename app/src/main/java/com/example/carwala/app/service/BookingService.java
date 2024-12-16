package com.example.carwala.app.service;

import com.example.carwala.app.entity.Booking;
import com.example.carwala.app.entity.Car;
import com.example.carwala.app.entity.User;

import java.time.LocalDate;
import java.util.List;

public interface BookingService {

    Booking createBooking(Booking booking);
    List<Booking> getBookingsByUser(User user);
    List<Booking> getBookingsByCar(Car car);
    List<Booking> findBookingsWithinDateRange(LocalDate startDate, LocalDate endDate);
    List<Booking> findBookingsByDateRanges(
            LocalDate startDateStart, LocalDate startDateEnd,
            LocalDate endDateStart, LocalDate endDateEnd);
}
