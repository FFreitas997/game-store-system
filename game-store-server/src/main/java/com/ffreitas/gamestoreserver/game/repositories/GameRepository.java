package com.ffreitas.gamestoreserver.game.repositories;

import com.ffreitas.gamestoreserver.category.entities.Category;
import com.ffreitas.gamestoreserver.game.entities.Game;
import com.ffreitas.gamestoreserver.platform.entities.SupportedPlatform;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, String>, JpaSpecificationExecutor<Game> {

    Page<Game> findAllByCategories(List<Category> categories, Pageable pageable);

    Page<Game> findAllBySupportedPlatforms(List<SupportedPlatform> supportedPlatforms, Pageable pageable);

    boolean existsGamesByTitle(String title);

}

/*
    -- Without custom query
    List<Game> findAllByCategoryId(String categoryId);

    -- Custom Query with @Query annotation and JPQL
    @Query("""
            SELECT g
            FROM Game g
            INNER JOIN g.category c
            WHERE lower(c.name) like lower(:catName)
            ORDER BY g.title ASC
            """)
    List<Game> findAllByCategoryName(String categoryName);

    -- Custom Query with Paging and Sorting
    Page<Game> findAllByCategoryName(String categoryName, Pageable pageable);

    -- Custom Query with @Query annotation and Modifying
    @Modifying
    @Query("update Game g set g.title = upper(g.title)")
    void transformGamesTitleToUpperCase();

    -- Spring Projections
    @Query("SELECT g.title as title, g.price as price FROM Game g")
    List<GameProjection> findAllGameProjections();

    interface GameProjection {
        String getTitle();
        BigDecimal getPrice();
    }

    */