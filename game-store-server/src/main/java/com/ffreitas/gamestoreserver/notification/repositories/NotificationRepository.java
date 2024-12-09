package com.ffreitas.gamestoreserver.notification.repositories;

import com.ffreitas.gamestoreserver.notification.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, String> {
}