package com.aniket.uberApp.services.impl;

import com.aniket.uberApp.dto.DriverDTO;
import com.aniket.uberApp.dto.SignUpDTO;
import com.aniket.uberApp.dto.UserDTO;
import com.aniket.uberApp.services.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public String login(String email, String password) {
        return "";
    }

    @Override
    public UserDTO signup(SignUpDTO signUpDto) {
        return null;
    }

    @Override
    public DriverDTO onboardNewDriver(Long userId) {
        return null;
    }
}
