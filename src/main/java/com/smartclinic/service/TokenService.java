package com.smartclinic.service;

public class TokenService {

    public String generateToken(String username) {
        return "token-" + username;
    }

    public boolean validateToken(String token) {
        return token != null && token.startsWith("token-");
    }
}