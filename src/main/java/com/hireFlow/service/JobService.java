package com.hireFlow.service;

import com.hireFlow.dto.JobRequestDto;
import com.hireFlow.enums.JobStatus;
import com.hireFlow.model.Job;
import com.hireFlow.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JobService {

    private final JobRepository jobRepository;
    public JobService(JobRepository jobRepository){

        this.jobRepository=jobRepository;
    }

    public Job saveJob(JobRequestDto dto){
    if(dto== null){
        throw new RuntimeException("Job cannot be null");
    }
        Job job = new Job();
    job.setUserId(dto.getUserId());
    job.setCompanyName(dto.getCompanyName());
    job.setRole(dto.getRole());
    job.setStatus(dto.getStatus());
    job.setNotes(dto.getNotes());
    Job saved = jobRepository.save(job);
    return saved;
    }
    public List<Job> getJobsByUserId(Long userId){
        if(userId==null){
            throw new IllegalArgumentException("user Id cannot be null");
        }
        return jobRepository.findByUserId(userId);
    }
public List<Job> getJobsByUserIdAndStatus(Long userId, JobStatus status){
        if(userId==null || status==null){
            throw  new IllegalArgumentException("userId or status of Job should not be empty");
        }
        return jobRepository.findByUserIdAndStatus(userId,status);
}
}
