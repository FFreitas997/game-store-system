package com.ffreitas.gamestoreserver.notification.services;

import com.ffreitas.gamestoreserver.notification.repositories.NotificationRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class DefaultNotificationService implements NotificationService {

    private final NotificationRepository repository;
}
