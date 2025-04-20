package com.FindMyRoom.security;

import com.FindMyRoom.config.Constants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AuthorizationConfig implements Constants.Role {
    @Bean
    public SecurityFilterChain generalConfiguration(HttpSecurity http) throws Exception {
        http
                .securityMatcher("/setting")
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
                        .requestMatchers("/users/**").hasAnyRole(ROLE_ADMIN, ROLE_USER, ROLE_BUSINESSMAN, ROLE_EMPLOYEE)
                        .anyRequest().authenticated()
                ).httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
