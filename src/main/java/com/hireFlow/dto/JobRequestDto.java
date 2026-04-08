package com.hireFlow.dto;

import com.hireFlow.enums.JobStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
@Size(min =3)
    private String companyName;
    private String notes;
    private JobStatus status;
    @NotNull(message = "status cannot be null")
    @NotNull(message = "role cannot be empty")
    private String role;

}
