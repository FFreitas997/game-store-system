package com.ffreitas.gamestoreserver.platform.mapper;

import com.ffreitas.gamestoreserver.platform.dto.ResponseSupportedPlatformDto;
import com.ffreitas.gamestoreserver.platform.entities.SupportedPlatform;

public class SupportedPlatformMapper {

    private SupportedPlatformMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static ResponseSupportedPlatformDto toResponse(SupportedPlatform entity) {
        if (entity == null) return null;

        return ResponseSupportedPlatformDto
                .builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .website(entity.getWebsite())
                .logo(null)
                .build();
    }
}
