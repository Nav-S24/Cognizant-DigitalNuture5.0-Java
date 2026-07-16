package com.cognizant.oauthlogin.controller;

import java.security.Principal;
import java.util.Map;

import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	// Simple endpoint returning the authenticated principal's name,
	// as in the original exercise.
	@GetMapping("/user")
	public Principal user(Principal principal) {
		return principal;
	}

	// Extra endpoint exposing the full set of OIDC claims (email, name, picture,
	// etc.) returned by the provider, useful for verifying the login worked.
	@GetMapping("/user/details")
	public Map<String, Object> userDetails(OAuth2AuthenticationToken authentication) {
		OAuth2User oauth2User = authentication.getPrincipal();
		return oauth2User.getAttributes();
	}

}
