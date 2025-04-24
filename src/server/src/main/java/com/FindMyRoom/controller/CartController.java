package com.FindMyRoom.controller;

import com.FindMyRoom.controller.utils.URLIdEncoder;
import com.FindMyRoom.dto.response.UserResponseDTO;
import com.FindMyRoom.service.CartService;
import com.FindMyRoom.service.impl.CartServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/cart")
public class CartController {
    private final CartService cSrv;
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    public CartController(CartServiceImpl service) {
        this.cSrv = service;
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAmountCartOfUser(HttpSession session) {
        UserResponseDTO user = (UserResponseDTO) session.getAttribute("account");
        if (user != null) {
            user.setId(URLIdEncoder.decodeId(user.getEncodeId()));
            try {
                int size = cSrv.getCartByUserID(user.getId()).getSize();
                return ResponseEntity.ok().body(size);
            } catch (Exception e) {
                logger.log(Level.SEVERE, e.getMessage());
            }
        }
        return ResponseEntity.ok().body(0);
    }
}
