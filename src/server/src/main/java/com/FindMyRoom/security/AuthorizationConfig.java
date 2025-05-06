package com.FindMyRoom.security;

import com.FindMyRoom.config.Constants;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import java.util.logging.Logger;

@Configuration
@EnableWebSecurity
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthorizationConfig implements Constants.Role {
    Logger logger = Logger.getLogger(this.getClass().getName());

    @Bean
    public SecurityFilterChain generalConfiguration(HttpSecurity http) throws Exception {
        return http
                .securityMatcher("/setting")
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
                        .requestMatchers("/setting").hasAnyRole(ROLE_ADMIN, ROLE_USER, ROLE_BUSINESSMAN, ROLE_EMPLOYEE)
                        .anyRequest().authenticated()
                )
                .exceptionHandling(ex -> ex
                        .authenticationEntryPoint((request, response, authException) -> response.sendRedirect("/login"))
                        .accessDeniedHandler((request, response, accessDeniedException) -> {
                            logger.warning("Error happens when exeptionHandling is working: "
                                    + accessDeniedException.getMessage());
                            logger.info("request uri: " + request.getRequestURI());
                            response.sendRedirect("/access-denied");
                        }))
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                        .maximumSessions(1)
                        .expiredUrl("/login"))
                .httpBasic(Customizer.withDefaults())
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
                )
                .exceptionHandling(ex -> ex
                        .authenticationEntryPoint((request, response, authException) -> response.sendRedirect("/login"))
                        .accessDeniedHandler((request, response, accessDeniedException) -> {
                            logger.warning("Error happens when exeptionHandling is working: "
                                    + accessDeniedException.getMessage());
                            logger.info("request uri: " + request.getRequestURI());
                            response.sendRedirect("/access-denied");
                        }))
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                        .maximumSessions(1) // 1 user can access with only 1 device, if he/she try to use with 2 or
                        // more, the previous session will immediately be canceled.
                        .expiredUrl("/login"))
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    @Bean
    public SecurityFilterChain storyAndSliderFeatureConfiguration(HttpSecurity http) throws Exception {
        return http
                .securityMatcher("/story/**"
                        , "/slider/**"
                )
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/story/list"
                                , "/slider/list"
                        ).permitAll()

                        .requestMatchers(
                                "/story/create", "/slider/create",
                                "/story/update", "/slider/update",
                                "/story/delete", "/slider/update"
                        ).hasRole(ROLE_ADMIN)
                        .anyRequest().authenticated()
                ).exceptionHandling(ex -> ex
                        .authenticationEntryPoint((request, response, authException) -> response.sendRedirect("/login"))
                        .accessDeniedHandler((request, response, accessDeniedException) -> {
                            logger.warning("Error happens when exeptionHandling is working: "
                                    + accessDeniedException.getMessage());
                            logger.info("request uri: " + request.getRequestURI());
                            response.sendRedirect("/access-denied");
                        }))
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                        .maximumSessions(1) // 1 user can access with only 1 device, if he/she try to use with 2 or
                        // more, the previous session will immediately be canceled.
                        .expiredUrl("/login"))
                .httpBasic(Customizer.withDefaults())
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
                .exceptionHandling(ex -> ex
                        .authenticationEntryPoint((request, response, authException) -> response.sendRedirect("/login"))
                        .accessDeniedHandler((request, response, accessDeniedException) -> {
                            logger.warning("Error happens when exeptionHandling is working: "
                                    + accessDeniedException.getMessage());
                            logger.info("request uri: " + request.getRequestURI());
                            response.sendRedirect("/access-denied");
                        }))
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                        .maximumSessions(1) // 1 user can access with only 1 device, if he/she try to use with 2 or
                        // more, the previous session will immediately be canceled.
                        .expiredUrl("/login"))
                .httpBasic(Customizer.withDefaults())
                .build();
    }
}
