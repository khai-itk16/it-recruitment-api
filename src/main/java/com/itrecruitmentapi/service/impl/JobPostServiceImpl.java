package com.itrecruitmentapi.service.impl;

import com.itrecruitmentapi.controller.job_post.exception.JobPostIsNotExistException;
import com.itrecruitmentapi.entity.EmployerResumeEntity;
import com.itrecruitmentapi.entity.JobPostEntity;
import com.itrecruitmentapi.entity.StatusEntity;
import com.itrecruitmentapi.repository.JobPostRepository;
import com.itrecruitmentapi.service.JobPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobPostServiceImpl implements JobPostService {
    private final JobPostRepository jobPostRepository;

    @Override
    public List<JobPostEntity> getAllJobPostByStatusJobPostId(int statusJobPostId) {
        return this.jobPostRepository.findJobPostEntitiesByStatusEntityOrderByCreatePostTimeDesc(new StatusEntity(statusJobPostId));
    }

    @Override
    public Long countAllJobPostsByStatus(int statusJobPostId) {
        return this.jobPostRepository.countAllByStatusEntity(new StatusEntity(statusJobPostId));
    }

    @Override
    public List<JobPostEntity> getAllJobPostByEmployerIdAndStatusJobPostId(int accountId, int statusJobPostId) {
        return this.jobPostRepository.findJobPostEntitiesByEmployerResumeEntityAndStatusEntityOrderByCreatePostTimeDesc(
                new EmployerResumeEntity(accountId), new StatusEntity(statusJobPostId)
        );
    }

    @Override
    public JobPostEntity getJobPostById(int id) {
        Optional<JobPostEntity> optionalJobPostEntity = this.jobPostRepository.findById(id);
        if(!optionalJobPostEntity.isPresent()) {
            throw new JobPostIsNotExistException(id);
        }
        return optionalJobPostEntity.get();
    }

    @Override
    public JobPostEntity addJobPost(JobPostEntity jobPostEntity) {
        return this.jobPostRepository.save(jobPostEntity);
    }

    @Override
    public JobPostEntity editJobPost(JobPostEntity jobPostEntity) {
        if(!this.jobPostRepository.existsById(jobPostEntity.getJobPostId())) {
            throw new JobPostIsNotExistException(jobPostEntity.getJobPostId());
        }
        return this.jobPostRepository.save(jobPostEntity);
    }

    @Override
    public JobPostEntity changeStatusJobPost(int jobPostId, int statusJobPostId) {
        Optional<JobPostEntity> optionalJobPostEntity = this.jobPostRepository.findById(jobPostId);
        if(!optionalJobPostEntity.isPresent()) {
            throw new JobPostIsNotExistException(jobPostId);
        }
        JobPostEntity jobPostEntity = optionalJobPostEntity.get();
        jobPostEntity.setStatusEntity(new StatusEntity(statusJobPostId));
        return this.jobPostRepository.save(jobPostEntity);
    }

    @Override
    public void deleteJobPostById(int id) {
        if(!this.jobPostRepository.existsById(id)) {
            throw new JobPostIsNotExistException(id);
        }
        this.jobPostRepository.deleteById(id);
    }
}
