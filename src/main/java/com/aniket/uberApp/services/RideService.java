package com.aniket.uberApp.services;

import com.aniket.uberApp.dto.RideRequestDTO;
import com.aniket.uberApp.entities.Driver;
import com.aniket.uberApp.entities.Ride;
import com.aniket.uberApp.entities.RideRequest;
import com.aniket.uberApp.entities.enums.RideStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface RideService {
    Ride getRideById(Long rideId);

    void matchWithDrivers(RideRequestDTO rideRequestDTO);

    Ride createNewRide(RideRequest rideRequest, Driver driver);

    Ride updateRideStatus(Ride ride, RideStatus rideStatus);

    Page<Ride> getAllRidesOfRider(Long riderId, PageRequest pageRequest);

    Page<Ride> getAllRidesOfDriver(Long driverId, PageRequest pageRequest);
}
