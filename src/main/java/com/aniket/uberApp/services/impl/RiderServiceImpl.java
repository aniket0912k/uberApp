package com.aniket.uberApp.services.impl;

import com.aniket.uberApp.dto.DriverDTO;
import com.aniket.uberApp.dto.RideDTO;
import com.aniket.uberApp.dto.RideRequestDTO;
import com.aniket.uberApp.dto.RiderDTO;
import com.aniket.uberApp.entities.Driver;
import com.aniket.uberApp.entities.RideRequest;
import com.aniket.uberApp.entities.Rider;
import com.aniket.uberApp.entities.User;
import com.aniket.uberApp.entities.enums.RideRequestStatus;
import com.aniket.uberApp.repositories.RideRequestRepository;
import com.aniket.uberApp.repositories.RiderRepository;
import com.aniket.uberApp.services.RiderService;
import com.aniket.uberApp.strategies.DriverMatchingStrategy;
import com.aniket.uberApp.strategies.RideFareCalculationStrategy;
import com.aniket.uberApp.strategies.RideStrategyManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RiderServiceImpl implements RiderService {

    private final ModelMapper modelMapper;
    private final RideStrategyManager rideStrategyManager;
    private final RideRequestRepository rideRequestRepository;
    private final RiderRepository riderRepository;

    @Override
    public RideRequestDTO requestRide(RideRequestDTO rideRequestDTO) {
        Rider rider = getCurrentRider();
        RideRequest rideRequest = modelMapper.map(rideRequestDTO, RideRequest.class);
        rideRequest.setRideRequestStatus(RideRequestStatus.PENDING);
        rideRequest.setRider(rider);

        Double fare = rideStrategyManager.getRideFareCalculationStrategy().calculateFare(rideRequest);
        rideRequest.setFare(fare);

        RideRequest savedRideRequest = rideRequestRepository.save(rideRequest);

        List<Driver> drivers = rideStrategyManager
                .getDriverMatchingStrategy(rider.getRating()).findMatchingDriver(rideRequest);

        return modelMapper.map(savedRideRequest, RideRequestDTO.class);
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

    @Override
    public Rider createNewRider(User user) {
        Rider rider = Rider.builder().user(user).rating(0.0).build();
        return riderRepository.save(rider);
    }

    @Override
    public Rider getCurrentRider() {
        //TODO: add the ride from spring security
        return riderRepository.findById(1L).orElseThrow(
                () -> new RuntimeException("Rider not found")
        );
    }
}
