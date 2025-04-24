package com.FindMyRoom.controller;

import com.FindMyRoom.controller.utils.URLIdEncoder;
import com.FindMyRoom.dto.request.MessageRequest;
import com.FindMyRoom.dto.response.UserResponseDTO;
import com.FindMyRoom.service.NotificationService;
import com.FindMyRoom.service.impl.NotificationServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/notification")
public class NotificationController {
    private final NotificationService nSrv;
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    public NotificationController(NotificationServiceImpl nSrv) {
        this.nSrv = nSrv;
    }

    @SendTo("/topic/message")
    @MessageMapping("/create-notification")
    public MessageRequest createNotification(MessageRequest messageRequest) {
        return messageRequest;
    }

    @GetMapping("/list")
    public ResponseEntity<?> returnAllNotifications(HttpSession session) {
        UserResponseDTO user = (UserResponseDTO) session.getAttribute("account");
        if (user != null) {
            user.setId(URLIdEncoder.decodeId(user.getEncodeId()));
            try {
                return ResponseEntity.ok(nSrv.getAllNotificationsByUserId(user.getId()));
            } catch (Exception e) {
                logger.log(Level.SEVERE, e.getMessage());
            }
        }
        return ResponseEntity.noContent().build();
    }
}
