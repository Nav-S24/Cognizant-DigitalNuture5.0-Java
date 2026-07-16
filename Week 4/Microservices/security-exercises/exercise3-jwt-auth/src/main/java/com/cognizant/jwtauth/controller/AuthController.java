package com.cognizant.jwtauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.jwtauth.dto.LoginRequest;
import com.cognizant.jwtauth.dto.LoginResponse;
import com.cognizant.jwtauth.security.JwtTokenProvider;

@RestController
public class AuthController {

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	// DEMO ONLY: a single hardcoded user so the flow can be exercised end to
	// end without a database. In a real application, replace this with a
	// UserDetailsService + PasswordEncoder-backed AuthenticationManager.
	private static final String DEMO_USERNAME = "admin";
	private static final String DEMO_PASSWORD = "password123";

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest request) {
		if (DEMO_USERNAME.equals(request.getUsername())
				&& DEMO_PASSWORD.equals(request.getPassword())) {
			String token = jwtTokenProvider.createToken(request.getUsername());
			return ResponseEntity.ok(new LoginResponse(token));
		}
		return ResponseEntity.status(401).body("Invalid username or password");
	}

}
