package com.smartclinic.service;

import org.springframework.stereotype.Service;

@Service
public class TokenService {

    // Simple token generation (demo purpose for lab)
    public String generateToken(String username) {
        return "token_" + username + "_" + System.currentTimeMillis();
    }

    // Simple validation logic
    public boolean validateToken(String token) {
        return token != null && token.startsWith("token_");
    }
}