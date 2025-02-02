package com.ffreitas.gamestoreserver.platform.repository;

import com.ffreitas.gamestoreserver.platform.entities.SupportedPlatform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportedPlatformRepository extends JpaRepository<SupportedPlatform, String> {
}
