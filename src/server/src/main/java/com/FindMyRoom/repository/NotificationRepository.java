package com.FindMyRoom.repository;

import com.FindMyRoom.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findAllByUserId(long id);
}
