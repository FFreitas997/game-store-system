package com.ffreitas.gamestoreserver.game.specification;

import com.ffreitas.gamestoreserver.game.entities.Game;
import org.springframework.data.jpa.domain.Specification;

public class GameSpecification {

    private GameSpecification() {
        throw new IllegalStateException("Utility class");
    }

    public static Specification<Game> byID(String id) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("id"), id);
    }

    public static Specification<Game> byTitle(String title) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get("title")), "%" + title.toLowerCase() + "%");
    }

    public static Specification<Game> byCategory(String categoryID) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("category").get("id"), categoryID);
    }
}
