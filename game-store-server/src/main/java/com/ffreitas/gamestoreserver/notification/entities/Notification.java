package com.ffreitas.gamestoreserver.notification.entities;

import com.ffreitas.gamestoreserver.common.BaseEntity;
import com.ffreitas.gamestoreserver.user.entities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
@Table(name = "notification")
public class Notification extends BaseEntity {

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "receiver", nullable = false)
    private String receiver;

    @Column(name = "level", nullable = false)
    @Enumerated(EnumType.STRING)
    private NotificationLevel level;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private NotificationStatus status;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}