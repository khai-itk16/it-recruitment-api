package com.itrecruitmentapi.service.impl;

import com.itrecruitmentapi.controller.job_apply.exception.JobApplyIsNotExistException;
import com.itrecruitmentapi.entity.CandidateResumeEntity;
import com.itrecruitmentapi.entity.JobApplyEntity;
import com.itrecruitmentapi.entity.JobPostEntity;
import com.itrecruitmentapi.repository.CandidateResumeRepository;
import com.itrecruitmentapi.repository.JobApplyRepository;
import com.itrecruitmentapi.repository.JobPostRepository;
import com.itrecruitmentapi.service.JobApplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JobApplyServiceImpl implements JobApplyService {
    private final JobApplyRepository jobApplyRepository;
    private final CandidateResumeRepository candidateResumeRepository;
    private final JobPostRepository jobPostRepository;

    @Override
    public List<CandidateResumeEntity> getAllCandidateByJobPost(int jobPostId, int statusId) {
        List<Integer> candidateResumeIds = this.jobApplyRepository.findCandidateResumeIdsByJobPostId(jobPostId, statusId);
        List<CandidateResumeEntity> candidateResumeEntities = new ArrayList<>();
        candidateResumeIds.stream().forEach(accountId -> {
            CandidateResumeEntity candidateResumeEntity = this.candidateResumeRepository.findById(accountId).get();
            candidateResumeEntities.add(candidateResumeEntity);
        });

        return candidateResumeEntities;
    }

    @Override
    public List<JobPostEntity> getAllJobPostByCandidate(int accountId, int statusId) {
        List<Integer> jobPostIds = this.jobApplyRepository.findJobPostIdsByCandidateResumeId(accountId, statusId);
        List<JobPostEntity> jobPostEntities = new ArrayList<>();
        jobPostIds.stream().forEach(jobPostId -> {
            JobPostEntity jobPostEntity = this.jobPostRepository.findById(jobPostId).get();
            jobPostEntities.add(jobPostEntity);
        });
        return jobPostEntities;
    }

    @Override
    public Boolean checkIsApplyByCandidateAndJobPost(CandidateResumeEntity candidateResumeEntity, JobPostEntity jobPostEntity) {
        return this.jobApplyRepository.existsJobApplyEntityByCandidateResumeEntityAndJobPostEntity(
                candidateResumeEntity, jobPostEntity);
    }

    @Override
    public JobApplyEntity addJobApply(JobApplyEntity jobApplyEntity) {
        return this.jobApplyRepository.save(jobApplyEntity);
    }

    @Override
    public JobApplyEntity editJobApply(JobApplyEntity jobApplyEntity) {
        return this.jobApplyRepository.save(jobApplyEntity);
    }

    @Override
    public void deleteJobApply(int id) {
        if(!this.jobApplyRepository.existsById(id)) {
            throw new JobApplyIsNotExistException(id);
        }
        this.jobApplyRepository.deleteById(id);
    }
}
