package com.ffreitas.gamestoreserver.user.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.io.Serializable;

/**
 * DTO for {@link com.ffreitas.gamestoreserver.user.entities.User}
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Builder
public record UserDto(

        Integer id,

        @NotNull(message = "First name cannot be null")
        @Size(max = 50, message = "First name cannot have more than 50 characters")
        @NotEmpty(message = "First name cannot be empty")
        String firstName,

        @NotNull(message = "Last name cannot be null")
        @Size(max = 50, message = "Last name cannot have more than 50 characters")
        @NotEmpty(message = "Last name cannot be empty")
        String lastName,

        @NotNull(message = "Email cannot be null")
        @Email(message = "Email should be valid", regexp = "^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")
        @NotEmpty(message = "Email cannot be empty")
        String email,

        @NotNull(message = "Role cannot be null")
        String role,

        String profilePicture

) implements Serializable {
}