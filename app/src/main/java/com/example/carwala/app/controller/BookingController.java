package com.example.carwala.app.controller;

import com.example.carwala.app.entity.Booking;
import com.example.carwala.app.entity.Car;
import com.example.carwala.app.entity.User;
import com.example.carwala.app.service.BookingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingServiceImpl bookingService;

    @Autowired
    public BookingController(BookingServiceImpl bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        Booking createdBooking = bookingService.createBooking(booking);
        return ResponseEntity.ok(createdBooking);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Booking>> getBookingsByUser(@PathVariable Long userId) {
        User user = new User(); // Assuming you load user from a user service
        user.setId(userId);
        return ResponseEntity.ok(bookingService.getBookingsByUser(user));
    }

    @GetMapping("/car/{carId}")
    public ResponseEntity<List<Booking>> getBookingsByCar(@PathVariable Long carId) {
        Car car = new Car(); // Assuming you load car from a car service
        car.setId(carId);
        return ResponseEntity.ok(bookingService.getBookingsByCar(car));
    }

    @GetMapping("/dates")
    public ResponseEntity<List<Booking>> findBookingsWithinDateRange(
            @RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return ResponseEntity.ok(bookingService.findBookingsWithinDateRange(startDate, endDate));
    }

    @GetMapping("/ranges")
    public ResponseEntity<List<Booking>> findBookingsByDateRanges(
            @RequestParam LocalDate startDateStart, @RequestParam LocalDate startDateEnd,
            @RequestParam LocalDate endDateStart, @RequestParam LocalDate endDateEnd) {
        return ResponseEntity.ok(bookingService.findBookingsByDateRanges(
                startDateStart, startDateEnd, endDateStart, endDateEnd));
    }
}