package io.JCollantesVega.Ascendia.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.JCollantesVega.Ascendia.dto.mentorProfile.MentorProfileRequest;
import io.JCollantesVega.Ascendia.dto.mentorProfile.MentorProfileResponse;
import io.JCollantesVega.Ascendia.service.MentorProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/api/v1/mentors")
@RestController
@RequiredArgsConstructor
@Tag(name = "Mentor", description = "Mentor profile management APIs")
@SecurityRequirement(name = "bearerAuth")
public class MentorController {
    
    private final MentorProfileService mentorProfileService;

    @PostMapping("/profile")
    @PreAuthorize("hasRole('MENTOR')")
    @Operation(summary = "Save or update mentor profile", description = "Create a new mentor profile or update existing one. Only users with MENTOR role can access this endpoint.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Profile saved/updated successfully"),
        @ApiResponse(responseCode = "403", description = "Access denied - user is not a mentor"),
        @ApiResponse(responseCode = "400", description = "Invalid request data")
    })
    public ResponseEntity<MentorProfileResponse> saveOrUpdateMentorProfile(
            @Valid @RequestBody MentorProfileRequest request) {
        MentorProfileResponse response = mentorProfileService.saveOrUpdateMentorProfile(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/profile/me")
    @PreAuthorize("hasRole('MENTOR')")
    @Operation(summary = "Get current user's mentor profile", description = "Retrieve the mentor profile of the currently authenticated user.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Profile retrieved successfully"),
        @ApiResponse(responseCode = "403", description = "Access denied - user is not a mentor"),
        @ApiResponse(responseCode = "404", description = "Profile not found")
    })
    public ResponseEntity<MentorProfileResponse> getMyMentorProfile() {
        MentorProfileResponse response = mentorProfileService.getMyMentorProfile();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/profile/{profileId}")
    @Operation(summary = "Get mentor profile by ID", description = "Retrieve a mentor profile by its ID. Accessible to all authenticated users.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Profile retrieved successfully"),
        @ApiResponse(responseCode = "404", description = "Profile not found")
    })
    public ResponseEntity<MentorProfileResponse> getMentorProfile(
            @PathVariable UUID profileId) {
        MentorProfileResponse response = mentorProfileService.getMentorProfile(profileId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/user/{userId}")
    @Operation(summary = "Get mentor profile by user ID", description = "Retrieve a mentor profile by the user's ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Profile retrieved successfully"),
        @ApiResponse(responseCode = "404", description = "User or profile not found")
    })
    public ResponseEntity<MentorProfileResponse> getMentorProfileByUserId(
            @PathVariable UUID userId) {
        MentorProfileResponse response = mentorProfileService.getMentorProfileByUserId(userId);
        return ResponseEntity.ok(response);
    }
}
