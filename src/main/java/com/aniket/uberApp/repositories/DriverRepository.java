package com.aniket.uberApp.repositories;

import com.aniket.uberApp.entities.Driver;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
    @Query(value = "SELECT d.*, ST_Distance(d.current_location, :pickupLocation) AS distance FROM driver d WHERE available = true AND ST_DWithin(d.currentLocation, :pickupLocation, 3000) ORDER BY distance LIMIT 10", nativeQuery = true)
    List<Driver> findTenNearestDriver(Point pickupLocation);
}
