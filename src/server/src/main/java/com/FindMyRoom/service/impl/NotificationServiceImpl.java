package com.FindMyRoom.service.impl;

import com.FindMyRoom.dto.response.NotificationResponseDTO;
import com.FindMyRoom.mapping.NotificationMapping;
import com.FindMyRoom.model.Notification;
import com.FindMyRoom.repository.NotificationRepository;
import com.FindMyRoom.service.NotificationService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepository repo;
    private NotificationMapping mapping;
    private final Logger logger = Logger.getLogger(NotificationServiceImpl.class.getName());

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
