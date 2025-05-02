package com.FindMyRoom.security;

import com.FindMyRoom.config.Constants;
import com.FindMyRoom.dto.response.UserResponseDTO;
import com.FindMyRoom.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;
import java.util.List;
import java.util.logging.Logger;

@Configuration
@EnableWebSecurity
public class AuthenticationConfig implements Constants.Role {
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Bean
    public SecurityFilterChain authenticationConfiguration(HttpSecurity http, UserDetailsService service,
                                                           DataSource source) throws Exception {
        return http
                .securityMatcher(
                        "/login/**", "/forgot-password", "/logout",
                        "/home", "/oauth2/**", "/create-account",
                        "/verify", "/validate-code", "/verify-email",
                        "/create", "/access-denied", "/update")
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(
                                "/oauth2/**", "/access-denied",
                                "/forgot-password", "/update",
                                "/create-account", "/create",
                                "/login/**", "/validate-code",
                                "/verify", "/verify-email",
                                "/home"
                        ).permitAll()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/home", true)
                        .failureUrl("/login?error=true")
                        .successHandler((request, response, authentication) -> {
                            logger.info("User has logged in: " + authentication.getName());
                            response.sendRedirect("/home");
                        })
                        .failureHandler((request, response, authentication) -> {
                            logger.info(request.getRequestURI() + " failed, " + authentication.getMessage());
                            response.sendRedirect("/login?error=true");
                        }).permitAll())
                .oauth2Login(o -> o
                        .loginPage("/login")
                        .failureHandler((request, response, authentication) -> {
                            logger.info(request.getRequestURI() + " failed, " + authentication.getMessage());
                            response.sendRedirect("/login?error=true");
                        })
                        .successHandler((request, response, authentication) -> {
                            logger.info("User has logged in: " + authentication.getName());
                            response.sendRedirect("/verify");
                        }))
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .invalidateHttpSession(true)
                        .logoutSuccessHandler((request, response, authentication) -> {
                            if (authentication != null) {
                                logger.info("User has logged out: " + authentication.getName());
                            }

                            HttpSession session = request.getSession(false);
                            if (session != null) {
                                session.invalidate();
                            }
                            response.sendRedirect("/home");
                        })
                        .deleteCookies("JSESSIONID", "remember-me")
                        .permitAll())
                .rememberMe(me -> me
                        .useSecureCookie(true)
                        .tokenRepository(persistentTokenRepository(source))
                        .tokenValiditySeconds(7 * 24 * 60 * 60)
                        .userDetailsService(service)
                        .key("ahadfcxvjweiosnaogp0913414#")
                        .alwaysRemember(false))
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
    public UserDetailsService userDetailsService(UserService service) {
        return email -> {
            logger.info("check username and password");
            UserResponseDTO dto;
            try {
                dto = service.getUserDTOByEmail(email);
            } catch (Exception e) {
                throw new UsernameNotFoundException("User not found");
            }
            GrantedAuthority authorities = new SimpleGrantedAuthority(dto.getSystemRole().name());
            return new User(dto.getEmail(), dto.getPassword(), List.of(authorities));
        };
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository(DataSource dataSource) {
        JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();
        repo.setDataSource(dataSource);
        return repo;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
