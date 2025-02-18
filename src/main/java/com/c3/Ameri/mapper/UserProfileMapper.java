package com.c3.Ameri.mapper;

import com.c3.Ameri.dto.UserProfileDTO;
import com.c3.Ameri.entity.UserProfile;
import org.springframework.stereotype.Component;

@Component
public class UserProfileMapper {

    public UserProfileDTO toDTO(UserProfile userProfile) {
        UserProfileDTO dto = new UserProfileDTO();
        dto.setBio(userProfile.getBio());
        dto.setAvatarUrl(userProfile.getAvatarUrl());
        dto.setLocation(userProfile.getLocation());
        dto.setWebsiteUrl(userProfile.getWebsiteUrl());
        return dto;
    }

    public UserProfile toEntity(UserProfileDTO dto) {
        UserProfile userProfile = new UserProfile();
        userProfile.setBio(dto.getBio());
        userProfile.setAvatarUrl(dto.getAvatarUrl());
        userProfile.setLocation(dto.getLocation());
        userProfile.setWebsiteUrl(dto.getWebsiteUrl());
        return userProfile;
    }
}
