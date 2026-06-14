package com.smartclinic.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

/**

* Service responsible for generating and validating JWT tokens.
* Used for securing authentication and authorization in the Smart Clinic system.
  */
  @Service
  public class TokenService {

  @Value("${jwt.secret}")
  private String secret;

  /**

  * Generates a secure HMAC SHA signing key from the application secret.
  * This key is used to sign and verify JWT tokens.
    */
    private Key getSigningKey() {
    return Keys.hmacShaKeyFor(secret.getBytes());
    }

  /**

  * Generates a JWT token for an authenticated user.
  *
  * The token includes:
  * * Subject (user email)
  * * Issued timestamp
  * * Expiration timestamp (1 hour validity)
  *
  * @param email the authenticated user's email
  * @return signed JWT token
    */
    public String generateToken(String email) {

    try {
    long expirationTime = 1000 * 60 * 60; // 1 hour validity

    ```
     return Jwts.builder()
             .setSubject(email)
             .setIssuedAt(new Date())
             .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
             .signWith(getSigningKey(), SignatureAlgorithm.HS256)
             .compact();
    ```

    } catch (Exception e) {
    throw new RuntimeException(
    "JWT token generation failed due to an internal error", e);
    }
    }

  /**

  * Validates a JWT token by checking:
  * * Signature integrity
  * * Expiration time
  *
  * If validation fails, the method safely returns false instead of throwing an error,
  * ensuring the application remains secure and stable.
  *
  * @param token JWT token string
  * @return true if token is valid, false otherwise
    */
    public boolean validateToken(String token) {
    try {
    Jwts.parserBuilder()
    .setSigningKey(getSigningKey())
    .build()
    .parseClaimsJws(token);

    ```
     return true;
    ```

    } catch (Exception e) {
    // Token is invalid, expired, or tampered with
    return false;
    }
    }
    }
