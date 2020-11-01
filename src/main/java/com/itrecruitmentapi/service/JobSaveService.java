package com.itrecruitmentapi.service;

import com.itrecruitmentapi.entity.CandidateResumeEntity;
import com.itrecruitmentapi.entity.JobSaveEntity;

import java.util.List;

public interface JobSaveService {
    List<JobSaveEntity> getAllJobSavesByCandidate(CandidateResumeEntity candidateResumeEntity);
    JobSaveEntity addJobSave(JobSaveEntity jobSaveEntity);
    void deleteJobSave(int id);
}
