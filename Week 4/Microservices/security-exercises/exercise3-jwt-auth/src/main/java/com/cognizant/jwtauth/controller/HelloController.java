package com.cognizant.jwtauth.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	// Requires a valid "Authorization: Bearer <token>" header, enforced by
	// JwtTokenFilter + SecurityConfig.
	@GetMapping("/hello")
	public String hello(Principal principal) {
		return "Hello, " + principal.getName() + "! This is a JWT-protected endpoint.";
	}

}
