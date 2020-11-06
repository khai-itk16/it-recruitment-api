package com.itrecruitmentapi.service;

import com.itrecruitmentapi.entity.CandidateResumeEntity;
import com.itrecruitmentapi.entity.JobPostEntity;
import com.itrecruitmentapi.entity.JobSaveEntity;

import java.util.List;

public interface JobSaveService {
    List<JobSaveEntity> getAllJobSavesByCandidate(CandidateResumeEntity candidateResumeEntity);
    Boolean checkJobSaveExist(CandidateResumeEntity candidateResumeEntity, JobPostEntity jobPostEntity);
    JobSaveEntity addJobSave(JobSaveEntity jobSaveEntity);
    void deleteJobSaveById(int id);
    void deleteJobSave(CandidateResumeEntity candidateResumeEntity, JobPostEntity jobPostEntity);
}
