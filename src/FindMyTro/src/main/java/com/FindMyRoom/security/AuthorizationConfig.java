package com.FindMyRoom.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AuthorizationConfig {
    @Bean
    public SecurityFilterChain generalConfiguration(HttpSecurity http) throws Exception {
        http
                .securityMatcher("/users/**", "/admin/**")
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
                        .requestMatchers("/users/**").hasAnyRole("USER", "BUSINESSMAN")
                        .requestMatchers("/admin/**").hasAnyRole("ADMIN", "EMPLOYEE")
                        .anyRequest().authenticated()
                ).httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
