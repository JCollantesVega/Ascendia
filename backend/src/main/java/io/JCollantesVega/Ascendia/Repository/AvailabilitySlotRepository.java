package io.JCollantesVega.Ascendia.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import io.JCollantesVega.Ascendia.model.AvailabilitySlot;

public interface AvailabilitySlotRepository extends JpaRepository<AvailabilitySlot, UUID> {

}
