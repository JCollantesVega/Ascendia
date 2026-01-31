package io.JCollantesVega.Ascendia.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import io.JCollantesVega.Ascendia.model.MentorProfile;

public interface MentorProfileRepository extends JpaRepository<MentorProfile, UUID>{
}
