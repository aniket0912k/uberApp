package com.aniket.uberApp.services.impl;

import com.aniket.uberApp.services.DistanceService;
import lombok.Data;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class DistanceServiceOSRMImpl implements DistanceService {

    private static final String OSRM_API_BASE_URL = "http://router.project-osrm.org/route/v1/driving/";

    @Override
    public double calculateDistance(Point src, Point dest) {
        try {
            OSRMResponseDTO responseDTO = RestClient.builder()
                    .baseUrl(OSRM_API_BASE_URL)
                    .build()
                    .get()
                    .uri(src.getX() + "," + src.getY() + ";" + dest.getX() + "," + dest.getY())
                    .retrieve()
                    .body(OSRMResponseDTO.class);
            return responseDTO.getRoutes().get(0).getDistance() / 1000.0;
        } catch (Exception e) {
            throw new RuntimeException("Error while fetching distance from OSRM API" + e.getMessage());
        }
    }
}

@Data
class OSRMResponseDTO {
    private List<OSRMRoute> routes;
}

@Data
class OSRMRoute {
    private Double distance;
}
