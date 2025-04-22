package com.FindMyRoom.controller;

import com.FindMyRoom.dto.request.MessageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
public class NotificationController {
    @SendTo("/topic/message")
    @MessageMapping("/create-notification")
    public MessageRequest createNotification(MessageRequest messageRequest) {
        return messageRequest;
    }

    @GetMapping("/list")
    public ResponseEntity<?> returnAllNotifications() {
        return null;
    }
}
