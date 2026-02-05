package io.JCollantesVega.Ascendia.dto.mentorProfile;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record MentorProfileRequest(
    @NotBlank String bio,
    @NotBlank String speciality,
    @Positive Double priceHour,
    @NotBlank String timezone
)
{}
