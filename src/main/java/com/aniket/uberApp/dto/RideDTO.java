package com.aniket.uberApp.dto;

import com.aniket.uberApp.entities.enums.PaymentMethod;
import com.aniket.uberApp.entities.enums.RideStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RideDTO {

    private Long id;

    private PointDTO pickupLocation;

    private PointDTO dropLocation;

    private LocalDateTime createdTime;

    private RiderDTO rider;

    private DriverDTO driver;

    private PaymentMethod paymentMethod;

    private RideStatus rideStatus;

    private Double fare;

    private String otp;

    private LocalDateTime startedAt;

    private LocalDateTime endedAt;
}
