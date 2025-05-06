package com.FindMyRoom.controller;

import com.FindMyRoom.controller.utils.SessionController;
import com.FindMyRoom.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/user")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {
    SessionController sc;
    UserService uSrv;
    Logger logger = Logger.getLogger(UserController.class.getName());

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
