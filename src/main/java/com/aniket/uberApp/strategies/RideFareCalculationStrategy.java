package com.aniket.uberApp.strategies;

import com.aniket.uberApp.dto.RideRequestDTO;

public interface RideFareCalculationStrategy {
    double calculateFare(RideRequestDTO rideRequestDTO);
}
