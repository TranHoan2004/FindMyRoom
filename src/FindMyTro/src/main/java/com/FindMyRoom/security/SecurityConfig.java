package com.FindMyRoom.security;

import com.FindMyRoom.dto.AdminDTO;
import com.FindMyRoom.dto.BusinessDTO;
import com.FindMyRoom.dto.EmployeeDTO;
import com.FindMyRoom.dto.UserDTO;
import com.FindMyRoom.service.AdminService;
import com.FindMyRoom.service.BusinessService;
import com.FindMyRoom.service.EmployeeService;
import com.FindMyRoom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Optional;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final AdminService adminService;

    private final BusinessService businessService;

    private final UserService userService;

    private final EmployeeService employeeService;

    public SecurityConfig(AdminService adminService, BusinessService businessService, UserService userService, EmployeeService employeeService) {
        this.adminService = adminService;
        this.businessService = businessService;
        this.userService = userService;
        this.employeeService = employeeService;
    }

    @Bean
    public SecurityFilterChain generalConfiguration(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
                        .requestMatchers("/user-features/**").hasAnyRole("USER", "BUSINESSMAN")
                        .requestMatchers("/admin-features/**").hasAnyRole("ADMIN", "EMPLOYEE")
                        .anyRequest().authenticated()
                ).httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public SecurityFilterChain loginLogoutConfiguration(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/register").hasRole("USER")
                        .requestMatchers("/forgotPassword").permitAll()
                )
                .formLogin(form -> form
                        .loginPage("/login")
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

//    @Bean
//    public UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        Optional<UserDTO> userDTOs = userService.getAllUserDTOs();
//        Optional<AdminDTO> adminDTOs = adminService.getAllAdminDTOs();
//        Optional<BusinessDTO> businessDTOs = businessService.getAllBusinessAccount();
//        Optional<EmployeeDTO> employeeDTOs = employeeService.getAllEmployeeDTOs();
//
//        userDTOs.stream().map(userDTO -> User.builder()
//                .roles("USER")
//                .username(userDTO.getEmail())
//                .password(userDTO.getPassword())
//                .build()
//        ).forEach(manager::createUser);
//        adminDTOs.stream().map(adminDTO -> User.builder()
//                .roles("ADMIN")
//                .username(adminDTO.getUser().getEmail())
//                .password(adminDTO.getUser().getPassword())
//                .build()
//        ).forEach(manager::createUser);
//        businessDTOs.stream().map(businessDTO -> User.builder()
//                .roles("BUSINESSMAN")
//                .username(businessDTO.getEmail())
//                .password(businessDTO.getPassword())
//                .build()
//        ).forEach(manager::createUser);
//        employeeDTOs.stream().map(employeeDTO -> User.builder()
//                .roles("EMPLOYEE")
//                .username(employeeDTO.getEmail())
//                .password(employeeDTO.getPassword())
//                .build()
//        ).forEach(manager::createUser);
//        return manager;
//    }
}
