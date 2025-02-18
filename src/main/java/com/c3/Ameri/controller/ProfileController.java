package com.c3.Ameri.controller;

import com.c3.Ameri.dto.Request.UpdateProfileRequest;
import com.c3.Ameri.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private UserService userService;

    @PutMapping("/update")
    public String updateProfile(Authentication authentication,
                                @RequestBody @Valid UpdateProfileRequest request) {
        String username = authentication.getName();
        return userService.updateProfile(username, request);
    }
}
