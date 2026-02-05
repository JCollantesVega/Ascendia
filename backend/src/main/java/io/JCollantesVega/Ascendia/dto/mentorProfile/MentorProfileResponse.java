package io.JCollantesVega.Ascendia.dto.mentorProfile;

import java.util.UUID;

public record MentorProfileResponse(
    UUID id,
    String bio,
    String speciality,
    Double priceHour,
    String timezone
) {

}
