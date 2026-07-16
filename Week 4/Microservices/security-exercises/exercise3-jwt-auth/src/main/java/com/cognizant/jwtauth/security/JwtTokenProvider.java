package com.cognizant.jwtauth.security;

import java.security.Key;
import java.util.Date;
import java.util.List;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.cognizant.jwtauth.config.JwtConfig;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SignatureException;

@Component
public class JwtTokenProvider {

	@Autowired
	private JwtConfig jwtConfig;

	private Key signingKey() {
		// jjwt 0.11.x expects a java.security.Key rather than a raw String,
		// unlike the jjwt 0.9.1 API used in the original exercise.
		return new SecretKeySpec(jwtConfig.getSecret().getBytes(), SignatureAlgorithm.HS256.getJcaName());
	}

	public String createToken(String username) {
		Date now = new Date();
		Date validity = new Date(now.getTime() + jwtConfig.getExpirationMs());

		return Jwts.builder()
				.setSubject(username)
				.setIssuedAt(now)
				.setExpiration(validity)
				.signWith(signingKey(), SignatureAlgorithm.HS256)
				.compact();
	}

	public boolean validateToken(String token) {
		try {
			Jwts.parserBuilder()
					.setSigningKey(signingKey())
					.build()
					.parseClaimsJws(token);
			return true;
		} catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException
				| SignatureException | IllegalArgumentException ex) {
			return false;
		}
	}

	public String getUsername(String token) {
		return parseClaims(token).getBody().getSubject();
	}

	public Authentication getAuthentication(String token) {
		String username = getUsername(token);
		// No roles/permissions are encoded in the token in this simple example,
		// so we grant a single default authority. Extend the claims map in
		// createToken(...) if you need role-based access control.
		return new UsernamePasswordAuthenticationToken(
				username, null, List.of(new SimpleGrantedAuthority("ROLE_USER")));
	}

	private Jws<Claims> parseClaims(String token) {
		return Jwts.parserBuilder()
				.setSigningKey(signingKey())
				.build()
				.parseClaimsJws(token);
	}

}
