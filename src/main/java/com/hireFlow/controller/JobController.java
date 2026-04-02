package com.hireFlow.controller;

import com.hireFlow.model.Job;
import com.hireFlow.service.JobService;
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
    public Job saveJob(@RequestBody Job job){
        System.out.println("companyName from request:  " +job.getCompanyName());
        return jobService.saveJob(job);
        }
        @GetMapping("/user")
    public List<Job> getJobsByUserId(@RequestParam Long userId){
        return jobService.getJobsByUserId(userId);

        }
    }
