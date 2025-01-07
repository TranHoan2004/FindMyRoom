package com.FindMyRoom.controller;

import com.FindMyRoom.dto.UserDTO;
import com.FindMyRoom.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class LoginLogoutAndRegisterController {
    private final UserService userService;

    public LoginLogoutAndRegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String redirectTologin(Model model) {
        model.addAttribute("user", new UserDTO());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") UserDTO user, Model model, HttpSession session) {
        List<String> emails;
        UserDTO userDTO;
        try {
            emails = userService.getAllEmails();
            if (!emails.contains(user.getEmail())) {
                throw new Exception("This email is not existing");
            }
            userDTO = userService.getUserDTOByEmail(user.getEmail());
            if (!user.getPassword().equals(userDTO.getPassword())) {
                throw new Exception("Wrong password");
            }
            session.setAttribute("user", userDTO);
        } catch (Exception e) {
            Logger.getLogger(LoginLogoutAndRegisterController.class.getName()).log(Level.ALL, e.getMessage(), e);
            model.addAttribute("error", e.getMessage());
        }
        return "home";
    }

    @GetMapping("/create_account")
    public String redirectToRegister(Model model) {
        model.addAttribute("user", new UserDTO());
        return "register";
    }

    @PostMapping("/register")
    public String createNewAccount(Model model) {
        return "";
    }

    @PostMapping("/forgot")
    public String forgotPassword(Model model) {
        return "forgot-password";
    }
}
