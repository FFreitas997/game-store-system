package com.ffreitas.gamestoreserver.wishlist.entities;

import com.ffreitas.gamestoreserver.common.BaseEntity;
import com.ffreitas.gamestoreserver.game.entities.Game;
import com.ffreitas.gamestoreserver.user.entities.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "whishlist")
public class Wishlist extends BaseEntity {

    @ManyToMany
    @JoinTable(
            name = "wishlist_game",
            joinColumns = @JoinColumn(name = "wihslist_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id")
    )
    private List<Game> games;

    @OneToOne(mappedBy = "wishlist")
    private User user;

}