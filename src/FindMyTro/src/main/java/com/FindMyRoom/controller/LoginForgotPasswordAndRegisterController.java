package com.FindMyRoom.controller;

import com.FindMyRoom.dto.UserDTO;
import com.FindMyRoom.service.UserService;
import com.FindMyRoom.utils.RandomCode;
import com.FindMyRoom.utils.email.EmailService;
import com.FindMyRoom.utils.email.EmailServiceImpl;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class LoginForgotPasswordAndRegisterController {
    private final UserService userService;
    private static String randomCode;
    private final UserDTO userDTO;

    public LoginForgotPasswordAndRegisterController(UserService userService) {
        LoginForgotPasswordAndRegisterController.randomCode = null;
        this.userDTO = new UserDTO();
        this.userService = userService;
    }

    @GetMapping("/login")
    public String redirectToLogin(Model model) {
        model.addAttribute("user", new UserDTO());
        return "login-forgot-register/login";
    }

//    @PostMapping("/login")
//    public String login(@ModelAttribute("user") UserDTO user, Model model, HttpSession session) {
//        List<String> emails;
//        UserDTO userDTO;
//        try {
//            emails = userService.getAllEmails();
//            if (!emails.contains(user.getEmail())) {
//                throw new Exception("This email is not existing");
//            }
//            userDTO = userService.getUserDTOByEmail(user.getEmail());
//            if (!user.getPassword().equals(userDTO.getPassword())) {
//                throw new Exception("Wrong password");
//            }
//            session.setAttribute("user", userDTO);
//        } catch (Exception e) {
//            Logger.getLogger(LoginForgotPasswordAndRegisterController.class.getName()).log(Level.ALL, e.getMessage(), e);
//            model.addAttribute("error", e.getMessage());
//        }
//        return "home";
//    }

    @GetMapping("/createAccount")
    public String redirectToRegister(Model model) {
        model.addAttribute("user", userDTO);
        return "login-forgot-register/register";
    }

    @GetMapping("/forgotPassword")
    public String redirectToForgotPassword(Model model) {
        resetUserDTOAttributes();
        model.addAttribute("user", userDTO);
        model.addAttribute("message", null);
        model.addAttribute("error", null);
        model.addAttribute("isEmailVerified", null);
        return "login-forgot-register/forgot-password";
    }

    // <editor-fold desc="Register screen">
    @PostMapping("/email")
    public String getEmailToSendVerificationCode(Model model, @ModelAttribute("user") UserDTO user) {
        try {
            verifyEmailAndSendVerificationCode(true, user);
            model.addAttribute("verifyCode", false);
        } catch (Exception e) {
            Logger.getLogger(LoginForgotPasswordAndRegisterController.class.getName()).log(Level.ALL, e.getMessage(), e);
            model.addAttribute("error", e.getMessage());
        }
        return "login-forgot-register/register";
    }

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
            Logger.getLogger(LoginForgotPasswordAndRegisterController.class.getName()).log(Level.ALL, e.getMessage(), e);
            model.addAttribute("error", e.getMessage());
        }
        return "login-forgot-register/register";
    }

    @PostMapping("/create")
    public String createAccount(Model model, @ModelAttribute("user") UserDTO user) {
        try {
            if (user.getPassword().equals(user.getRewritePassword())) {
                userDTO.setPassword(user.getPassword());
                userDTO.setPhoneNumber(user.getPhoneNumber());
                userService.addAnNewAccount(userDTO);
                resetUserDTOAttributes();
                return "login-forgot-register/login";
            } else {
                throw new Exception("Rewrite password and password are not match");
            }
        } catch (Exception e) {
            Logger.getLogger(LoginForgotPasswordAndRegisterController.class.getName()).log(Level.ALL, e.getMessage(), e);
            model.addAttribute("error", e.getMessage());
            model.addAttribute("verifyCode", true);
            model.addAttribute("user", new UserDTO());
            return "login-forgot-register/register";
        }
    }
    // </editor-fold>

    // <editor-fold desc="Forgot password screen">
    @PostMapping("/validateEmail")
    public String getEmailOfForgottenPasswordAccount(Model model, @ModelAttribute("user") UserDTO user) {
        try {
            verifyEmailAndSendVerificationCode(false, userDTO);
            model.addAttribute("verifyCode", false);
            model.addAttribute("isEmailVerified", 0);
        } catch (Exception e) {
            Logger.getLogger(LoginForgotPasswordAndRegisterController.class.getName()).log(Level.ALL, e.getMessage(), e);
            model.addAttribute("error", e.getMessage());
        }
        return "login-forgot-register/forgot-password";
    }

    @PostMapping("/verifyPassword")
    public String checkPassword(Model model, @ModelAttribute("user") UserDTO user) {
        try {
            if (user.getPassword().equals(user.getRewritePassword())) {
                userDTO.setPassword(user.getPassword());
                userDTO.setPhoneNumber(user.getPhoneNumber());
                userService.updateUserDTO(userDTO);
                resetUserDTOAttributes();
                return "login-forgot-register/login";
            } else {
                throw new Exception("Rewrite password and password are not match");
            }
        } catch (Exception e) {
            Logger.getLogger(LoginForgotPasswordAndRegisterController.class.getName()).log(Level.ALL, e.getMessage(), e);
            model.addAttribute("error", e.getMessage());
            model.addAttribute("verifyCode", true);
            model.addAttribute("user", new UserDTO());
            return "login-forgot-register/forgot-password";
        }
    }
    // </editor-fold>

//    public String logout(@NotNull HttpSession session) {
//        session.invalidate();
//        return "login-forgot-register/login";
//    }

    private void sendEmail(String email) {
        EmailService service = new EmailServiceImpl();
        randomCode = RandomCode.generateSixRandomCodes();
        service.sendEmail(email, "[Find My Room] Verify Code", randomCode);
    }

    private void resetUserDTOAttributes() {
        userDTO.setStatus(false);
        userDTO.setPhoneNumber("");
        userDTO.setPassword("");
        userDTO.setEmail("");
    }

    private void verifyEmailAndSendVerificationCode(boolean status, @NotNull UserDTO user) throws Exception {
        List<String> emails = userService.getAllEmails();
        if (emails.contains(user.getEmail())) {
            // if status is true, throw an exception to notice that this email is existing. Using by register screen (for true status) and forgot password screen (for false status)
            if (status) {
                throw new Exception("This email is existing");
            } else {
                throw new Exception("This email is not existing");
            }
        }
        userDTO.setEmail(user.getEmail());
        sendEmail(user.getEmail());
    }
}
