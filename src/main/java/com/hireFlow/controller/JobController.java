package com.hireFlow.controller;

import com.hireFlow.dto.JobRequestDto;
import com.hireFlow.enums.JobStatus;
import com.hireFlow.model.Job;
import com.hireFlow.service.JobService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
//@RequiredArgsConstructor
public class JobController {

    private final JobService jobService;
    public JobController(JobService jobService){
        this.jobService=jobService;
    }

    @PostMapping
    public Job saveJob( @RequestBody @Valid JobRequestDto dto){
        System.out.println("companyName from request:  " +dto);
        return jobService.saveJob(dto);
        }
        @GetMapping("/user")
    public List<Job> getJobsByUserId(@RequestParam Long userId){
        return jobService.getJobsByUserId(userId);

        }
        @GetMapping("/getByUserIdAndStatus")
    public List<Job> getJobsByUserIdAndStatus(@RequestParam Long userId, @RequestParam JobStatus status){
        return jobService.getJobsByUserIdAndStatus(userId,status);
        }
    }
