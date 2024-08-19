package com.aniket.uberApp.controllers;

import com.aniket.uberApp.dto.*;
import com.aniket.uberApp.services.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/driver")
@RequiredArgsConstructor
public class DriverController {

    private final DriverService driverService;

    @PostMapping("/acceptRide/{rideRequestId}")
    public ResponseEntity<RideDTO> acceptRide(@PathVariable Long rideRequestId) {
        return ResponseEntity.ok(driverService.acceptRide(rideRequestId));
    }

    @PostMapping("/startRide/{rideRequestId}")
    public ResponseEntity<RideDTO> startRide(@PathVariable Long rideRequestId,
                                             @RequestBody RideStartDTO rideStartDTO) {
        return ResponseEntity.ok(driverService.startRide(rideRequestId, rideStartDTO.getOtp()));
    }

    @PostMapping("/endRide/{rideId}")
    public ResponseEntity<RideDTO> endRide(@PathVariable Long rideId) {
        return ResponseEntity.ok(driverService.endRide(rideId));
    }
    @PostMapping("/cancelRide/{rideId}")
    public ResponseEntity<RideDTO> cancelRide(@PathVariable Long rideId) {
        return ResponseEntity.ok(driverService.cancelRide(rideId));
    }
    @PostMapping("/rateRider/")
    public ResponseEntity<RiderDTO> rateRider(@RequestBody RatingDTO ratingDTO) {
        return ResponseEntity.ok(driverService.rateRider(ratingDTO.getRideId(), ratingDTO.getRating()));
    }
    @GetMapping("/profile")
    public ResponseEntity<DriverDTO> getProfile(){
        return ResponseEntity.ok(driverService.getMyProfile());
    }
    @GetMapping("/rides")
    public ResponseEntity<Page<RideDTO>> getRideService(@RequestParam(defaultValue = "0") Integer pageOffset,
                                                        @RequestParam(defaultValue = "10", required=false) Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageOffset, pageSize,
                Sort.by(Sort.Direction.DESC, "createdTime", "id"));
        return ResponseEntity.ok(driverService.getAllMyRides(pageRequest));
    }
    @PostMapping("/rateRider/{rateId}")
    public ResponseEntity<RiderDTO> rateRider(@PathVariable Long rideId, @PathVariable Integer rating){
        return ResponseEntity.ok(driverService.rateRider(rideId, rating));
    }
}
