package com.c3.Ameri.dto.Response;

public class AuthenticationResponse {
    private String token;

    // Constructor
    public AuthenticationResponse(String token) {
        this.token = token;
    }

    // Getter y Setter
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}