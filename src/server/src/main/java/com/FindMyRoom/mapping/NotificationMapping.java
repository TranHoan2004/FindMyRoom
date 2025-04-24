package com.FindMyRoom.mapping;

import com.FindMyRoom.controller.utils.URLIdEncoder;
import com.FindMyRoom.dto.response.NotificationResponseDTO;
import com.FindMyRoom.model.Notification;
import org.jetbrains.annotations.NotNull;

public class NotificationMapping {
    public NotificationResponseDTO convert(@NotNull Notification notification) {
        return NotificationResponseDTO.builder()
                .id(URLIdEncoder.encodeId(notification.getId()))
                .title(notification.getTitle())
                .link(notification.getLink())
                .message(notification.getMessage())
                .build();
    }
}
