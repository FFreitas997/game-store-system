package com.ffreitas.gamestoreserver.request.repositories;

import com.ffreitas.gamestoreserver.request.entities.GameRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRequestRepository extends JpaRepository<GameRequest, String> {
}