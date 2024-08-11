package com.aniket.uberApp.strategies.impl;

import com.aniket.uberApp.dto.RideRequestDTO;
import com.aniket.uberApp.entities.Driver;
import com.aniket.uberApp.entities.RideRequest;
import com.aniket.uberApp.repositories.DriverRepository;
import com.aniket.uberApp.strategies.DriverMatchingStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class DriverMatchingNearestDriverStrategy implements DriverMatchingStrategy {
    private final DriverRepository driverRepository;
    @Override
    public List<Driver> findMatchingDriver(RideRequest rideRequest) {
        return driverRepository.findTenNearestDriver(rideRequest.getPickupLocation());
    }
}
