package com.ffreitas.gamestoreserver.game.entities;

import com.ffreitas.gamestoreserver.category.entities.Category;
import com.ffreitas.gamestoreserver.comment.entities.Comment;
import com.ffreitas.gamestoreserver.common.BaseEntity;
import com.ffreitas.gamestoreserver.platform.entities.SupportedPlatform;
import com.ffreitas.gamestoreserver.wishlist.entities.Wishlist;
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
@Table(name = "game")
public class Game extends BaseEntity {

    @Column(name = "game_title", nullable = false, unique = true, length = 100)
    private String title;

    @Column(name = "game_description", length = 500)
    private String description;

    @Column(name = "game_cover")
    private String cover;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @OrderBy("name ASC")
    private List<Category> categories;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @OrderBy("name ASC")
    private List<SupportedPlatform> supportedPlatforms;

    @OneToMany(mappedBy = "game", fetch = FetchType.LAZY, orphanRemoval = true)
    @OrderBy("createdAt DESC")
    private List<Comment> comments;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
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

    public void addPlatform(SupportedPlatform platform) {
        if (platform == null) return;
        this.supportedPlatforms.add(platform);
        platform.getGames().add(this);
    }

    public void removePlatform(SupportedPlatform platform) {
        if (platform == null) return;
        this.supportedPlatforms.remove(platform);
        platform.getGames().remove(this);
    }

    public void addCategory(Category category) {
        if (category == null) return;
        this.categories.add(category);
        category.getGames().add(this);
    }

    public void removeCategory(Category category) {
        if (category == null) return;
        this.categories.remove(category);
        category.getGames().remove(this);
    }
}