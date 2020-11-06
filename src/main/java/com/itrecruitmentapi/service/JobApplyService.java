package com.itrecruitmentapi.service;

import com.itrecruitmentapi.entity.CandidateResumeEntity;
import com.itrecruitmentapi.entity.JobApplyEntity;
import com.itrecruitmentapi.entity.JobPostEntity;

import java.util.List;

public interface JobApplyService {
    List<CandidateResumeEntity> getAllCandidateByJobPost(int jobPostId, int statusId);
    List<JobPostEntity> getAllJobPostByCandidate(int accountId, int statusId);
    Boolean checkIsApplyByCandidateAndJobPost(CandidateResumeEntity candidateResumeEntity, JobPostEntity jobPostEntity);
    JobApplyEntity addJobApply(JobApplyEntity jobApplyEntity);
    JobApplyEntity editJobApply(JobApplyEntity jobApplyEntity);
    void deleteJobApply(int id);
}
