package com.ffreitas.gamestoreserver.category.repositories;

import com.ffreitas.gamestoreserver.category.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
}