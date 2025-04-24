package com.FindMyRoom.service;

import com.FindMyRoom.dto.response.NotificationResponseDTO;

import java.util.List;

public interface NotificationService {
    List<NotificationResponseDTO> getAllNotificationsByUserId(Long userId);
}
