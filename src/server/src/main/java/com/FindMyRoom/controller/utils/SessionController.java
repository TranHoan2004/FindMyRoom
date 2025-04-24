package com.FindMyRoom.controller.utils;

import com.FindMyRoom.dto.response.UserResponseDTO;
import com.FindMyRoom.service.UserService;
import com.FindMyRoom.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;
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

    public String getEmailFromSession(@NotNull HttpSession session) {
        String email = "";
        SecurityContext context = (SecurityContext) session.getAttribute("SPRING_SECURITY_CONTEXT");
        if (context != null) {
            logger.info("context: " + (context.getAuthentication() != null ? context.getAuthentication() : "null"));
            Authentication authentication = context.getAuthentication();
            if (authentication != null && authentication.getPrincipal() instanceof UserDetails userDetails) {
                email = userDetails.getUsername();
            } else if (authentication != null && authentication.getPrincipal() instanceof OAuth2User userDetails) {
                email = userDetails.getAttribute("email");
                logger.info("getEmailFromSession: " + email);
            }
        } else {
            logger.log(Level.WARNING, "No SecurityContext found in session");
        }
        return email;
    }

    public UserResponseDTO getEntityFromSession(HttpSession session) throws Exception {
        String email = getEmailFromSession(session);
        logger.info("Get email from session: " + email);
        UserResponseDTO userDTO = new UserResponseDTO();
        if (!email.isEmpty()) {
            userDTO = service.getUserDTOByEmail(email);
            if (userDTO == null) {
                throw new Exception("Account not found");
            }
        } else {
            throw new Exception("No email found");
        }
        return userDTO;
    }
}
