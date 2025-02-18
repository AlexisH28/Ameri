package com.c3.Ameri.dto.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class UpdateProfileRequest {

    @NotBlank(message = "Full name is required.")
    private String fullName;

    private String bio;

    @Pattern(regexp = "^(http|https)://.*$", message = "Profile picture must be a valid URL.")
    private String profilePicture;

    @Pattern(regexp = "^\\+?\\d{10,15}$", message = "Phone number must be valid.")
    private String phoneNumber;

    public UpdateProfileRequest() {
    }

    public UpdateProfileRequest(String fullName, String bio, String profilePicture, String phoneNumber) {
        this.fullName = fullName;
        this.bio = bio;
        this.profilePicture = profilePicture;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}