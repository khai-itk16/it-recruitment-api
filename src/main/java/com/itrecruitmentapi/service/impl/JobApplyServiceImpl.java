package com.itrecruitmentapi.service.impl;

import com.itrecruitmentapi.controller.job_apply.exception.JobApplyIsNotExistException;
import com.itrecruitmentapi.entity.CandidateResumeEntity;
import com.itrecruitmentapi.entity.JobApplyEntity;
import com.itrecruitmentapi.entity.JobPostEntity;
import com.itrecruitmentapi.entity.StatusEntity;
import com.itrecruitmentapi.repository.CandidateResumeRepository;
import com.itrecruitmentapi.repository.JobApplyRepository;
import com.itrecruitmentapi.repository.JobPostRepository;
import com.itrecruitmentapi.service.JobApplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobApplyServiceImpl implements JobApplyService {
    private final JobApplyRepository jobApplyRepository;
    private final CandidateResumeRepository candidateResumeRepository;
    private final JobPostRepository jobPostRepository;

    @Override
    public List<JobApplyEntity> updateAllJobAppliesAfterFilter(List<JobApplyEntity> jobApplyEntities) {
        return this.jobApplyRepository.saveAll(jobApplyEntities);
    }

    @Override
    public List<JobApplyEntity> filterJobApplyCandidateStep1(int jobPostId) {
        List<JobApplyEntity> jobApplyEntities = this.getAllJobApplyByJobPostAndStatus(jobPostId, 5);
        Iterator itr = jobApplyEntities.iterator();
        while (itr.hasNext()) {
            JobApplyEntity jobApplyEntity = (JobApplyEntity)itr.next();
            JobPostEntity jobPostEntity = jobApplyEntity.getJobPostEntity();
            CandidateResumeEntity candidateResumeEntity = jobApplyEntity.getCandidateResumeEntity();
            if(jobPostEntity.getNumYearExperience() > candidateResumeEntity.getNumYearExperience()) {
                jobApplyEntity.setStatusEntity(new StatusEntity(7));
                this.jobApplyRepository.save(jobApplyEntity);
                itr.remove();
                continue;
            }
            if(jobPostEntity.getJobTypeEntity().getJobTypeId() != candidateResumeEntity.getJobTypeEntity().getJobTypeId()) {
                jobApplyEntity.setStatusEntity(new StatusEntity(7));
                this.jobApplyRepository.save(jobApplyEntity);
                itr.remove();
                continue;
            }
            if(jobPostEntity.getJobPositionEntity().getJobPositionId() != candidateResumeEntity.getJobPositionEntity().getJobPositionId()) {
                jobApplyEntity.setStatusEntity(new StatusEntity(7));
                this.jobApplyRepository.save(jobApplyEntity);
                itr.remove();
                continue;
            }
        }

        return jobApplyEntities;
    }

    @Override
    public List<JobApplyEntity> getAllJobApplyByJobPostAndStatus(int jobPostId, int statusId) {
        return this.jobApplyRepository.findJobApplyEntitiesByJobPostEntityAndStatusEntity(
                new JobPostEntity(jobPostId), new StatusEntity(statusId));
    }

    @Override
    public List<JobApplyEntity> getAllCandidateByJobPost(int jobPostId, int statusId) {

        return this.jobApplyRepository
                .findJobApplyEntitiesByJobPostEntityAndStatusEntityOrderByMatchPercentDesc(
                        new JobPostEntity(jobPostId), new StatusEntity(statusId));
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
    public void changeStatusJobApply(int jobApplyId, int statusId) {
        Optional<JobApplyEntity> optionalJobApplyEntity = this.jobApplyRepository.findById(jobApplyId);
        if(!optionalJobApplyEntity.isPresent()) {
            throw new JobApplyIsNotExistException(jobApplyId);
        }
        JobApplyEntity jobApplyEntityDB = optionalJobApplyEntity.get();
        jobApplyEntityDB.setStatusEntity(new StatusEntity(statusId));
        this.jobApplyRepository.save(jobApplyEntityDB);
    }

    @Override
    public void deleteJobApply(int id) {
        if(!this.jobApplyRepository.existsById(id)) {
            throw new JobApplyIsNotExistException(id);
        }
        this.jobApplyRepository.deleteById(id);
    }
}
