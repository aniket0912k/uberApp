package com.aniket.uberApp.dto;

import com.aniket.uberApp.entities.Rider;
import com.aniket.uberApp.entities.enums.PaymentMethod;
import com.aniket.uberApp.entities.enums.RideRequestStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RideRequestDTO {

    private Long id;

    private Point pickupLocation;

    private Point dropLocation;

    private LocalDateTime requestedTime;

    private Rider rider;

    private PaymentMethod paymentMethod;

    private RideRequestStatus rideRequestStatus;
}
