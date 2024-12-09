package com.ffreitas.gamestoreserver.comment.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.io.Serializable;

/**
 * DTO for {@link com.ffreitas.gamestoreserver.comment.entities.Comment}
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Builder
public record CommentDto(

        Integer id,

        @NotNull(message = "Comment content cannot be null")
        @Size(max = 1000, message = "Comment content cannot have more than 1000 characters")
        @NotEmpty(message = "Comment content cannot be empty")
        String content

) implements Serializable { }