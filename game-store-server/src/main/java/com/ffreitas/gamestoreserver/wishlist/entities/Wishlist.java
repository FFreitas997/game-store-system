package com.ffreitas.gamestoreserver.wishlist.entities;

import com.ffreitas.gamestoreserver.common.BaseEntity;
import com.ffreitas.gamestoreserver.game.entities.Game;
import com.ffreitas.gamestoreserver.user.entities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
@Table(name = "whishlist")
public class Wishlist extends BaseEntity {

    @ManyToMany(mappedBy = "wishlists")
    private List<Game> games;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}