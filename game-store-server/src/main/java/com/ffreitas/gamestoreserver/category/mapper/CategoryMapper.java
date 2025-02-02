package com.ffreitas.gamestoreserver.category.mapper;

import com.ffreitas.gamestoreserver.category.dto.ResponseCategoryDto;
import com.ffreitas.gamestoreserver.category.entities.Category;

public class CategoryMapper {

    private CategoryMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static ResponseCategoryDto toResponse(Category entity) {
        if (entity == null) return null;

        return ResponseCategoryDto
                .builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .build();
    }
}
