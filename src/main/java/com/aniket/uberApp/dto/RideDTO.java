package com.aniket.uberApp.dto;

import com.aniket.uberApp.entities.Driver;
import com.aniket.uberApp.entities.Rider;
import com.aniket.uberApp.entities.enums.PaymentMethod;
import com.aniket.uberApp.entities.enums.RideStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

public class RideDTO {

    private Long id;

    private Point pickupLocation;

    private Point dropLocation;

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
