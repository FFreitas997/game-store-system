package com.ffreitas.gamestoreserver.game.dto;

import com.ffreitas.gamestoreserver.category.dto.ResponseCategoryDto;
import com.ffreitas.gamestoreserver.comment.dto.ResponseCommentDto;
import com.ffreitas.gamestoreserver.platform.dto.ResponseSupportedPlatformDto;
import lombok.Builder;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.ffreitas.gamestoreserver.game.entities.Game}
 */
@Builder
public record ResponseGameDto(

        String id,

        String title,

        String description,

        List<ResponseSupportedPlatformDto> supportedPlatform,

        String cover,

        List<ResponseCategoryDto> categories,

        List<ResponseCommentDto> comments

) implements Serializable {
}