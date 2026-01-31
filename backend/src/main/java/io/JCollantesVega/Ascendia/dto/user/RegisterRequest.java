package io.JCollantesVega.Ascendia.dto.user;

import io.JCollantesVega.Ascendia.Enum.Role;
import jakarta.validation.constraints.NotBlank;


public record RegisterRequest (
    @NotBlank(message = "Username is required")
    String username,
    @NotBlank(message = "Email is required")
    String email,
    @NotBlank(message = "Password is required")
    String password,
    @NotBlank(message = "Role is required")
    Role role,

    String avatarUrl
){

    public String getEmail() {
        return email;
    }
}
