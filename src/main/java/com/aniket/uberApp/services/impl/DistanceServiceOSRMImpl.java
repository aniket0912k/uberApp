package com.aniket.uberApp.services.impl;

import com.aniket.uberApp.services.DistanceService;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;

@Service
public class DistanceServiceOSRMImpl implements DistanceService {
    @Override
    public double calculateDistance(Point src, Point dest) {
//TODO  call the OSRM API to get the distance between src and dest
        return 0;
    }
}
