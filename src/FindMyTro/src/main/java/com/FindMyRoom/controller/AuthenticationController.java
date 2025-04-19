package com.FindMyRoom.controller;

import com.FindMyRoom.controller.utils.SessionController;
import com.FindMyRoom.dto.UserDTO;
import com.FindMyRoom.dto.request.UserRequestDTO;
import com.FindMyRoom.service.UserService;
import com.FindMyRoom.utils.RandomCode;
import com.FindMyRoom.utils.email.EmailService;
import com.FindMyRoom.utils.email.EmailServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.jetbrains.annotations.NotNull;
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
    private final UserDTO userDTO;
    private final SessionController sc;
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    public AuthenticationController(UserService userService, SessionController sc) {
        AuthenticationController.randomCode = null;
        this.userDTO = new UserDTO();
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
    public String redirectToRegister(Model model) {
        model.addAttribute("user", userDTO);
        return "authentication-features/register";
    }

    @GetMapping("/login")
    public String redirectToLogin(Model model,
                                  @RequestParam(value = "error", required = false) boolean error) {
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
    public String redirectToForgotPassword(Model model) {
        resetUserDTOAttributes();
        model.addAttribute("user", userDTO);
        model.addAttribute("message", null);
        model.addAttribute("error", null);
        model.addAttribute("isEmailVerified", null);
        return "authentication-features/forgot-password";
    }

    // <editor-fold desc="Register screen">
    @PostMapping("/verify-email")
    public ResponseEntity<Boolean> returnAllEmails(@RequestBody Map<String, String> payload) {
        logger.info(payload.get("email"));
        boolean status = false;
        try {
            List<String> emails = uSrv.getAllEmails();
            String email = payload.get("email");
            if (!emails.contains(email)) {
                status = true;
            }
            sendEmail(email);
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }
        return ResponseEntity.ok(status);
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
    // </editor-fold>

    // <editor-fold desc="Forgot password screen">
    @PostMapping("/validateEmail")
    public String getEmailOfForgottenPasswordAccount(Model model, @ModelAttribute("user") UserDTO user) {
        try {
            verifyEmailAndSendVerificationCode(false, userDTO);
            model.addAttribute("verifyCode", false);
            model.addAttribute("isEmailVerified", 0);
        } catch (Exception e) {
            logger.log(Level.ALL, e.getMessage(), e);
            model.addAttribute("error", e.getMessage());
        }
        return "authentication-features/forgot-password";
    }

    @PostMapping("/verifyPassword")
    public String checkPassword(Model model, @ModelAttribute("user") UserDTO user) {
        try {
            if (!user.getPassword().equals(user.getRewritePassword())) {
                throw new Exception("Rewrite password and password are not match");
            }
            userDTO.setPassword(user.getPassword());
            userDTO.setPhoneNumber(user.getPhoneNumber());
            uSrv.updateUserDTO(userDTO);
            resetUserDTOAttributes();
            return "authentication-features/login";
        } catch (Exception e) {
            logger.log(Level.ALL, e.getMessage(), e);
            model.addAttribute("error", e.getMessage());
            model.addAttribute("verifyCode", true);
            model.addAttribute("user", new UserDTO());
            return "authentication-features/forgot-password";
        }
    }
    // </editor-fold>

    // <editor-fold> desc="Private methods"
    private void sendEmail(String email) {
        EmailService service = new EmailServiceImpl();
        randomCode = RandomCode.generateSixRandomCodes();
        logger.info(randomCode);
        service.sendEmail(email, "[Find My Room] Verify Code", randomCode);
        logger.info("Send email successfully");
    }

    private void resetUserDTOAttributes() {
        userDTO.setStatus(false);
        userDTO.setPhoneNumber("");
        userDTO.setPassword("");
        userDTO.setEmail("");
    }

    private void verifyEmailAndSendVerificationCode(boolean status, @NotNull UserDTO user) throws Exception {
        List<String> emails = uSrv.getAllEmails();
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
        logger.info("Send email successfully");
    }
    // </editor-fold>
}
