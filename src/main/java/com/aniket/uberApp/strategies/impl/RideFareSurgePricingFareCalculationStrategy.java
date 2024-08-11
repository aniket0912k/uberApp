package com.aniket.uberApp.strategies.impl;

import com.aniket.uberApp.dto.RideRequestDTO;
import com.aniket.uberApp.entities.RideRequest;
import com.aniket.uberApp.strategies.RideFareCalculationStrategy;
import org.springframework.stereotype.Service;

@Service
public class RideFareSurgePricingFareCalculationStrategy implements RideFareCalculationStrategy {
    @Override
    public double calculateFare(RideRequest rideRequest) {
        return 0;
    }
}
