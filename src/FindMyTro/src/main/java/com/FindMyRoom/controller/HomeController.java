package com.FindMyRoom.controller;

import com.FindMyRoom.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("user", new UserDTO());
        return "login-forgot-register/login";
    }
}
