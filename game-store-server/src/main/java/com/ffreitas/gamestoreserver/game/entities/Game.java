package com.ffreitas.gamestoreserver.game.entities;

import com.ffreitas.gamestoreserver.category.entities.Category;
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

    @Column(name = "game_title", nullable = false, length = 100)
    private String title;

    @Column(name = "game_description", length = 500)
    private String description;

    @Column(name = "game_genre", nullable = false)
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Column(name = "supported_platform", nullable = false)
    @Enumerated(EnumType.STRING)
    private Platform supportedPlatform;

    @Column(name = "game_cover")
    private String cover;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "game", cascade = CascadeType.REMOVE)
    private List<Comment> comments;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "game_wishlist",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "wishlist_id")
    )
    private List<Wishlist> wishlists;

    public void addWishlist(Wishlist wishlist) {
        if (wishlist == null) return;
        this.wishlists.add(wishlist);
        wishlist.getGames().add(this);
    }

    public void removeWishlist(Wishlist wishlist) {
        if (wishlist == null) return;
        this.wishlists.remove(wishlist);
        wishlist.getGames().remove(this);
    }
}