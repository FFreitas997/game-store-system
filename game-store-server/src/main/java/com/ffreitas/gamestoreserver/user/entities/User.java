package com.ffreitas.gamestoreserver.user.entities;

import com.ffreitas.gamestoreserver.comment.entities.Comment;
import com.ffreitas.gamestoreserver.common.BaseEntity;
import com.ffreitas.gamestoreserver.notification.entities.Notification;
import com.ffreitas.gamestoreserver.request.entities.GameRequest;
import com.ffreitas.gamestoreserver.wishlist.entities.Wishlist;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "_user")
public class User extends BaseEntity {

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "profile_picture")
    private String profilePicture;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Comment> comments;

    @OneToOne
    @JoinColumn(name = "wishlist_id")
    private Wishlist wishlist;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Notification> notifications;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<GameRequest> requests;

}