package com.itrecruitmentapi.repository;

import com.itrecruitmentapi.entity.EmployerResumeEntity;
import com.itrecruitmentapi.entity.JobPostEntity;
import com.itrecruitmentapi.entity.StatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobPostRepository extends JpaRepository<JobPostEntity, Integer> {
    List<JobPostEntity> findJobPostEntitiesByStatusEntity(StatusEntity statusEntity);
    List<JobPostEntity> findJobPostEntitiesByEmployerResumeEntityAndStatusEntity(EmployerResumeEntity employerResumeEntity, StatusEntity statusEntity);
}
