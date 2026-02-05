package io.JCollantesVega.Ascendia.dto.user;

import java.util.UUID;

public record UserResponse(
    UUID id,
    String username,
    String email,
    String role
) {}
