package com.aniket.uberApp.strategies.impl;

import com.aniket.uberApp.entities.RideRequest;
import com.aniket.uberApp.services.DistanceService;
import com.aniket.uberApp.strategies.RideFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RideFareDefaultFareCalculationStrategy implements RideFareCalculationStrategy {

    private final DistanceService distanceService;

    @Override
    public double calculateFare(RideRequest rideRequest) {
        double distance = distanceService.calculateDistance(rideRequest.getPickupLocation(), rideRequest.getDropLocation());
        return distance * FARE_MULTIPLIER;
    }
}
