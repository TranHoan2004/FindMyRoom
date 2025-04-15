package com.FindMyRoom.controller;

import com.FindMyRoom.controller.utils.SessionController;
import com.FindMyRoom.dto.UserDTO;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
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
        return "redirect:/login";
    }

    @GetMapping("/home")
    public String home(HttpSession session) {
        throwSessionData(session);
        return "common-features/home";
    }

    private void throwSessionData(HttpSession session) {
        try {
            UserDTO user = sc.getEntityFromSession(session);
            session.setAttribute("account", user);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
