package com.cognizant.resourceserver.config;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * WebSecurityConfigurerAdapter (used in the original exercise text) was removed
 * in Spring Security 6 / Spring Boot 3. Replaced here with a SecurityFilterChain
 * bean, following current Spring Security guidance.
 */
@EnableWebSecurity
public class ResourceServerConfig {

	@Value("${spring.security.oauth2.resourceserver.jwt.secret-key}")
	private String secretKey;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests(authorize -> authorize
				.anyRequest().authenticated()
			)
			.oauth2ResourceServer(oauth2 -> oauth2
				.jwt(jwt -> jwt.decoder(jwtDecoder()))
			);

		return http.build();
	}

	/**
	 * For local/demo testing only: validates HS256-signed JWTs against a shared
	 * secret so this resource server can be exercised without a full
	 * Authorization Server running. In production, remove this bean and use
	 * spring.security.oauth2.resourceserver.jwt.issuer-uri (or jwk-set-uri)
	 * instead so Spring Boot auto-configures an RS256 JwtDecoder for you.
	 */
	@Bean
	public JwtDecoder jwtDecoder() {
		SecretKeySpec key = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256");
		return NimbusJwtDecoder.withSecretKey(key).build();
	}

}
