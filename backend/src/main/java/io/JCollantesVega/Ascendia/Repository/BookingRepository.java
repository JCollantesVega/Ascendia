package io.JCollantesVega.Ascendia.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import io.JCollantesVega.Ascendia.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, UUID> {
}
