package com.ffreitas.gamestoreserver.game.repositories;

import com.ffreitas.gamestoreserver.game.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, String> {
}