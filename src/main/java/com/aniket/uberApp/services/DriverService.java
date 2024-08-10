package com.aniket.uberApp.services;

import com.aniket.uberApp.dto.DriverDTO;
import com.aniket.uberApp.dto.RideDTO;
import com.aniket.uberApp.dto.RiderDTO;

import java.util.List;

public interface DriverService {
    RideDTO acceptRide(Long rideId);
    RideDTO cancelRide(Long rideId);
    RideDTO startRide(Long rideId);
    RideDTO endRide(Long rideId);
    RiderDTO rateRider(Long rideId, Integer rating);
    DriverDTO getMyProfile();
    List<RideDTO> getAllMyRides();
}
