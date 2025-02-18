package com.c3.Ameri.service;

import com.c3.Ameri.dto.UserProfileDTO;
import com.c3.Ameri.entity.User;
import com.c3.Ameri.entity.UserProfile;
import com.c3.Ameri.mapper.UserProfileMapper;
import com.c3.Ameri.repository.UserProfileRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserProfileService {

    private final UserProfileRepository userProfileRepository;
    private final UserProfileMapper userProfileMapper;

    public UserProfileService(UserProfileRepository userProfileRepository, UserProfileMapper userProfileMapper) {
        this.userProfileRepository = userProfileRepository;
        this.userProfileMapper = userProfileMapper;
    }

    public UserProfileDTO getUserProfile(User user) {
        Optional<UserProfile> userProfile = userProfileRepository.findByUser(user);
        return userProfile.map(userProfileMapper::toDTO).orElse(null);
    }

    public void updateUserProfile(User user, UserProfileDTO dto) {
        UserProfile userProfile = userProfileRepository.findByUser(user).orElse(new UserProfile());
        userProfile.setUser(user);
        userProfile.setBio(dto.getBio());
        userProfile.setAvatarUrl(dto.getAvatarUrl());
        userProfile.setLocation(dto.getLocation());
        userProfile.setWebsiteUrl(dto.getWebsiteUrl());
        userProfileRepository.save(userProfile);
    }
}
