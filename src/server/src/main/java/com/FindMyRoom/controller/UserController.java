package com.FindMyRoom.controller;

import com.FindMyRoom.controller.utils.SessionController;
import com.FindMyRoom.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
@RequestMapping("/user")
public class UserController {
    private final SessionController sc;
    private final UserService uSrv;
    private final Logger logger = Logger.getLogger(UserController.class.getName());

    public UserController(SessionController sc, UserService uSrv) {
        this.sc = sc;
        this.uSrv = uSrv;
    }

    @GetMapping("/profile")
    public String profile() {
        return "users-features/profile";
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteUser(HttpSession session) {
//        logger.info("header: " + header);
        logger.info("Deleting user");
        try {
            String email = sc.getEmailFromSession(session);
            if (email.isEmpty()) {
                throw new Exception("Email is empty");
            }
//            uSrv.deleteUser(email);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("Delete user successfully");
    }
}
