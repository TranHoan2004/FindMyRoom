package com.FindMyRoom.controller;

import com.FindMyRoom.controller.utils.SessionController;
import com.FindMyRoom.controller.utils.URLIdEncoder;
import com.FindMyRoom.dto.response.UserResponseDTO;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class HomeController {
    private final SessionController sc;
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    public HomeController(SessionController sc) {
        this.sc = sc;
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home(HttpSession session) {
        throwSessionData(session);
        return "common-features/home";
    }

    @GetMapping("/setting")
    public String settingPage() {
        return "common-features/setting";
    }

    @GetMapping("/access-denied")
    public String accessDeniedPage() {
        return "common-features/access-denied";
    }

    private void throwSessionData(HttpSession session) {
        try {
            UserResponseDTO user = sc.getEntityFromSession(session);
            UserResponseDTO newUser = UserResponseDTO.builder()
                    .encodeId(user.getEncodeId())
                    .role(user.getRole())
                    .fullname(user.getFullname())
                    .build();
            session.setAttribute("account", newUser);
        } catch (Exception e) {
            session.setAttribute("account", null);
            logger.log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
