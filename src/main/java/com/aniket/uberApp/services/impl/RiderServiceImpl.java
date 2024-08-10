package com.aniket.uberApp.services.impl;

import com.aniket.uberApp.dto.DriverDTO;
import com.aniket.uberApp.dto.RideDTO;
import com.aniket.uberApp.dto.RideRequestDTO;
import com.aniket.uberApp.dto.RiderDTO;
import com.aniket.uberApp.services.RiderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiderServiceImpl implements RiderService {
    @Override
    public RideRequestDTO requestRide(RideRequestDTO rideRequestDTO) {
        return null;
    }

    @Override
    public RideDTO cancelRide(Long rideId) {
        return null;
    }

    @Override
    public DriverDTO rateDriver(Long rideId, Integer rating) {
        return null;
    }

    @Override
    public RiderDTO getMyProfile() {
        return null;
    }

    @Override
    public List<RideDTO> getAllMyRides() {
        return List.of();
    }
}
