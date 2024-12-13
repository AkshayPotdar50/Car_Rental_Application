package com.example.carwala.app.repository;

import com.example.carwala.app.entity.Payment;
import com.example.carwala.app.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    // Find payment by booking
    Optional<Payment> findByBooking(Booking booking);

    // Find all payments by status
    List<Payment> findByStatus(String status);
}

