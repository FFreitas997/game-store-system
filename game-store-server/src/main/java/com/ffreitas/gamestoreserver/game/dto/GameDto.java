package com.ffreitas.gamestoreserver.game.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.ffreitas.gamestoreserver.comment.dto.CommentDto;
import com.ffreitas.gamestoreserver.game.entities.Genre;
import com.ffreitas.gamestoreserver.game.entities.Platform;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link com.ffreitas.gamestoreserver.game.entities.Game}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Builder
public record GameDto(

        Integer id,

        @NotNull(message = "Title cannot be null")
        @Size(max = 100, message = "Title cannot have more than 100 characters")
        @NotEmpty(message = "Title cannot be empty")
        String title,

        @Size(max = 500, message = "Description cannot be longer than 500 characters")
        String description,

        @NotNull(message = "Genre cannot be null")
        Genre genre,

        @NotNull(message = "Platform cannot be null")
        Platform supportedPlatform,

        String cover,

        Set<CommentDto> comments

) implements Serializable { }