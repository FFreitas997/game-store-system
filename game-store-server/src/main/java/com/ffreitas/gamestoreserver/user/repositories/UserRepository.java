package com.ffreitas.gamestoreserver.user.repositories;

import com.ffreitas.gamestoreserver.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}