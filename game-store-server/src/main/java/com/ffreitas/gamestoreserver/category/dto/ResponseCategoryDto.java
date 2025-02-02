package com.ffreitas.gamestoreserver.category.dto;

import lombok.Builder;

import java.io.Serializable;

/**
 * DTO for {@link com.ffreitas.gamestoreserver.category.entities.Category}
 */
@Builder
public record ResponseCategoryDto(

        String id,

        String name,

        String description

) implements Serializable {
}