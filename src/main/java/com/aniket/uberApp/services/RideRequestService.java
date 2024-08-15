package com.aniket.uberApp.services;

import com.aniket.uberApp.entities.RideRequest;

public interface RideRequestService {
    RideRequest findRideRequestById(Long requestId);

    void update(RideRequest rideRequest);
}
