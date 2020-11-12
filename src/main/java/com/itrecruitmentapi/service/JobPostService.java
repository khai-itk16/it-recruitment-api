package com.itrecruitmentapi.service;

import com.itrecruitmentapi.entity.JobPostEntity;

import java.util.List;

public interface JobPostService {
    List<JobPostEntity> getAllJobPostByStatusJobPostId(int statusJobPostId);
    List<JobPostEntity> searchJobPosts(String keySearch);
    List<JobPostEntity> searchJobPosts(String keySearch, String provinceId);
    List<JobPostEntity> searchJobPosts(String keySearch, int positionId);
    List<JobPostEntity> searchJobPosts(String keySearch, String provinceId, int positionId);
    Long countAllJobPostsByStatus(int statusJobPostId);
    List<JobPostEntity> getAllJobPostByEmployerIdAndStatusJobPostId(int accountId, int statusJobPostId);
    JobPostEntity getJobPostById(int id);
    JobPostEntity addJobPost(JobPostEntity jobPostEntity);
    JobPostEntity editJobPost(JobPostEntity jobPostEntity);
    JobPostEntity changeStatusJobPost(int jobPostId, int statusJobPostId);
    void deleteJobPostById(int id);
}
