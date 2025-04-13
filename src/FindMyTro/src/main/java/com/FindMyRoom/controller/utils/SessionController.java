package com.FindMyRoom.controller.utils;

import com.FindMyRoom.dto.UserDTO;
import com.FindMyRoom.service.UserService;
import com.FindMyRoom.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class SessionController {
    private final UserService service;
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    public SessionController(UserServiceImpl service) {
        this.service = service;
    }

    public String getEmailFromSession(HttpSession session) {
        String email = "";
        SecurityContext context = SecurityContextHolder.getContext();
        if (context != null) {
            logger.info("context: " + (context.getAuthentication() != null ? "null" : context.getAuthentication()));
            Authentication authentication = context.getAuthentication();
            if (authentication != null && authentication.getPrincipal() instanceof UserDetails userDetails) {
                email = userDetails.getUsername();
            }
        } else {
            logger.log(Level.WARNING, "No SecurityContext found in session");
        }
        return email;
    }

    @Bean
    public UserDTO getEntityFromSession(HttpSession session) throws Exception {
        String email = getEmailFromSession(session);
        logger.info("Get email from session: " + email);
        UserDTO userDTO = new UserDTO();
        if (!email.isEmpty()) {
            userDTO = service.getUserDTOByEmail(email);
            if (userDTO == null) {
                throw new Exception("Account not found");
            }
        }
        return userDTO;
    }
}
