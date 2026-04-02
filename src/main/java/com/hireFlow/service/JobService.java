package com.hireFlow.service;

import com.hireFlow.model.Job;
import com.hireFlow.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    private final JobRepository jobRepository;
    public JobService(JobRepository jobRepository){
        this.jobRepository=jobRepository;
    }
    public Job saveJob(Job job){
    if(job== null){
        throw new RuntimeException("Job cannot be null");
    }
    return jobRepository.save(job);
    }
    public List<Job> getJobsByUserId(Long userId){
        if(userId==null){
            throw new IllegalArgumentException("user Id cannot be null");
        }
        return jobRepository.findByUserId(userId);
    }

}
