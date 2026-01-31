package io.JCollantesVega.Ascendia.dto.user;

import io.JCollantesVega.Ascendia.Enum.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record RegisterRequest (
    @NotBlank(message = "Username is required")
    String username,
    @NotBlank(message = "Email is required")
    String email,
    @NotBlank(message = "Password is required")
    String password,
    @NotNull(message = "Role is required")
    Role role,

    String avatarUrl
){

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public Role getRole() {
        return role;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }
}
