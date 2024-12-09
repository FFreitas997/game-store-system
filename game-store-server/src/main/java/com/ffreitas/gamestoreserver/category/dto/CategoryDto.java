package com.ffreitas.gamestoreserver.category.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.io.Serializable;

/**
 * DTO for {@link com.ffreitas.gamestoreserver.category.entities.Category}
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Builder
public record CategoryDto(

        Integer id,

        @NotNull(message = "Name cannot be null")
        @Size(max = 100, message = "Name must have a maximum of 100 characters")
        @NotEmpty(message = "Name cannot be empty")
        String name,

        @Size(max = 500, message = "Description must have a maximum of 500 characters")
        String description

) implements Serializable { }