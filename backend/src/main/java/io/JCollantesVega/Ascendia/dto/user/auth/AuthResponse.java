package io.JCollantesVega.Ascendia.dto.user.auth;

import io.JCollantesVega.Ascendia.Enum.Role;

public record AuthResponse(
    String token,
    String username,
    String email,
    Role role
){}
