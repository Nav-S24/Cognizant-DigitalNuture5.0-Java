package com.cognizant.jwtauth.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {

	@Value("${spring.security.jwt.secret}")
	private String secret;

	@Value("${spring.security.jwt.expiration-ms}")
	private long expirationMs;

	public String getSecret() {
		return secret;
	}

	public long getExpirationMs() {
		return expirationMs;
	}

}
