package com.itrecruitmentapi.repository;

import com.itrecruitmentapi.entity.JobPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobPostRepository extends JpaRepository<JobPostEntity, Integer> {
}
