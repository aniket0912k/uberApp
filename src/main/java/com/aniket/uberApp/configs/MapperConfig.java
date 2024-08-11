package com.aniket.uberApp.configs;

import com.aniket.uberApp.dto.PointDTO;
import com.aniket.uberApp.dto.UserDTO;
import com.aniket.uberApp.entities.User;
import com.aniket.uberApp.utils.GeometryUtil;
import org.locationtech.jts.geom.Point;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public ModelMapper modelMapper(){
        ModelMapper mapper = new ModelMapper();
        mapper.typeMap(PointDTO.class, Point.class).setConverter(context ->{
            PointDTO pointDTO = context.getSource();
            return GeometryUtil.createPoint(pointDTO);
        });
        mapper.typeMap(Point.class, PointDTO.class).setConverter(context ->{
            Point point = context.getSource();
            Double coordinates[] = {point.getX(), point.getY()};
            return new PointDTO(coordinates);
        });
        mapper.addMappings(new PropertyMap<User, UserDTO>() {
            @Override
            protected void configure() {
                map().setRole(source.getRoles());
            }
        });
        return mapper;
    }
}
