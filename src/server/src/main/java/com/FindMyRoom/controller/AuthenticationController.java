package com.FindMyRoom.controller;

import com.FindMyRoom.controller.utils.SessionController;
import com.FindMyRoom.dto.request.UserRequestDTO;
import com.FindMyRoom.dto.response.ApiResponse;
import com.FindMyRoom.service.EmailService;
import com.FindMyRoom.service.UserService;
import com.FindMyRoom.utils.RandomCode;
import jakarta.servlet.http.HttpSession;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticationController {
    final EmailService eSrv;
    final UserService uSrv;
    String randomCode;
    final SessionController sc;
    final Logger logger = Logger.getLogger(this.getClass().getName());

    public AuthenticationController(UserService userService, SessionController sc, EmailService service) {
        this.randomCode = null;
        this.uSrv = userService;
        this.sc = sc;
        this.eSrv = service;
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

    @GetMapping("/create-account")
    public String redirectToRegister() {
        return "authentication-features/register";
    }

    @GetMapping("/login")
    public String redirectToLogin(Model model, @RequestParam(value = "error", required = false) boolean error) {
        if (error) model.addAttribute("error", "Wrong username or password");
        return "authentication-features/login";
    }

    @GetMapping("/forgot-password")
    public String redirectToForgotPassword() {
        return "authentication-features/forgot-password";
    }

    @PostMapping("/verify-email")
    public ResponseEntity<?> verifyEmail(@RequestBody Map<String, String> payload, HttpSession session) {
        logger.info("verifyEmail");
        try {
            List<String> emails = uSrv.getAllEmails();
            String email = payload.get("email");
            if (Boolean.parseBoolean(payload.get("type"))) {
                // if true, we create a new account, this email should not be existing
                if (!emails.contains(email)) {
                    sendEmail(email, session);
                    return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ApiResponse<>(
                            HttpStatus.ACCEPTED.value(),
                            "Ready to create a new account",
                            null
                    ));
                }
                return ResponseEntity.badRequest().body(new ApiResponse<>(
                        HttpStatus.CONFLICT.value(),
                        "This email is already existing",
                        null
                ));
            }
            if (emails.contains(email)) {
                // if false, we reset password, this email should be existing
                sendEmail(email, session);
                return ResponseEntity.status(HttpStatus.CONTINUE).body(new ApiResponse<>(
                        HttpStatus.CONTINUE.value(),
                        "Ready to reset password",
                        null
                ));
            }
            return ResponseEntity.badRequest().body(new ApiResponse<>(
                    HttpStatus.NOT_FOUND.value(),
                    "Email not found",
                    null
            ));
        } catch (Exception e) {
            logger.warning(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/validate-code")
    public ResponseEntity<ApiResponse<String>> validateCode(HttpSession session) {
        return ResponseEntity.ok(new ApiResponse<>(
                HttpStatus.OK.value(),
                (String) session.getAttribute("randomCode"),
                null
        ));
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Object>> createAccount(@Valid @RequestBody UserRequestDTO userDTO) {
        try {
            if (uSrv.isPhoneNumberExisting(userDTO.getPhoneNumber())) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponse<>(
                        HttpStatus.CONFLICT.value(),
                        "Phone number is existing",
                        null
                ));
            }
            uSrv.addAnNewAccount(userDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(
                    HttpStatus.CREATED.value(),
                    "Create account successfully",
                    null
            ));
        } catch (Exception e) {
            logger.log(Level.ALL, e.getMessage(), e);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>(
                HttpStatus.BAD_REQUEST.value(),
                "Create account failed",
                null));
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponse<String>> updateAccount(@Valid @RequestBody UserRequestDTO userDTO) {
        logger.info("updateAccount");
        try {
            logger.info(userDTO.toString());
            uSrv.updateUserDTO(userDTO.getEmail(), userDTO.getPassword());
            return ResponseEntity.ok(new ApiResponse<>(
                    HttpStatus.OK.value(),
                    "Update account successfully",
                    null
            ));
        } catch (Exception e) {
            logger.warning(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>(
                    HttpStatus.BAD_REQUEST.value(),
                    e.getMessage() + ", update account failed",
                    null
            ));
        }
    }

    private void sendEmail(String email, @NotNull HttpSession session) {
        randomCode = RandomCode.generateSixRandomCodes();
        session.setAttribute("randomCode", randomCode);
        logger.info(randomCode);
        eSrv.sendSimpleMail(email, "[Find My Room] Verify Code", randomCode);
        logger.info("Send email successfully");
    }
}