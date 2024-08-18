package com.aniket.uberApp.services;

import com.aniket.uberApp.entities.Driver;
import com.aniket.uberApp.entities.Ride;
import com.aniket.uberApp.entities.RideRequest;
import com.aniket.uberApp.entities.Rider;
import com.aniket.uberApp.entities.enums.RideStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface RideService {
    Ride getRideById(Long rideId);

    Ride createNewRide(RideRequest rideRequest, Driver driver);

    Ride updateRideStatus(Ride ride, RideStatus rideStatus);

    Page<Ride> getAllRidesOfRider(Rider rider, PageRequest pageRequest);

    Page<Ride> getAllRidesOfDriver(Driver driver, PageRequest pageRequest);
}
