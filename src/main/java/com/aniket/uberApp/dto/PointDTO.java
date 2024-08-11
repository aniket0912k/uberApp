package com.aniket.uberApp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PointDTO {

    private Double[] coordinates;
    private String type =  "Point";

    public PointDTO(Double[] coordinates) {
        this.coordinates = coordinates;
    }
}
