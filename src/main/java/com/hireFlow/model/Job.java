package com.hireFlow.model;
import com.hireFlow.enums.JobStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="user_id",nullable = false)
    private Long userId;
    @Column(name = "company_name",nullable = false)
    private String companyName;
    @Column(name ="role",nullable = false)
    private String role;
    @Column(name ="applied_date")
    private LocalDate appliedDate;
    @Column(name ="last_updated")
    private LocalDateTime lastUpdated;
    @Column(name ="notes")
    private String notes;

    @Enumerated(EnumType.STRING)
    @Column(name ="status",nullable = false)
    private JobStatus status;
    @PrePersist
    @PreUpdate
    public void updateTimestamp() {
        this.lastUpdated = LocalDateTime.now();
    }
}
