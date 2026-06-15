package com.woolie.CarehomeApi.domains.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "applications")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String pitch;

    @Column(nullable = false)
    private LocalDateTime appliedAt;

    @Enumerated(EnumType.STRING)
    private ApplicationStatus applicationStatus;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Application that = (Application) o;
        return Objects.equals(id, that.id) && Objects.equals(pitch, that.pitch) && Objects.equals(appliedAt, that.appliedAt) && applicationStatus == that.applicationStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pitch, appliedAt, applicationStatus);
    }

    @PrePersist
    protected void onCreate() {
        this.appliedAt = LocalDateTime.now();
    }
}
