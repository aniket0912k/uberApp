package com.aniket.uberApp.services;

import com.aniket.uberApp.entities.Payment;
import com.aniket.uberApp.entities.Ride;
import com.aniket.uberApp.entities.enums.PaymentStatus;

public interface PaymentService {
    void processPayment(Ride ride);

    Payment createNewPayment(Ride ride);

    void updatePaymentStatus(Payment payment, PaymentStatus paymentStatus);
}
