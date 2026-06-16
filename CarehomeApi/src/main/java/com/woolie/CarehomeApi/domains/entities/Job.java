package com.woolie.CarehomeApi.domains.entities;

import com.woolie.CarehomeApi.domains.entities.embedded.TimeFrame;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "jobs")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "startDate", column = @Column(name = "start_date", nullable = false)),
            @AttributeOverride(name = "endDate", column = @Column(name = "end_date", nullable = false)),
    })
    private TimeFrame timeFrame;

    @ElementCollection
    private List<String> requiredSkills;

    @Enumerated(EnumType.STRING)
    private JobPriority  priority;

    @Enumerated(EnumType.STRING)
    private JobStatus jobStatus;

    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Application> applications = new ArrayList<>();

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return Objects.equals(id, job.id) && Objects.equals(title, job.title) && Objects.equals(description, job.description) && Objects.equals(timeFrame, job.timeFrame) && Objects.equals(requiredSkills, job.requiredSkills) && priority == job.priority && jobStatus == job.jobStatus && Objects.equals(createdAt, job.createdAt) && Objects.equals(updatedAt, job.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, timeFrame, requiredSkills, priority, jobStatus, createdAt, updatedAt);
    }

    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        this.createdAt = now;
        this.updatedAt = now;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
