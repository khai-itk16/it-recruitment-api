package com.itrecruitmentapi.service;

import com.itrecruitmentapi.entity.CandidateResumeEntity;
import com.itrecruitmentapi.entity.JobApplyEntity;
import com.itrecruitmentapi.entity.JobPostEntity;

import java.util.List;

public interface JobApplyService {
    List<JobApplyEntity> updateAllJobAppliesAfterFilter(List<JobApplyEntity> jobApplyEntities);
    List<JobApplyEntity> filterJobApplyCandidateStep1(int jobPostId);
    List<JobApplyEntity> getAllJobApplyByJobPostAndStatus(int jobPostId, int statusId);
    List<JobApplyEntity> getAllCandidateByJobPost(int jobPostId, int statusId);
    List<JobPostEntity> getAllJobPostByCandidate(int accountId, int statusId);
    Boolean checkIsApplyByCandidateAndJobPost(CandidateResumeEntity candidateResumeEntity, JobPostEntity jobPostEntity);
    JobApplyEntity addJobApply(JobApplyEntity jobApplyEntity);
    JobApplyEntity editJobApply(JobApplyEntity jobApplyEntity);
    void changeStatusJobApply(int jobApplyId, int statusId);
    void deleteJobApply(int id);
}
