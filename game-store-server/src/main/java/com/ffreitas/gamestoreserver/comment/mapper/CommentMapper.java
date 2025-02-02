package com.ffreitas.gamestoreserver.comment.mapper;

import com.ffreitas.gamestoreserver.comment.dto.ResponseCommentDto;
import com.ffreitas.gamestoreserver.comment.entities.Comment;

public class CommentMapper {

    private CommentMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static ResponseCommentDto toResponse(Comment entity) {
        if (entity == null) return null;

        return ResponseCommentDto
                .builder()
                .id(entity.getId())
                .content(entity.getContent())
                .createdAt(entity.getCreatedAt())
                .lastModifiedAt(entity.getLastModifiedAt())
                .build();
    }
}
