package com.aniket.uberApp.controllers;

import com.aniket.uberApp.dto.*;
import com.aniket.uberApp.services.RiderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rider")
@RequiredArgsConstructor
public class RiderController {

    private final RiderService riderService;

    @PostMapping("/requestRide")
    public ResponseEntity<RideRequestDTO> requestRide(@RequestBody RideRequestDTO rideRequestDTO) {
        return ResponseEntity.ok(riderService.requestRide(rideRequestDTO));
    }
    @PostMapping("/cancelRide/{rideId}")
    public ResponseEntity<RideDTO> cancelRide(@PathVariable Long rideId) {
        return ResponseEntity.ok(riderService.cancelRide(rideId));
    }
    @PostMapping("/rateDriver/")
    public ResponseEntity<DriverDTO> rateDriver(@RequestBody RatingDTO ratingDTO) {
        return ResponseEntity.ok(riderService.rateDriver(ratingDTO.getRideId(), ratingDTO.getRating()));
    }
    @GetMapping("/profile")
    public ResponseEntity<RiderDTO> getProfile(){
        return ResponseEntity.ok(riderService.getMyProfile());
    }
    @GetMapping("/rides")
    public ResponseEntity<Page<RideDTO>> getRiderService(@RequestParam(defaultValue = "0") Integer pageOffset,
                                                         @RequestParam(defaultValue = "10", required=false) Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageOffset, pageSize,
                Sort.by(Sort.Direction.DESC, "createdTime", "id"));
        return ResponseEntity.ok(riderService.getAllMyRides(pageRequest));
    }
    @PostMapping("/rateDriver/{rateId}")
    public ResponseEntity<DriverDTO> rateDriver(@PathVariable Long rideId, @PathVariable Integer rating){
        return ResponseEntity.ok(riderService.rateDriver(rideId, rating));
    }
}
