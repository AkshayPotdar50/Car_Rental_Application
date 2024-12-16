package com.example.carwala.app.service;

import com.example.carwala.app.entity.Payment;

import java.util.List;

public interface PaymentService {
    Payment processPayment(Payment payment);
    List<Payment> getPaymentsByStatus(String status);
}

