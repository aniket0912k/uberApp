package com.aniket.uberApp.strategies;

import com.aniket.uberApp.entities.RideRequest;

public interface RideFareCalculationStrategy {
    static final double FARE_MULTIPLIER = 10.0;
    double calculateFare(RideRequest rideRequest);
}
