package com.cognizant.jwtsecurityapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {
    private static final String SECRET =
            "my-super-secret-jwt-signing-key-1234567890-abcdef-extra-secure-key";
    private static final Logger LOGGER =
            LoggerFactory.getLogger(AuthenticationController.class);

    private final UserDetailsService userDetailsService;

    public AuthenticationController(
            UserDetailsService userDetailsService) {

        this.userDetailsService = userDetailsService;
    }
    private UserDetails getUser(String authHeader) {

        LOGGER.info("START");

        String encodedCredentials =
                authHeader.substring("Basic ".length());

        byte[] decodedBytes =
                Base64.getDecoder().decode(encodedCredentials);

        String decodedCredentials =
                new String(decodedBytes, StandardCharsets.UTF_8);

        String username =
                decodedCredentials.split(":", 2)[0];

        LOGGER.debug("Username: {}", username);

        UserDetails user =
                userDetailsService.loadUserByUsername(username);

        LOGGER.info("END");

        return user;
    }

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(
            @RequestHeader("Authorization") String authHeader) {

        LOGGER.info("START");

        UserDetails user = getUser(authHeader);

        LOGGER.debug("Authenticated username: {}", user.getUsername());

        String token = generateJwt(user);

        Map<String, String> map = new HashMap<>();
        map.put("token", token);

        LOGGER.info("END");

        return map;
    }
    private String generateJwt(UserDetails user) {

        LOGGER.info("START");

        SecretKey key =
                Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

        long currentTime = System.currentTimeMillis();

        String token = Jwts.builder()
                .subject(user.getUsername())
                .issuedAt(new Date(currentTime))
                .expiration(new Date(currentTime + 20 * 60 * 1000))
                .signWith(key)
                .compact();

        LOGGER.info("END");

        return token;
    }
}