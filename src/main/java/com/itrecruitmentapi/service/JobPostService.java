package com.itrecruitmentapi.service;

import com.itrecruitmentapi.entity.JobPostEntity;

public interface JobPostService {
    JobPostEntity getJobPostById(int id);
    JobPostEntity addJobPost(JobPostEntity jobPostEntity);
    JobPostEntity editJobPost(JobPostEntity jobPostEntity);
    void deleteJobPostById(int id);
}
