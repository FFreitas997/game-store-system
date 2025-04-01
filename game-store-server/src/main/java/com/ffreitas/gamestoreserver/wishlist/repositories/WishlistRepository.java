package com.ffreitas.gamestoreserver.wishlist.repositories;

import com.ffreitas.gamestoreserver.game.entities.Game;
import com.ffreitas.gamestoreserver.wishlist.entities.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, String> {

    long countByGames(List<Game> games);

    List<Wishlist> findAllByGames(List<Game> games);
}