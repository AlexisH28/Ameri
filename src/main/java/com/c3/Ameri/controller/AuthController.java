package com.c3.Ameri.controller;

import com.c3.Ameri.dto.Request.AuthenticationRequest;
import com.c3.Ameri.dto.Response.AuthenticationResponse;
import com.c3.Ameri.dto.Request.RegisterRequest;
import com.c3.Ameri.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String register(@RequestBody @Valid RegisterRequest request) {
        return userService.registerUser(request);
    }

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody @Valid AuthenticationRequest request) {
        return userService.authenticateUser(request);
    }
}
