package com.itrecruitmentapi.service.impl;

import com.itrecruitmentapi.controller.job_position.exception.JobPositionIsNotExistException;
import com.itrecruitmentapi.entity.JobPositionEntity;
import com.itrecruitmentapi.repository.JobPositionRepository;
import com.itrecruitmentapi.service.JobPositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobPositionServiceImpl implements JobPositionService {

    private final JobPositionRepository jobPositionRepository;

    @Override
    public List<JobPositionEntity> getAllJobPositions() {
        return this.jobPositionRepository.findAll();
    }

    @Override
    public Long countAllJobPositions() {
        return this.jobPositionRepository.count();
    }

    @Override
    public JobPositionEntity addJobPosition(JobPositionEntity jobPositionEntity) {
        return this.jobPositionRepository.save(jobPositionEntity);
    }

    @Override
    public JobPositionEntity editJobPosition(JobPositionEntity jobPositionEntity) {
        if(!this.jobPositionRepository.existsById(jobPositionEntity.getJobPositionId())) {
            throw new JobPositionIsNotExistException(jobPositionEntity.getJobPositionId());
        }
        return this.jobPositionRepository.save(jobPositionEntity);
    }

    @Override
    public void deleteJobPositionById(int id) {
        if(!this.jobPositionRepository.existsById(id)) {
            throw new JobPositionIsNotExistException(id);
        }
        this.jobPositionRepository.deleteById(id);
    }
}
