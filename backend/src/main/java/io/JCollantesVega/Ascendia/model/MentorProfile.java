package io.JCollantesVega.Ascendia.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import static jakarta.persistence.FetchType.LAZY;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "mentor_profiles")
public class MentorProfile {
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID id;

    @Column(columnDefinition = "TEXT")
    private String bio;

    @NotBlank
    private String speciality;

    @Positive
    private double priceHour;

    @NotBlank
    private String timezone;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "user_id", nullable=false, unique=true)
    private User user;

    @OneToMany(mappedBy = "mentor", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<AvailabilitySlot> availabilitySlots = new ArrayList<>();

    @OneToMany(mappedBy = "mentor", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Booking> bookings = new ArrayList<>();

    public void addAvailabilitySlot(AvailabilitySlot availabilitySlot) {
        availabilitySlots.add(availabilitySlot);
        availabilitySlot.setMentor(this);
    }
}
