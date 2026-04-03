package com.hireFlow.dto;

import com.hireFlow.enums.JobStatus;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class JobResponseDto {
    private Long id;
    private Long UserId;
    private String companyName;
    private String notes;
    private String role;
    private JobStatus status;
    private LocalDate appliedDate;
    private LocalDateTime lastUpdated;

}
