package com.aniket.uberApp.strategies;

import com.aniket.uberApp.dto.RideRequestDTO;
import com.aniket.uberApp.entities.Driver;
import com.aniket.uberApp.entities.RideRequest;

import java.util.List;

public interface DriverMatchingStrategy {
    List<Driver> findMatchingDriver(RideRequest rideRequest);
}
