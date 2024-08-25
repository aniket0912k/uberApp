package com.aniket.uberApp.services;

import com.aniket.uberApp.dto.DriverDTO;
import com.aniket.uberApp.dto.SignUpDTO;
import com.aniket.uberApp.dto.UserDTO;

public interface AuthService {

    //returns auth token
    String[] login(String email, String password);

    UserDTO signup(SignUpDTO signUpDto);

    DriverDTO onboardNewDriver(Long userId, String vehicleId);

    String refreshToken(String refreshToken);
}
