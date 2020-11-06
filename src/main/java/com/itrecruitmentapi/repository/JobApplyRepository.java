package com.itrecruitmentapi.repository;

import com.itrecruitmentapi.entity.CandidateResumeEntity;
import com.itrecruitmentapi.entity.JobApplyEntity;
import com.itrecruitmentapi.entity.JobPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobApplyRepository extends JpaRepository<JobApplyEntity, Integer> {
    @Query(
            value = "SELECT job_post_id FROM job_apply\n" +
                    "where account_id = :accountId\n" +
                    "and status_id = :statusId"
            ,
            nativeQuery = true
    )
    List<Integer> findJobPostIdsByCandidateResumeId(@Param("accountId") int accountId, @Param("statusId") int statusId);

    @Query(
            value = "SELECT account_id FROM job_apply\n" +
                    "where job_post_id = :jobPostId\n" +
                    "and status_id = :statusId"
            ,
            nativeQuery = true
    )
    List<Integer> findCandidateResumeIdsByJobPostId(@Param("jobPostId") int jobPostId, @Param("statusId") int statusId);

    Boolean existsJobApplyEntityByCandidateResumeEntityAndJobPostEntity(CandidateResumeEntity candidateResumeEntity, JobPostEntity jobPostEntity);
}
