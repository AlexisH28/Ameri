package com.c3.Ameri.dto.Request;

import jakarta.validation.constraints.NotBlank;

 public class AuthenticationRequest {

    @NotBlank(message = "Username or Email is required.")
    private String usernameOrEmail;

    @NotBlank(message = "Password is required.")
    private String password;

    public AuthenticationRequest() {
    }

    public AuthenticationRequest(String usernameOrEmail, String password) {
        this.usernameOrEmail = usernameOrEmail;
        this.password = password;
    }

    // Getters y Setters
    public String getUsernameOrEmail() {
        return usernameOrEmail;
    }

    public void setUsernameOrEmail(String usernameOrEmail) {
        this.usernameOrEmail = usernameOrEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
