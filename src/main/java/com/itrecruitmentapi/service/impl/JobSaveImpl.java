package com.itrecruitmentapi.service.impl;

import com.itrecruitmentapi.controller.job_save.exception.JobSaveIsNotExistException;
import com.itrecruitmentapi.entity.CandidateResumeEntity;
import com.itrecruitmentapi.entity.JobSaveEntity;
import com.itrecruitmentapi.repository.JobSaveRepository;
import com.itrecruitmentapi.service.JobSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobSaveImpl implements JobSaveService {
    private final JobSaveRepository jobSaveRepository;

    @Override
    public List<JobSaveEntity> getAllJobSavesByCandidate(CandidateResumeEntity candidateResumeEntity) {
        return this.jobSaveRepository.findAllByCandidateResumeEntity(candidateResumeEntity);
    }

    @Override
    public JobSaveEntity addJobSave(JobSaveEntity jobSaveEntity) {
        return this.jobSaveRepository.save(jobSaveEntity);
    }

    @Override
    public void deleteJobSave(int id) {
        if(!this.jobSaveRepository.existsById(id)) {
            throw new JobSaveIsNotExistException(id);
        }
        this.jobSaveRepository.deleteById(id);
    }
}
