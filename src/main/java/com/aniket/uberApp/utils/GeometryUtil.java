package com.aniket.uberApp.utils;

import com.aniket.uberApp.dto.PointDTO;
import org.locationtech.jts.geom.*;

public class GeometryUtil {
     public static Point createPoint(PointDTO pointDTO){
         GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);
         Coordinate coordinate = new Coordinate(pointDTO.getCoordinates()[0], pointDTO.getCoordinates()[1]);
         return geometryFactory.createPoint(coordinate);
     }
}
