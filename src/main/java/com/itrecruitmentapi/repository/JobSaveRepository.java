package com.itrecruitmentapi.repository;

import com.itrecruitmentapi.entity.CandidateResumeEntity;
import com.itrecruitmentapi.entity.JobPostEntity;
import com.itrecruitmentapi.entity.JobSaveEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobSaveRepository extends JpaRepository<JobSaveEntity, Integer> {
    List<JobSaveEntity> findAllByCandidateResumeEntity(CandidateResumeEntity candidateResumeEntity);
    Boolean existsJobSaveEntityByCandidateResumeEntityAndJobPostEntity(CandidateResumeEntity candidateResumeEntity, JobPostEntity jobPostEntity);
    Optional<JobSaveEntity> findJobSaveEntityByCandidateResumeEntityAndJobPostEntity(CandidateResumeEntity candidateResumeEntity, JobPostEntity jobPostEntity);
}
