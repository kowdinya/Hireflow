package com.hireFlow.dto;

import com.hireFlow.enums.JobStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;



@Data
@Getter
@Setter
public class JobRequestDto {
@NotNull(message = "userId cannot be null")
    private Long userId;
@NotBlank(message = "company name cannot be empty")
    private String companyName;
    private String notes;
    private JobStatus status;
    @NotNull(message = "status cannot be null")
    @NotNull(message = "role cannot be empty")
    private String role;

}
