package com.aniket.uberApp.controllers;

import com.aniket.uberApp.advices.ApiResponse;
import com.aniket.uberApp.dto.SignUpDTO;
import com.aniket.uberApp.dto.UserDTO;
import com.aniket.uberApp.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    ApiResponse<UserDTO> signup(@RequestBody SignUpDTO signUpDto) {
        UserDTO userDTORes = authService.signup(signUpDto);
        userDTORes.getRole();
        return new ApiResponse<>(userDTORes);
    }
}
