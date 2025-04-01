package com.ffreitas.gamestoreserver.game.mapper;

import com.ffreitas.gamestoreserver.category.dto.ResponseCategoryDto;
import com.ffreitas.gamestoreserver.category.mapper.CategoryMapper;
import com.ffreitas.gamestoreserver.comment.dto.ResponseCommentDto;
import com.ffreitas.gamestoreserver.comment.mapper.CommentMapper;
import com.ffreitas.gamestoreserver.game.dto.ResponseGameDto;
import com.ffreitas.gamestoreserver.game.entities.Game;
import com.ffreitas.gamestoreserver.platform.dto.ResponseSupportedPlatformDto;
import com.ffreitas.gamestoreserver.platform.mapper.SupportedPlatformMapper;

import java.util.Collections;
import java.util.List;

public class GameMapper {

    private GameMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static ResponseGameDto toResponse(Game entity) {
        if (entity == null) return null;

        List<ResponseCategoryDto> categories = entity
                .getCategories()
                .stream()
                .map(CategoryMapper::toResponse)
                .toList();


        List<ResponseSupportedPlatformDto> supportedPlatforms = entity
                .getSupportedPlatforms()
                .stream()
                .map(SupportedPlatformMapper::toResponse)
                .toList();

        return ResponseGameDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .supportedPlatform(supportedPlatforms)
                .cover(entity.getCover())
                .categories(categories)
                .comments(Collections.emptyList())
                .build();
    }
}
