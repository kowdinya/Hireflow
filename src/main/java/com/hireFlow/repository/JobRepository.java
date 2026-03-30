package com.hireFlow.repository;

import com.hireFlow.enums.JobStatus;
import com.hireFlow.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobRepository extends JpaRepository<Job,Long> {

    //for finding all the jobs of a user
    List<Job> findByUserId(Long userId);

    List<Job> findByUserIdAndStatus(Long userId, JobStatus status);

}
