package com.FindMyRoom.service.impl;

import com.FindMyRoom.dto.response.NotificationResponseDTO;
import com.FindMyRoom.mapping.NotificationMapping;
import com.FindMyRoom.model.Notification;
import com.FindMyRoom.repository.NotificationRepository;
import com.FindMyRoom.service.NotificationService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class NotificationServiceImpl implements NotificationService {
    NotificationRepository repo;
    NotificationMapping mapping;
    Logger logger = Logger.getLogger(NotificationServiceImpl.class.getName());

    public NotificationServiceImpl(NotificationRepository repo) {
        this.repo = repo;
        this.mapping = new NotificationMapping();
    }

    @Override
    public List<NotificationResponseDTO> getAllNotificationsByUserId(Long userId) {
        logger.info("getAllNotificationsByUserId");
        List<Notification> notis = repo.findAllByUserId(userId);
        List<NotificationResponseDTO> dtos = new ArrayList<>();
        notis.forEach(n -> dtos.add(mapping.convert(n)));
        return dtos;
    }
}
