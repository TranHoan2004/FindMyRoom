package com.FindMyRoom.controller;

import com.FindMyRoom.controller.utils.SessionController;
import com.FindMyRoom.dto.UserDTO;
import com.FindMyRoom.dto.request.UserRequestDTO;
import com.FindMyRoom.service.UserService;
import com.FindMyRoom.utils.RandomCode;
import com.FindMyRoom.utils.email.EmailService;
import com.FindMyRoom.utils.email.EmailServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class AuthenticationController {
    private final UserService uSrv;
    private static String randomCode;
    private final SessionController sc;
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    public AuthenticationController(UserService userService, SessionController sc) {
        AuthenticationController.randomCode = null;
        this.uSrv = userService;
        this.sc = sc;
    }

    @GetMapping("/verify")
    public String verifyGoogleEmail(HttpSession session, Model model) {
        String email = sc.getEmailFromSession(session);
        try {
            session.setAttribute("account", uSrv.getUserDTOByEmail(email));
        } catch (Exception e) {
            model.addAttribute("error", "This email is not existing");
            return "authentication-features/login";
        }
        logger.info("Verifying email successfully");
        return "common-features/home";
    }

    @GetMapping("/createAccount")
    public String redirectToRegister() {
        return "authentication-features/register";
    }

    @GetMapping("/login")
    public String redirectToLogin(Model model, @RequestParam(value = "error", required = false) boolean error) {
        model.addAttribute("user", new UserDTO());
        if (error) model.addAttribute("error", "Wrong username or password");
        return "authentication-features/login";
    }

    @GetMapping("/profile")
    public ResponseEntity<String> profile(HttpSession session) {
        Object obj = session.getAttribute("SPRING_SECURITY_CONTEXT");
        return ResponseEntity.ok(obj.toString());
    }

    @GetMapping("/forgotPassword")
    public String redirectToForgotPassword() {
        return "authentication-features/forgot-password";
    }

    @PostMapping("/verify-email")
    public ResponseEntity<String> returnAllEmails(@RequestBody Map<String, String> payload) {
        logger.info(payload.get("email"));
        logger.info(payload.get("type"));
        logger.info(String.valueOf(Boolean.parseBoolean(payload.get("type"))));
        try {
            List<String> emails = uSrv.getAllEmails();
            String email = payload.get("email");
            if (Boolean.parseBoolean(payload.get("type"))) {
                // if true, we create a new account, this email should not be existing
                if (!emails.contains(email)) {
                    sendEmail(email);
                    return ResponseEntity.status(HttpStatus.OK).body("Ready to create a new account");
                }
                return ResponseEntity.badRequest().body("This email is already existing");
            }
            if (emails.contains(email)) {
                // if false, we reset password, this email should be existing
                sendEmail(email);
                return ResponseEntity.status(HttpStatus.OK).body("Ready to reset password");
            }
            return ResponseEntity.badRequest().body("Email not found");
        } catch (Exception e) {
            logger.warning(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/validate-code")
    public ResponseEntity<String> validateCode() {
        return ResponseEntity.ok(randomCode);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createAccount(@RequestBody UserRequestDTO userDTO) {
        try {
            if (uSrv.isPhoneNumberExisting(userDTO.getPhoneNumber())) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Phone number is existing");
            }
            uSrv.addAnNewAccount(userDTO);
            return ResponseEntity.status(HttpStatus.OK).body("Create account successfully");
        } catch (Exception e) {
            logger.log(Level.ALL, e.getMessage(), e);
        }
        return ResponseEntity.badRequest().body("Create account failed");
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateAccount(@RequestBody UserRequestDTO userDTO) {
        logger.info("updateAccount");
        try {
            logger.info(userDTO.toString());
            uSrv.updateUserDTO(userDTO.getEmail(), userDTO.getPassword());
            return ResponseEntity.status(HttpStatus.OK).body("Update account successfully");
        } catch (Exception e) {
            logger.warning(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage() + ", update account failed");
        }
    }

    private void sendEmail(String email) {
        EmailService service = new EmailServiceImpl();
        randomCode = RandomCode.generateSixRandomCodes();
        logger.info(randomCode);
        service.sendEmail(email, "[Find My Room] Verify Code", randomCode);
        logger.info("Send email successfully");
    }
}
