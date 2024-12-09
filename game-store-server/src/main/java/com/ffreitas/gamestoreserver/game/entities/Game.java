package com.ffreitas.gamestoreserver.game.entities;

import com.ffreitas.gamestoreserver.comment.entities.Comment;
import com.ffreitas.gamestoreserver.common.BaseEntity;
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
@Table(name = "game")
public class Game extends BaseEntity {

    @Column(name = "game_title", nullable = false)
    private String title;

    @Column(name = "game_description")
    private String description;

    @Column(name = "game_genre", nullable = false)
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Column(name = "supported_platform", nullable = false)
    @Enumerated(EnumType.STRING)
    private Platform supportedPlatform;

    @Column(name = "game_cover")
    private String cover;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
    private List<Comment> comments;

    @ManyToMany(mappedBy = "games")
    private List<Wishlist> wishlists;

}