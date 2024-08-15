package com.aniket.uberApp.services.impl;

import com.aniket.uberApp.entities.RideRequest;
import com.aniket.uberApp.exceptions.ResourceNotFoundException;
import com.aniket.uberApp.repositories.RideRequestRepository;
import com.aniket.uberApp.services.RideRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RideRequestServiceImpl implements RideRequestService {

    private final RideRequestRepository rideRequestRepository;

    @Override
    public RideRequest findRideRequestById(Long requestId) {
        return rideRequestRepository.findById(requestId).orElseThrow(() ->
            new ResourceNotFoundException("Ride request not found in the db with id: "+ requestId)
        );
    }

    @Override
    public void update(RideRequest rideRequest) {
        RideRequest toSave = rideRequestRepository.findById(rideRequest.getId()).orElseThrow(
                ()-> new ResourceNotFoundException("ride request not found with id: "+rideRequest.getId())
        );
        rideRequestRepository.save(rideRequest);
    }
}
