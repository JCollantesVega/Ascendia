package io.JCollantesVega.Ascendia.dto.user;

import io.JCollantesVega.Ascendia.Enum.Role;

public record RegisterResponse(
    String token,
    String username,
    String email,
    Role role
) {}
