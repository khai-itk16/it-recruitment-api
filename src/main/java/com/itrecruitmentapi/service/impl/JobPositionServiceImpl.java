package com.itrecruitmentapi.service.impl;

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
}
