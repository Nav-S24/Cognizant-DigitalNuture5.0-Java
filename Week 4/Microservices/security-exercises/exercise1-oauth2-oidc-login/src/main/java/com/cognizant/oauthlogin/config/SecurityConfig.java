package com.cognizant.oauthlogin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * WebSecurityConfigurerAdapter (used in the original exercise text) was removed
 * in Spring Security 6 / Spring Boot 3. The recommended replacement is to
 * expose a SecurityFilterChain bean, as shown below.
 */
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests(authorize -> authorize
				.anyRequest().authenticated()
			)
			.oauth2Login(oauth2 -> oauth2
				.defaultSuccessUrl("/user", true)
			);

		return http.build();
	}

}
