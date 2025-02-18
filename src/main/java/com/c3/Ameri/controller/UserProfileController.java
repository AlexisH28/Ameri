package com.c3.Ameri.controller;

import com.c3.Ameri.dto.UserProfileDTO;
import com.c3.Ameri.entity.User;
import com.c3.Ameri.service.UserProfileService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profiles")
public class UserProfileController {

    private final UserProfileService userProfileService;

    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @GetMapping
    public UserProfileDTO getUserProfile(@AuthenticationPrincipal UserDetails userDetails) {
        User user = new User();
        user.setUsername(userDetails.getUsername());
        return userProfileService.getUserProfile(user);
    }

    @PutMapping
    public void updateUserProfile(@AuthenticationPrincipal UserDetails userDetails, @RequestBody UserProfileDTO dto) {
        User user = new User();
        user.setUsername(userDetails.getUsername());
        userProfileService.updateUserProfile(user, dto);
    }
}
