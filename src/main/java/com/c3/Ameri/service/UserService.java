package com.c3.Ameri.service;

import com.c3.Ameri.config.JwtUtil;
import com.c3.Ameri.dto.Request.AuthenticationRequest;
import com.c3.Ameri.dto.Response.AuthenticationResponse;
import com.c3.Ameri.dto.Request.RegisterRequest;
import com.c3.Ameri.dto.Request.UpdateProfileRequest;
import com.c3.Ameri.entity.User;
import com.c3.Ameri.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public String registerUser(@Valid RegisterRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username is already taken.");
        }

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email is already registered.");
        }

        User newUser = new User();
        newUser.setFullName(request.getFullName());
        newUser.setUsername(request.getUsername());
        newUser.setEmail(request.getEmail());
        newUser.setPassword(passwordEncoder.encode(request.getPassword()));
        newUser.setBirthDate(request.getBirthDate());

        userRepository.save(newUser);

        return "User registered successfully.";
    }

    public String updateProfile(String username, UpdateProfileRequest request) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found."));

        user.setFullName(request.getFullName());
        user.setBio(request.getBio());
        user.setProfilePicture(request.getProfilePicture());
        user.setPhoneNumber(request.getPhoneNumber());

        userRepository.save(user);

        return "Profile updated successfully.";
    }

    public AuthenticationResponse authenticateUser(@Valid AuthenticationRequest request) {
        User user = userRepository.findByUsername(request.getUsernameOrEmail())
                .orElseThrow(() -> new RuntimeException("Invalid username or password."));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid username or password.");
        }

        String token = jwtUtil.generateToken(user.getUsername());
        return new AuthenticationResponse(token);
    }
}
