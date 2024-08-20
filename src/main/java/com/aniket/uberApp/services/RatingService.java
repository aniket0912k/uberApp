package com.aniket.uberApp.services;

import com.aniket.uberApp.dto.DriverDTO;
import com.aniket.uberApp.dto.RiderDTO;
import com.aniket.uberApp.entities.Ride;

public interface RatingService {
    DriverDTO rateDriver(Ride ride, Integer rating);

    RiderDTO rateRider(Ride ride, Integer rating);

    void createNewRating(Ride ride);
}
