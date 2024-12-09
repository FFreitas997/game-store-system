package com.ffreitas.gamestoreserver.wishlist.repositories;

import com.ffreitas.gamestoreserver.wishlist.entities.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, String> {
}