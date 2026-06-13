package com.smartclinic.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class TokenService {

```
@Value("${jwt.secret}")
private String secret;

/**
 * Generates secure signing key from application secret.
 * Uses HMAC SHA-based key generation for JWT signing.
 */
private Key getSigningKey() {
    return Keys.hmacShaKeyFor(secret.getBytes());
}

/**
 * Generates a JWT token for authenticated users.
 * @param email user email used as token subject
 * @return signed JWT token valid for 1 hour
 */
public String generateToken(String email) {

    try {
        long expirationTime = 1000 * 60 * 60; // 1 hour

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();

    } catch (Exception e) {
        throw new RuntimeException("Error generating JWT token", e);
    }
}

/**
 * Validates JWT token signature and expiration.
 * @param token JWT token string
 * @return true if valid, false otherwise
 */
public boolean validateToken(String token) {
    try {
        Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token);

        return true;

    } catch (Exception e) {
        return false;
    }
}
```

}
