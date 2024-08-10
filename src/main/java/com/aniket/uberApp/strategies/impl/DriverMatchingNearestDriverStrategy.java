package com.aniket.uberApp.strategies.impl;

import com.aniket.uberApp.dto.RideRequestDTO;
import com.aniket.uberApp.entities.Driver;
import com.aniket.uberApp.strategies.DriverMatchingStrategy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverMatchingNearestDriverStrategy implements DriverMatchingStrategy {
    @Override
    public List<Driver> findMatchingDriver(RideRequestDTO rideRequestDTO) {
        return List.of();
    }
}
