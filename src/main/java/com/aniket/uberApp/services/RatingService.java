package com.aniket.uberApp.services;

import com.aniket.uberApp.dto.DriverDTO;
import com.aniket.uberApp.dto.RiderDTO;
import com.aniket.uberApp.entities.Driver;
import com.aniket.uberApp.entities.Ride;
import com.aniket.uberApp.entities.Rider;

public interface RatingService {
    DriverDTO rateDriver(Ride ride, Integer rating);
    RiderDTO rateRider(Ride ride, Integer rating);
    void createNewRating(Ride ride);
}
