package io.JCollantesVega.Ascendia.mapper;

import io.JCollantesVega.Ascendia.dto.mentorProfile.MentorProfileRequest;
import io.JCollantesVega.Ascendia.dto.mentorProfile.MentorProfileResponse;
import io.JCollantesVega.Ascendia.model.MentorProfile;
import io.JCollantesVega.Ascendia.model.User;

public class MentorProfileMapper {

    public static MentorProfileResponse toResponse(MentorProfile profile) {
        return new MentorProfileResponse(
            profile.getId(),
            profile.getBio(),
            profile.getSpeciality(),
            profile.getPriceHour(),
            profile.getTimezone()
        );
    }

    public static void updateEntityFromRequest(MentorProfileRequest request, MentorProfile profile) {
        profile.setBio(request.bio());
        profile.setSpeciality(request.speciality());
        profile.setPriceHour(request.priceHour());
        profile.setTimezone(request.timezone());
    }

    public static MentorProfile createEntityFromRequest(MentorProfileRequest request, User user) {
        MentorProfile profile = new MentorProfile();
        profile.setBio(request.bio());
        profile.setSpeciality(request.speciality());
        profile.setPriceHour(request.priceHour());
        profile.setTimezone(request.timezone());
        profile.setUser(user);
        return profile;
    }
}