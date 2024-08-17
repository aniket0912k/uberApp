package com.aniket.uberApp.strategies;

import com.aniket.uberApp.strategies.impl.DriverMatchingHighestRatedDriverStrategy;
import com.aniket.uberApp.strategies.impl.DriverMatchingNearestDriverStrategy;
import com.aniket.uberApp.strategies.impl.RideFareDefaultFareCalculationStrategy;
import com.aniket.uberApp.strategies.impl.RideFareSurgePricingFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@RequiredArgsConstructor
public class RideStrategyManager {

    public final DriverMatchingHighestRatedDriverStrategy driverMatchingHighestRatedDriverStrategy;
    public final DriverMatchingNearestDriverStrategy driverMatchingNearestDriverStrategy;
    public final RideFareDefaultFareCalculationStrategy rideFareDefaultFareCalculationStrategy;
    public final RideFareSurgePricingFareCalculationStrategy rideFareSurgePricingFareCalculationStrategy;

    public RideFareCalculationStrategy getRideFareCalculationStrategy() {
        //6 to 9 PM will be surge time
        LocalTime surgeStartTime = LocalTime.of(18, 0);
        LocalTime surgeEndTime = LocalTime.of(21, 0);
        boolean isSurgeTime = LocalTime.now().isAfter(surgeStartTime) && LocalTime.now().isBefore(surgeEndTime);
        if (isSurgeTime)
            return rideFareSurgePricingFareCalculationStrategy;
        else
            return rideFareDefaultFareCalculationStrategy;
    }

    public DriverMatchingStrategy getDriverMatchingStrategy(Double rating) {
        if (rating >= 4.0)
            return driverMatchingHighestRatedDriverStrategy;
        else
            return driverMatchingNearestDriverStrategy;
    }


}
