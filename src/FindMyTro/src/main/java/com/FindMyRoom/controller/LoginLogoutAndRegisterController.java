package com.FindMyRoom.controller;

import com.FindMyRoom.dto.UserDTO;
import com.FindMyRoom.service.UserService;
import com.FindMyRoom.utils.RandomCode;
import com.FindMyRoom.utils.email.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.logging.*;

@Controller
public class LoginLogoutAndRegisterController {
    private final UserService userService;
    private static String randomCode;
    private final UserDTO userDTO;

    public LoginLogoutAndRegisterController(UserService userService) {
        LoginLogoutAndRegisterController.randomCode = null;
        this.userDTO = new UserDTO();
        this.userService = userService;
    }

    @GetMapping("/login")
    public String redirectToLogin(Model model) {
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
        model.addAttribute("user", userDTO);
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

    // first part of register screen
    @PostMapping("/email")
    public String getEmailToSendVerifyCode(Model model, @ModelAttribute("user") UserDTO user) {
        List<String> emails = userService.getAllEmails();
        try {
            if (emails.contains(user.getEmail())) {
                throw new Exception("This email is existing");
            }
            userDTO.setEmail(user.getEmail());
            sendEmail(user.getEmail());
            model.addAttribute("verifyCode", false);
        } catch (Exception e) {
            Logger.getLogger(LoginLogoutAndRegisterController.class.getName()).log(Level.ALL, e.getMessage(), e);
            model.addAttribute("error", e.getMessage());
        }
        return "register";
    }

    // second part of register screen
    @PostMapping("/validateCode")
    public String validateCode(Model model, @RequestParam("code") String code) {
        try {
            if (code != null) {
                if (code.equals(randomCode)) {
                    model.addAttribute("verifyCode", true);
                    model.addAttribute("user", userDTO);
                } else {
                    throw new Exception("Invalid code");
                }
            } else {
                throw new Exception("Must fill out the field");
            }
        } catch (Exception e) {
            Logger.getLogger(LoginLogoutAndRegisterController.class.getName()).log(Level.ALL, e.getMessage(), e);
            model.addAttribute("error", e.getMessage());
        }
        return "register";
    }

    // third part of register screen
    @PostMapping("/create")
    public String createAccount(Model model, @ModelAttribute("user") UserDTO user) {
        try {
            if (user.getPassword().equals(user.getRewritePassword())) {
                userDTO.setPassword(user.getPassword());
                userDTO.setPhoneNumber(user.getPhoneNumber());
                userService.addAnNewAccount(userDTO);
                return "login";
            } else {
                throw new Exception("Rewrite password and password are not match");
            }
        } catch (Exception e) {
            Logger.getLogger(LoginLogoutAndRegisterController.class.getName()).log(Level.ALL, e.getMessage(), e);
            model.addAttribute("error", e.getMessage());
            model.addAttribute("verifyCode", true);
            model.addAttribute("user", new UserDTO());
            return "register";
        }
    }

    private void sendEmail(String email) {
        EmailService service = new EmailServiceImpl();
        randomCode = RandomCode.generateSixRandomCodes();
        service.sendEmail(email, "[Find My Room] Verify Code", randomCode);
    }
}
