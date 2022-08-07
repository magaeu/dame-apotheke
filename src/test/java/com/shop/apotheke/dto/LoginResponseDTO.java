package com.shop.apotheke.dto;

public class LoginResponseDTO {
    private String token;
    private String tokenType;

    public String getToken() {
        return token;
    }

    public LoginResponseDTO setToken(String token) {
        this.token = token;
        return this;
    }

    public String getTokenType() {
        return tokenType;
    }

    public LoginResponseDTO setTokenType(String tokenType) {
        this.tokenType = tokenType;
        return this;
    }
}
