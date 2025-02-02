package com.ffreitas.gamestoreserver.game.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link com.ffreitas.gamestoreserver.game.entities.Game}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record RequestGameDto(

        @NotNull(message = "Title cannot be null")
        @NotEmpty(message = "Title cannot be empty")
        @Size(max = 100, message = "Title cannot have more than 100 characters")
        String title,

        @Size(max = 500, message = "Description cannot be longer than 500 characters")
        String description,

        @NotNull(message = "Category ID cannot be null")
        @NotEmpty(message = "Category ID cannot be empty")
        Set<String> categoriesID,

        @NotNull(message = "Price cannot be null")
        @NotEmpty(message = "Price cannot be empty")
        Set<String> supportedPlatformsID

) implements Serializable {
}