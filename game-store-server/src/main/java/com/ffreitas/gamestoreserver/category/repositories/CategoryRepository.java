package com.ffreitas.gamestoreserver.category.repositories;

import com.ffreitas.gamestoreserver.category.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

    /*
    -- Without custom query
    List<Category> findAllByNameStartingWithIgnoreCaseByOrderByNameAsc(String name);

    -- Custom Query with @Query annotation and JPQL
    @Query("""
            SELECT c
            FROM Category c
            WHERE lower(c.name) like lower(:catName)
            ORDER BY c.name ASC
            """)
    List<Category> findAllByNameWithJSQL(@Param("catName") String categoryName);

    -- Example of NamedQuery which is defined in the entity
    @Query(name = "Category.findByName")
    List<Category> findAllByNameWithNamedQuery(@Param("catName") String categoryName);

    -- Custom Native Query
    @Query(value = """
            SELECT *
            FROM category as c
            WHERE lower(c.name) like lower(:catName)
            ORDER BY c.name ASC
            """, nativeQuery = true)
    List<Category> findAllByNameWithNativeSQL(@Param("catName") String categoryName);
    */
}