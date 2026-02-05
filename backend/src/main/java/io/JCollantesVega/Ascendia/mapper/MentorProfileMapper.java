package io.JCollantesVega.Ascendia.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import io.JCollantesVega.Ascendia.dto.mentorProfile.MentorProfileRequest;
import io.JCollantesVega.Ascendia.dto.mentorProfile.MentorProfileResponse;
import io.JCollantesVega.Ascendia.model.MentorProfile;
import io.JCollantesVega.Ascendia.model.User;

@Mapper(componentModel = "spring")
public interface MentorProfileMapper {
    
    MentorProfileMapper INSTANCE = Mappers.getMapper(MentorProfileMapper.class);
    
    MentorProfileResponse toResponse(MentorProfile profile);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", source = "user")
    @Mapping(target = "availabilitySlots", ignore = true)
    @Mapping(target = "bookings", ignore = true)
    MentorProfile createEntityFromRequest(MentorProfileRequest request, User user);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "availabilitySlots", ignore = true)
    @Mapping(target = "bookings", ignore = true)
    void updateEntityFromRequest(MentorProfileRequest request, @MappingTarget MentorProfile profile);
}