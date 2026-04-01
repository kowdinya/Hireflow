package com.hireFlow.controller;

import com.hireFlow.model.Job;
import com.hireFlow.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return jobService.saveJob(job);
        }
    }
