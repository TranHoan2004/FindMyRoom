package com.FindMyRoom.config;

import com.FindMyRoom.dto.UserDTO;
import com.FindMyRoom.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

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

    @Bean
    public SecurityFilterChain loginLogoutConfiguration(HttpSecurity http) throws Exception {
        http
                .securityMatcher("/login", "/forgotPassword", "/register")
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/register").hasRole("USER")
                        .requestMatchers("/forgotPassword").permitAll()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/home", true)
                        .failureUrl("/login?error=true")
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login")
                        .permitAll()
                );
        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * If we want to configure faster, do not need to use loadUserByUsername() in UserServiceImpl.<br/> In fact, we can
     * hold 2 methods but spring security will priorities bean method. But be careful, because if we use
     * loadUserByUsername (LUBU) manually and bean method or bean method uses API's data and LUBU uses db, there will
     * have some conflicts.<br/> If we want to priority LUBU, please use annotation @Primary
     *
     * @return new User (org.springframework.security.core.userdetails)
     */
    @Bean
    public UserDetailsService userDetailsService(UserService service) {
        return email -> {
            UserDTO dto = service.getUserDTOByEmail(email);
            if (dto == null) {
                throw new UsernameNotFoundException("User not found");
            }
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(dto.getRole().name()));
            return new User(dto.getEmail(), dto.getPassword(), authorities);
        };
    }
}
