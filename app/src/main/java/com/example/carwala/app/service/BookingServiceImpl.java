package com.example.carwala.app.service;

import com.example.carwala.app.entity.Booking;
import com.example.carwala.app.entity.Car;
import com.example.carwala.app.entity.User;
import com.example.carwala.app.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getBookingsByUser(User user) {
        return bookingRepository.findByUser(user);
    }

    @Override
    public List<Booking> getBookingsByCar(Car car) {
        return bookingRepository.findByCar(car);
    }

    @Override
    public List<Booking> findBookingsWithinDateRange(LocalDate startDate, LocalDate endDate) {
        return bookingRepository.findBookingsWithinDateRange(startDate, endDate);
    }

    @Override
    public List<Booking> findBookingsByDateRanges(
            LocalDate startDateStart, LocalDate startDateEnd,
            LocalDate endDateStart, LocalDate endDateEnd) {
        return bookingRepository.findByStartDateBetweenAndEndDateBetween(
                startDateStart, startDateEnd, endDateStart, endDateEnd);
    }
}
