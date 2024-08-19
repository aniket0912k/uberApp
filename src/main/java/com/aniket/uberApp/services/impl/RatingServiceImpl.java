package com.aniket.uberApp.services.impl;

import com.aniket.uberApp.dto.DriverDTO;
import com.aniket.uberApp.dto.RiderDTO;
import com.aniket.uberApp.entities.Driver;
import com.aniket.uberApp.entities.Rating;
import com.aniket.uberApp.entities.Ride;
import com.aniket.uberApp.entities.Rider;
import com.aniket.uberApp.exceptions.ResourceNotFoundException;
import com.aniket.uberApp.repositories.DriverRepository;
import com.aniket.uberApp.repositories.RatingRepository;
import com.aniket.uberApp.repositories.RiderRepository;
import com.aniket.uberApp.services.RatingService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;
    private final DriverRepository driverRepository;
    private final RiderRepository riderRepository;
    private final ModelMapper modelMapper;

    @Override
    public DriverDTO rateDriver(Ride ride, Integer rating) {
        Rating ratingObj = ratingRepository.findByRide(ride).orElseThrow(
                ()-> new ResourceNotFoundException("Rating not found for the ride: "+ ride.getId())
        );
        if(ratingObj.getRatingForDriver() != null){
            throw new RuntimeException("Driver already rated");
        }
        ratingObj.setRatingForDriver(rating);
        ratingRepository.save(ratingObj);

        Double newRating = ratingRepository.findByDriver(ride.getDriver())
                .stream()
                .mapToDouble(Rating::getRatingForDriver)
                .average().orElse(0.0);
        ride.getDriver().setRating(newRating);
        Driver savedDriver = driverRepository.save(ride.getDriver());
        return modelMapper.map(savedDriver, DriverDTO.class);

    }

    @Override
    public RiderDTO rateRider(Ride ride, Integer rating) {
        Rider rider = ride.getRider();
        Rating ratingObj = ratingRepository.findByRide(ride).orElseThrow(
                ()-> new ResourceNotFoundException("Rating not found for the ride: "+ ride.getId())
        );
        if(ratingObj.getRatingforRider() != null){
            throw new RuntimeException("Rider already rated");
        }
        ratingObj.setRatingforRider(rating);
        ratingRepository.save(ratingObj);

        Double newRating = ratingRepository.findByRider(rider)
                .stream()
                .mapToDouble(Rating::getRatingforRider)
                .average().orElse(0.0);
        rider.setRating(newRating);
        Rider savedRider = riderRepository.save(rider);
        return modelMapper.map(savedRider, RiderDTO.class);
    }

    @Override
    public void createNewRating(Ride ride) {
        Rating rating = Rating.builder()
                .rider(ride.getRider())
                .driver(ride.getDriver())
                .ride(ride)
                .build();
        ratingRepository.save(rating);
    }
}
