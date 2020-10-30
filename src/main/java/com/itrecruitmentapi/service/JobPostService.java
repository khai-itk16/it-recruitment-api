package com.itrecruitmentapi.service;

import com.itrecruitmentapi.entity.JobPostEntity;

import java.util.List;

public interface JobPostService {
    List<JobPostEntity> getAllJobPostByStatusJobPostId(int statusJobPostId);
    List<JobPostEntity> getAllJobPostByEmployerIdAndStatusJobPostId(int accountId, int statusJobPostId);
    JobPostEntity getJobPostById(int id);
    JobPostEntity addJobPost(JobPostEntity jobPostEntity);
    JobPostEntity editJobPost(JobPostEntity jobPostEntity);
    void deleteJobPostById(int id);
}
