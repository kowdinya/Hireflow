package com.hireFlow.dto;

import com.hireFlow.enums.JobStatus;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Getter
@Setter
public class JobRequestDto {
    private Long userId;
    private String companyName;
    private String notes;
    private JobStatus status;
    private String role;

}
