package com.ffreitas.gamestoreserver.platform.dto;

import lombok.Builder;

import java.io.Serializable;

/**
 * DTO for {@link com.ffreitas.gamestoreserver.platform.entities.SupportedPlatform}
 */
@Builder
public record ResponseSupportedPlatformDto(

        String id,

        String name,

        String description,

        String website,

        String logo

) implements Serializable { }