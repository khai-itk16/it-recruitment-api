package com.itrecruitmentapi.repository;

import com.itrecruitmentapi.entity.EmployerResumeEntity;
import com.itrecruitmentapi.entity.JobPostEntity;
import com.itrecruitmentapi.entity.StatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobPostRepository extends JpaRepository<JobPostEntity, Integer> {
    List<JobPostEntity> findJobPostEntitiesByStatusEntityOrderByCreatePostTimeDesc(StatusEntity statusEntity);
    List<JobPostEntity> findJobPostEntitiesByEmployerResumeEntityAndStatusEntityOrderByCreatePostTimeDesc(EmployerResumeEntity employerResumeEntity, StatusEntity statusEntity);
    Long countAllByStatusEntity(StatusEntity statusEntity);
}
