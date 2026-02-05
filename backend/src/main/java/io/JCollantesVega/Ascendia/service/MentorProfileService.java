package io.JCollantesVega.Ascendia.service;

import java.util.UUID;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.JCollantesVega.Ascendia.Enum.Role;
import io.JCollantesVega.Ascendia.Repository.MentorProfileRepository;
import io.JCollantesVega.Ascendia.Repository.UserRepository;
import io.JCollantesVega.Ascendia.dto.mentorProfile.MentorProfileRequest;
import io.JCollantesVega.Ascendia.dto.mentorProfile.MentorProfileResponse;
import io.JCollantesVega.Ascendia.mapper.MentorProfileMapper;
import io.JCollantesVega.Ascendia.model.MentorProfile;
import io.JCollantesVega.Ascendia.model.User;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MentorProfileService {

    private final MentorProfileRepository mentorProfileRepository;
    private final UserRepository userRepository;
    private final MentorProfileMapper mentorProfileMapper;

    @Transactional
    public MentorProfileResponse saveOrUpdateMentorProfile(MentorProfileRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();

        if (currentUser.getRole() != Role.MENTOR) {
            throw new AccessDeniedException("Only users with MENTOR role can create or update mentor profiles");
        }

        MentorProfile profile = mentorProfileRepository.findByUserId(currentUser.getId())
                .orElse(null);

        MentorProfile savedProfile;
        if (profile == null) {
            savedProfile = mentorProfileRepository.save(
                mentorProfileMapper.createEntityFromRequest(request, currentUser)
            );
        } else {
            mentorProfileMapper.updateEntityFromRequest(request, profile);
            savedProfile = mentorProfileRepository.save(profile);
        }

        return mentorProfileMapper.toResponse(savedProfile);
    }

    @Transactional(readOnly = true)
    public MentorProfileResponse getMentorProfile(UUID profileId) {
        MentorProfile profile = mentorProfileRepository.findById(profileId)
                .orElseThrow(() -> new EntityNotFoundException("Mentor profile not found with id: " + profileId));

        return mentorProfileMapper.toResponse(profile);
    }

    @Transactional(readOnly = true)
    public MentorProfileResponse getMyMentorProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();

        if (currentUser.getRole() != Role.MENTOR) {
            throw new AccessDeniedException("Only users with MENTOR role can view their mentor profile");
        }

        MentorProfile profile = mentorProfileRepository.findByUserId(currentUser.getId())
                .orElseThrow(() -> new EntityNotFoundException("Mentor profile not found for current user"));

        return mentorProfileMapper.toResponse(profile);
    }

    @Transactional(readOnly = true)
    public MentorProfileResponse getMentorProfileByUserId(UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));

        if (user.getRole() != Role.MENTOR) {
            throw new EntityNotFoundException("User is not a mentor: " + userId);
        }

        MentorProfile profile = mentorProfileRepository.findByUserId(userId)
                .orElseThrow(() -> new EntityNotFoundException("Mentor profile not found for user: " + userId));

        return mentorProfileMapper.toResponse(profile);
    }
}