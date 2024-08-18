package com.aniket.uberApp.strategies;

import com.aniket.uberApp.entities.Payment;

public interface PaymentStrategy {

    static final Double PLATFORM_COMMISSION = 0.3;

    void processPayment(Payment payment);
}
