package com.ffreitas.gamestoreserver.request.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.ffreitas.gamestoreserver.request.entities.RequestStatus;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.io.Serializable;

/**
 * DTO for {@link com.ffreitas.gamestoreserver.request.entities.GameRequest}
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Builder
public record GameRequestDto(

        Integer id,

        @NotNull(message = "Game request title cannot be null")
        @Size(max = 100, message = "Game request title must have a maximum of 255 characters")
        @NotEmpty(message = "Game request title cannot be empty")
        String title,

        @NotNull(message = "Game request description cannot be null")
        @Size(max = 500, message = "Game request description must have a maximum of 500 characters")
        @NotEmpty(message = "Game request description cannot be empty")
        String description,

        @NotNull(message = "Game request status cannot be null")
        RequestStatus status

) implements Serializable { }