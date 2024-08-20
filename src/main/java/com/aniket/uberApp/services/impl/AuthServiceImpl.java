package com.aniket.uberApp.services.impl;

import com.aniket.uberApp.dto.DriverDTO;
import com.aniket.uberApp.dto.SignUpDTO;
import com.aniket.uberApp.dto.UserDTO;
import com.aniket.uberApp.entities.Driver;
import com.aniket.uberApp.entities.User;
import com.aniket.uberApp.entities.enums.Role;
import com.aniket.uberApp.exceptions.ResourceNotFoundException;
import com.aniket.uberApp.exceptions.RuntimeConflictException;
import com.aniket.uberApp.repositories.UserRepository;
import com.aniket.uberApp.services.AuthService;
import com.aniket.uberApp.services.DriverService;
import com.aniket.uberApp.services.RiderService;
import com.aniket.uberApp.services.WalletService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final RiderService riderService;
    private final WalletService walletService;
    private final DriverService driverService;

    @Override
    public String login(String email, String password) {
        return "";
    }

    @Override
    @Transactional
    public UserDTO signup(SignUpDTO signUpDto) {
        User user = userRepository.findByEmail(signUpDto.getEmail()).orElse(null);
        if (user != null) {
            throw new RuntimeConflictException("Cannot signup, User already exists with this email: " + signUpDto.getEmail());
        }
        User mappedUser = modelMapper.map(signUpDto, User.class);
        mappedUser.setRoles(Set.of(Role.RIDER));
        User savedUser = userRepository.save(mappedUser);

        riderService.createNewRider(savedUser);

        //TODO add wallet related service here
        walletService.createNewWallet(savedUser);

        return modelMapper.map(savedUser, UserDTO.class);
    }

    @Override
    public DriverDTO onboardNewDriver(Long userId, String vehicleId) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new ResourceNotFoundException("User not found with Id :" + userId));
        if (user.getRoles().contains(Role.DRIVER)) {
            throw new RuntimeException("user with id: " + userId + " is already a driver.");
        }
        Driver createDriver = Driver.builder()
                .rating(0.0)
                .user(user)
                .vehicleId(vehicleId)
                .available(true)
                .build();
        user.getRoles().add(Role.DRIVER);
        userRepository.save(user);
        Driver savedDriver = driverService.createNewDriver(createDriver);
        return modelMapper.map(savedDriver, DriverDTO.class);

    }
}
