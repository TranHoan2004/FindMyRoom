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
        return http
                .securityMatcher("/setting")
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
                        .requestMatchers("/setting").hasAnyRole(ROLE_ADMIN, ROLE_USER, ROLE_BUSINESSMAN, ROLE_EMPLOYEE)
                        .anyRequest().authenticated()
                ).httpBasic(Customizer.withDefaults())
                .build();
    }

    @Bean
    public SecurityFilterChain userFeatureConfiguration(HttpSecurity http) throws Exception {
        return http
                .securityMatcher("/user/**")
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/user/**").hasAnyRole(ROLE_ADMIN, ROLE_USER, ROLE_BUSINESSMAN, ROLE_EMPLOYEE)
                        .anyRequest().authenticated()
                ).httpBasic(Customizer.withDefaults())
                .build();
    }

    @Bean
    public SecurityFilterChain storyAndSliderFeatureConfiguration(HttpSecurity http) throws Exception {
        return http
                .securityMatcher("/story/**"
//                        , "/slider/**"
                )
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/story/list"
//                                ,"/slider/list"
                        ).hasAnyRole(ROLE_ADMIN, ROLE_USER, ROLE_BUSINESSMAN, ROLE_EMPLOYEE)

                        .requestMatchers(
                                "/story/create", "/slider/create",
                                "/story/update", "/slider/update",
                                "/story/delete", "/slider/update"
                        ).hasRole(ROLE_ADMIN)
                        .anyRequest().authenticated()
                ).httpBasic(Customizer.withDefaults())
                .build();
    }

    @Bean
    public SecurityFilterChain postFeatureConfiguration(HttpSecurity http) throws Exception {
        return http
                .securityMatcher("/post/**")
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/post/list").hasAnyRole(ROLE_ADMIN, ROLE_USER, ROLE_BUSINESSMAN, ROLE_EMPLOYEE)

                        .requestMatchers(
                                "/post/create", "/post/update",
                                "/post/delete"
                        ).hasAnyRole(ROLE_BUSINESSMAN, ROLE_USER)
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                .build();
    }
}
