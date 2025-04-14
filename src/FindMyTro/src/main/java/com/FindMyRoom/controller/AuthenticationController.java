package com.FindMyRoom.controller;

import com.FindMyRoom.dto.UserDTO;
import com.FindMyRoom.service.UserService;
import com.FindMyRoom.utils.RandomCode;
import com.FindMyRoom.utils.email.EmailService;
import com.FindMyRoom.utils.email.EmailServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
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
public class AuthenticationController {
    private final UserService userService;
    private static String randomCode;
    private final UserDTO userDTO;
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    public AuthenticationController(UserService userService) {
        AuthenticationController.randomCode = null;
        this.userDTO = new UserDTO();
        this.userService = userService;
    }

    @GetMapping("/verify")
    public ResponseEntity<String> verifyGoogleEmail(OAuth2AuthenticationToken token) {
        logger.info(token.getPrincipal().getName());
        OAuth2User user = token.getPrincipal();
        String email = user.getAttribute("email");
        if (email != null && !email.equals("hoana5k44nknd@gmail.com")) {
            return ResponseEntity.ok("Email not found");
        }
        return ResponseEntity.ok("Email verified");
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
    public ResponseEntity<String> profile(OAuth2AuthenticationToken token, HttpSession session) {
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
    @PostMapping("/email")
    public String getEmailToSendVerificationCode(Model model, @ModelAttribute("user") UserDTO user) {
        try {
            verifyEmailAndSendVerificationCode(true, user);
            model.addAttribute("verifyCode", false);
        } catch (Exception e) {
            Logger.getLogger(AuthenticationController.class.getName()).log(Level.ALL, e.getMessage(), e);
            model.addAttribute("error", e.getMessage());
        }
        return "authentication-features/register";
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
            Logger.getLogger(AuthenticationController.class.getName()).log(Level.ALL, e.getMessage(), e);
            model.addAttribute("error", e.getMessage());
        }
        return "authentication-features/register";
    }

    @PostMapping("/create")
    public String createAccount(Model model,
                                @ModelAttribute("user") UserDTO user,
                                HttpSession session) {
        try {
            if (!user.getPassword().equals(user.getRewritePassword())) {
                throw new Exception("Rewrite password and password are not match");
            }
            userDTO.setPassword(user.getPassword());
            userDTO.setPhoneNumber(user.getPhoneNumber());
            userService.addAnNewAccount(userDTO);

            setAttributeForSecurityContext(userDTO, session);
            logger.info("User has been created: " + session.getAttribute("SPRING_SECURITY_CONTEXT").toString());
            resetUserDTOAttributes();
            return "authentication-features/login";
        } catch (Exception e) {
            Logger.getLogger(AuthenticationController.class.getName()).log(Level.ALL, e.getMessage(), e);
            model.addAttribute("error", e.getMessage());
            model.addAttribute("verifyCode", true);
            model.addAttribute("user", new UserDTO());
            return "authentication-features/register";
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
            Logger.getLogger(AuthenticationController.class.getName()).log(Level.ALL, e.getMessage(), e);
            model.addAttribute("error", e.getMessage());
        }
        return "authentication-features/forgot-password";
    }

    @PostMapping("/verifyPassword")
    public String checkPassword(Model model, @ModelAttribute("user") UserDTO user) {
        try {
            if (user.getPassword().equals(user.getRewritePassword())) {
                userDTO.setPassword(user.getPassword());
                userDTO.setPhoneNumber(user.getPhoneNumber());
                userService.updateUserDTO(userDTO);
                resetUserDTOAttributes();
                return "authentication-features/login";
            } else {
                throw new Exception("Rewrite password and password are not match");
            }
        } catch (Exception e) {
            Logger.getLogger(AuthenticationController.class.getName()).log(Level.ALL, e.getMessage(), e);
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

    private void setAttributeForSecurityContext(@NotNull UserDTO userDTO, @NotNull HttpSession session) {
        SecurityContext context = SecurityContextHolder.getContext();
        GrantedAuthority authority = new SimpleGrantedAuthority(userDTO.getRole().name());
        UserDetails details = new User(
                userDTO.getEmail(),
                userDTO.getPassword(),
                List.of(authority)
        );
        Authentication authentication = new UsernamePasswordAuthenticationToken(details, userDTO.getPassword(), List.of(authority));
        context.setAuthentication(authentication);
        session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, context);
    }
    // </editor-fold>
}
