package com.ffreitas.gamestoreserver.comment.dto;

import lombok.Builder;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.ffreitas.gamestoreserver.comment.entities.Comment}
 */
@Builder
public record ResponseCommentDto(

        String id,

        LocalDateTime createdAt,

        LocalDateTime lastModifiedAt,

        String content

) implements Serializable { }