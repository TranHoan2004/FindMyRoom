package com.FindMyRoom.controller;

import com.FindMyRoom.controller.utils.URLIdEncoder;
import com.FindMyRoom.dto.response.ApiResponse;
import com.FindMyRoom.dto.response.UserResponseDTO;
import com.FindMyRoom.service.CartService;
import com.FindMyRoom.service.impl.CartServiceImpl;
import jakarta.servlet.http.HttpSession;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/cart")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CartController {
    CartService cSrv;
    Logger logger = Logger.getLogger(this.getClass().getName());

    public CartController(CartServiceImpl service) {
        this.cSrv = service;
    }

    @GetMapping("/list")
    public ResponseEntity<ApiResponse<Integer>> getAmountCartOfUser(HttpSession session) {
        UserResponseDTO user = (UserResponseDTO) session.getAttribute("account");
        if (user != null) {
            long id = URLIdEncoder.decodeId(user.getEncodeId());
            try {
                int size = cSrv.getCartByUserID(id).getSize();
                return ResponseEntity.ok(new ApiResponse<>(
                        HttpStatus.OK.value(),
                        null,
                        size
                ));
            } catch (Exception e) {
                logger.log(Level.SEVERE, e.getMessage());
            }
        }
        return ResponseEntity.ok(new ApiResponse<>(
                HttpStatus.OK.value(),
                "No amount, default 0",
                0
        ));
    }
}
