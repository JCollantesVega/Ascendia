package io.JCollantesVega.Ascendia.model;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import io.JCollantesVega.Ascendia.Enum.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "bookings")
@EntityListeners(AuditingEntityListener.class)
public class Booking {
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID id;

    @NotNull
    @Future
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="mentor_id", nullable=false)
    private MentorProfile mentor;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="student_id", nullable=false)
    private User student;

    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @NotBlank
    private String meetingUrl;
}
