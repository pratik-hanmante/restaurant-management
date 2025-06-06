package com.pratik.restaurant.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // Indicates this class contains Spring bean definitions
@EnableWebSecurity // Enables Spring Security for the application
public class SecurityConfig {

    // Defines the security filter chain for HTTP requests
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // Step 1: Enforce that every HTTP request must be authenticated
                .authorizeHttpRequests(auth ->
                        auth.anyRequest().authenticated()
                )

                // Step 2: Configure the app as a stateless OAuth2 Resource Server using JWTs
                .oauth2ResourceServer(oauth2 ->
                        oauth2.jwt(jwt ->
                                // Step 3: Use a custom converter to extract authorities from JWT claims
                                jwt.jwtAuthenticationConverter(jwtAuthenticationConverter())
                        )
                )

                // Step 4: Set session management to stateless (no HTTP session will be created or used)
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )

                // Step 5: Disable CSRF protection (recommended for APIs that do not use sessions/cookies)
                .csrf(csrf -> csrf.disable());

        // Step 6: Build and return the configured security filter chain
        return http.build();
    }

    // Defines a bean that converts a JWT token into a Spring Authentication object
    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {
        // This can be customized to map roles from custom JWT claims
        return new JwtAuthenticationConverter();
    }
}
