package com.FindMyRoom.controller;

import com.FindMyRoom.controller.utils.URLIdEncoder;
import com.FindMyRoom.dto.request.MessageRequest;
import com.FindMyRoom.dto.response.ApiResponse;
import com.FindMyRoom.dto.response.NotificationResponseDTO;
import com.FindMyRoom.dto.response.UserResponseDTO;
import com.FindMyRoom.service.NotificationService;
import com.FindMyRoom.service.impl.NotificationServiceImpl;
import jakarta.servlet.http.HttpSession;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/notification")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class NotificationController {
    NotificationService nSrv;
    Logger logger = Logger.getLogger(this.getClass().getName());

    public NotificationController(NotificationServiceImpl nSrv) {
        this.nSrv = nSrv;
    }

    @SendTo("/topic/message")
    @MessageMapping("/create-notification")
    public MessageRequest createNotification(MessageRequest messageRequest) {
        return messageRequest;
    }

    @GetMapping("/list")
    public ResponseEntity<ApiResponse<List<NotificationResponseDTO>>> returnAllNotifications(HttpSession session) {
        UserResponseDTO user = (UserResponseDTO) session.getAttribute("account");
        if (user != null) {
            try {
                long id = URLIdEncoder.decodeId(user.getEncodeId());
                return ResponseEntity.ok(new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "All notifications of user with id " + id,
                        nSrv.getAllNotificationsByUserId(id)));
            } catch (Exception e) {
                logger.log(Level.SEVERE, e.getMessage());
            }
        }
        return ResponseEntity.noContent().build();
    }
}
